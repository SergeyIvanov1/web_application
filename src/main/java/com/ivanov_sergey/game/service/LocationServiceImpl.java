package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.entity.Storage;
import com.ivanov_sergey.game.service.exceptions.LocationInvalidParameters;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class LocationServiceImpl implements LocationService {
    Storage repository;

    public LocationServiceImpl(Storage repository) {
        this.repository = repository;
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
        Optional<Location> optional = repository.getLocations()
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
        return repository.getLocations();
    }

    public Storage getRepository() {
        return repository;
    }

    public Personage getPersonage(String personageName, String lastLocation){

        System.out.println("LocationServiceImpl, getPersonage, lastLocation = " + lastLocation);
        System.out.println("LocationServiceImpl, getPersonage, personageName = " + personageName);

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

    public Issue getIssue(String personageName, String nextQuestion, String lastLocation){
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

    public Issue getFirstIssue(Personage personage, int index){
        if (personage == null){throw new LocationInvalidParameters("First parameter - personage is null");}
        if (index < 0){throw new LocationInvalidParameters("Second parameter - index is negative");}

        Issue issue;
        try {
            issue = personage.getIssues().get(index);
        } catch (IndexOutOfBoundsException ex){
            throw new LocationInvalidParameters("Parameter index is out of list range", ex);
        }
        return issue;
    }

    public void checkParameterByNull(String parameter) {
        if (parameter == null){
            throw new LocationInvalidParameters("Parameter is null");
        }
    }
}
