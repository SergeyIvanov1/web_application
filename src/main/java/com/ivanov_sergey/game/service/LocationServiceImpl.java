package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.entity.Storage;
import com.ivanov_sergey.game.service.exceptions.InvalidParameters;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocationServiceImpl implements LocationService {
    private static final int FIRST_QUEST = 0;
    private final int INITIAL_INDEX = 0;
    private Storage sessionRepo;

    public LocationServiceImpl(Storage sessionRepo) {
        this.sessionRepo = sessionRepo;
    }

    public String getClientIPAddress(HttpServletRequest request) {
        if (request == null) {
            throw new InvalidParameters("Parameter: request - is null");
        }
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
        Optional<Location> locationOptional = sessionRepo.getLocations()
                .stream()
                .filter((location) -> locationName.equals(location.getName()))
                .findFirst();

        if (locationOptional.isPresent()) {
            return locationOptional.get();
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
        checkParametersByNull(personageName, lastLocation, hero);
        Personage personage = getPersonage(personageName, lastLocation);
        List<Quest> personageQuests = personage.getQuests();
        if (!personageQuests.isEmpty()) {
            Quest quest = personageQuests.remove(FIRST_QUEST);
            hero.getQuests().add(quest);
        }
    }

    @Override
    public Issue calculateIssue(String personageName, Hero hero, String lastLocation) {
        checkParametersByNull(personageName, lastLocation, hero);
        Issue issue;
        Personage personage = getPersonage(personageName, lastLocation);
        Inventory inventory = hero.getInventory();
        List<Helper> helpers = inventory.getHelpers();
        for (Helper helper : helpers) {
            if (helper.getName().equals("present") && personageName.equals("Forester")) {
                issue = finishQuest(helper, lastLocation, hero);
                updateIssues(hero, personage);
                return issue;
            } else if (helper.getName().equals("cookie") && personageName.equals("Tramp")) {
                issue = finishQuest(helper, lastLocation, hero);
                updateIssues(hero, personage);
                return issue;
            }
        }

        issue = getFirstIssue(personage, INITIAL_INDEX);
        return issue;
    }

    public Issue finishQuest(Helper helper, String lastLocation, Hero hero) {
        if (helper == null) {
            throw new InvalidParameters("Parameter: helper - is null");
        }
        if (lastLocation == null) {
            throw new InvalidParameters("Parameter: lastLocation - is null");
        }
        if (hero == null) {
            throw new InvalidParameters("Parameter: hero - is null");
        }
        Issue issue = helper.getIssuesForQuest().get(INITIAL_INDEX);
        hero.getInventory().getHelpers().remove(helper);
        Location location = getLocation(lastLocation);
        toOpenWickets(location.getWickets());
        return issue;
    }

    public Storage getSessionRepo() {
        return sessionRepo;
    }

    public Personage getPersonage(String personageName, String lastLocation) {
        if (personageName == null) {
            throw new InvalidParameters("Parameter: personageName - is null");
        }
        if (lastLocation == null) {
            throw new InvalidParameters("Parameter: lastLocation - is null");
        }
        Optional<Personage> personageOptional = getLocation(lastLocation)
                .getPersonages()
                .stream()
                .filter(personage -> personage.getName().equals(personageName))
                .findFirst();
        if (personageOptional.isPresent()) {
            return personageOptional.get();
        } else {
            throw new RuntimeException("Personage is not found. LastLocation = " + lastLocation +
                    ", personageName = " + personageName);
        }
    }

    public Issue getIssue(String personageName, String nextQuestion, String lastLocation) {
        if (personageName == null) {
            throw new InvalidParameters("Parameter: personageName - is null");
        }
        if (nextQuestion == null) {
            throw new InvalidParameters("Parameter: nextQuestion - is null");
        }
        if (lastLocation == null) {
            throw new InvalidParameters("Parameter: lastLocation - is null");
        }
        Optional<Issue> issueOptional = getPersonage(personageName, lastLocation)
                .getIssues()
                .stream()
                .filter(issue -> nextQuestion.equals(issue.getText()))
                .findFirst();
        if (issueOptional.isPresent()) {
            return issueOptional.get();
        } else {
            throw new RuntimeException("Issue not found. LastLocation = " + lastLocation +
                    ", personageName = " + personageName +
                    ", nextQuestion = " + nextQuestion);
        }
    }

    public Issue getFirstIssue(Personage personage, int index) {
        if (personage == null) {
            throw new InvalidParameters("First parameter - personage is null");
        }
        if (index < 0) {
            throw new InvalidParameters("Second parameter - index is negative");
        }

        Issue issue;
        try {
            issue = personage.getIssues().get(index);
        } catch (IndexOutOfBoundsException ex) {
            throw new InvalidParameters("Parameter index is out of list range", ex);
        }
        return issue;
    }

    public void toOpenWickets(List<Wicket> wickets) {
        if (wickets == null) {
            throw new InvalidParameters("Parameter - wickets is null");
        }
        wickets.forEach((wicket -> wicket.setIsOpened(true)));
    }

    private void checkParameterByNull(String parameter) {
        if (parameter == null) {
            throw new InvalidParameters("Parameter is null");
        }
    }

    private void checkParametersByNull(String parameter, String stringParameter, Hero hero) {
        if (parameter == null) {
            throw new InvalidParameters("Parameter is null");
        }
        if (stringParameter == null) {
            throw new InvalidParameters("Parameter  is null");
        }
        if (hero == null) {
            throw new InvalidParameters("Parameter hero is null");
        }

    }

    private static void updateIssues(Hero hero, Personage personage) {
        personage.getIssues().clear();
        List<Reply> replies = new ArrayList<>();
        replies.add(new Reply("Ok"));
        Issue issue1 = new Issue("I have nothing to tell you.", replies);
        personage.getIssues().add(issue1);
        hero.getQuests().clear();
    }
}
