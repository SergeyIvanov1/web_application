package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.entity.Storage;
import com.ivanov_sergey.game.service.exceptions.LocationInvalidParameters;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class LocationServiceImpl implements LocationService {
    private static final int FIRST_QUEST = 0;
    private final int INITIAL_INDEX = 0;
    Storage sessionRepo;

    public LocationServiceImpl(Storage sessionRepo) {
        this.sessionRepo = sessionRepo;
    }

    public String getClientIPAddress(HttpServletRequest request) {
        String remoteAddress = "";
        if (request != null) {
            remoteAddress = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddress == null || "".equals(remoteAddress)) {
                remoteAddress = request.getRemoteAddr();
            }
        }
        return remoteAddress;
    }

    @Override
    public List<Armor> getArmors(String locationName) {
        checkParameterByNull(locationName);

        return getLocation(locationName).getArmors();
    }

    @Override
    public List<Potion> getPotions(String locationName) {
        checkParameterByNull(locationName);
        return getLocation(locationName).getPotions();
    }

    @Override
    public List<Helper> getHelpers(String locationName) {
        checkParameterByNull(locationName);
        return getLocation(locationName).getHelpers();
    }

    @Override
    public List<Weapon> getWeapons(String locationName) {
        checkParameterByNull(locationName);
        return getLocation(locationName).getWeapons();
    }

    public Location getLocation(String locationName) {
        checkParameterByNull(locationName);
        Optional<Location> optional = sessionRepo.getLocations()
                .stream()
                .filter((location) -> locationName.equals(location.getName()))
                .findFirst();

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Location is not found. LocationName = " + locationName);
        }
    }

    @Override
    public List<Location> getLocations() {
        return sessionRepo.getLocations();
    }

    @Override
    public void passQuestToHero(String personageName, String lastLocation, Hero hero) {
        Personage personage = getPersonage(personageName, lastLocation);
        List<Quest> personageQuests = personage.getQuests();
        if (!personageQuests.isEmpty()) {
            Quest quest = personageQuests.remove(FIRST_QUEST);
            hero.getQuests().add(quest);
        }
    }

    @Override
    public Issue calculateIssue(String personageName, Hero hero, String lastLocation) {
        System.out.println("calculateIssue: " + personageName + ", " + hero + ", " + lastLocation);
        Issue issue;
        Personage personage = getPersonage(personageName, lastLocation);
        Inventory inventory = hero.getInventory();
        List<Helper> helpers = inventory.getHelpers();
        for (Helper helper : helpers) {
            System.out.println("fore");
            if (helper.getName().equals("present") && personageName.equals("Forester")) {
                issue = finishQuest(helper, lastLocation, hero);
                return issue;
            } else if (helper.getName().equals("cookie") && personageName.equals("Tramp")) {
                issue = finishQuest(helper, lastLocation, hero);
                return issue;
            }
        }
        issue = getFirstIssue(personage, INITIAL_INDEX);
        System.out.println("issue = " + issue);
        return issue;
    }

    public Issue finishQuest(Helper helper, String lastLocation, Hero hero) {
        Issue issue = helper.getIssuesForQuest().get(INITIAL_INDEX);
        hero.getInventory().getHelpers().remove(helper);

        Location location = getLocation(lastLocation);
        for (Wicket wicket: location.getWickets()) {
            wicket.setIsOpened(true);
        }

        return issue;
    }

    public Storage getSessionRepo() {
        return sessionRepo;
    }

    public Personage getPersonage(String personageName, String lastLocation) {

        Optional<Personage> optional = getLocation(lastLocation)
                .getPersonages()
                .stream()
                .filter(personage -> personageName.equals(personage.getName()))
                .findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Personage is not found. LastLocation = " + lastLocation +
                    ", personageName = " + personageName);
        }
    }

    public Issue getIssue(String personageName, String nextQuestion, String lastLocation) {
        Optional<Issue> optional = getPersonage(personageName, lastLocation)
                .getIssues()
                .stream()
                .filter(issue -> nextQuestion.equals(issue.getText()))
                .findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Issue is not found. LastLocation = " + lastLocation +
                    ", personageName = " + personageName +
                    ", nextQuestion = " + nextQuestion);
        }
    }

    public Issue getFirstIssue(Personage personage, int index) {
        if (personage == null) {
            throw new LocationInvalidParameters("First parameter - personage is null");
        }
        if (index < 0) {
            throw new LocationInvalidParameters("Second parameter - index is negative");
        }

        Issue issue;
        try {
            issue = personage.getIssues().get(index);
        } catch (IndexOutOfBoundsException ex) {
            throw new LocationInvalidParameters("Parameter index is out of list range", ex);
        }
        return issue;
    }

    public void toOpenWickets(List<Wicket> wickets) {
        wickets.forEach((wicket -> wicket.setIsOpened(true)));
    }


    private void checkParameterByNull(String parameter) {
        if (parameter == null) {
            throw new LocationInvalidParameters("Parameter is null");
        }
    }
}
