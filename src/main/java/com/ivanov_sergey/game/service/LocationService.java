package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.entity.Storage;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LocationService extends Storage {
    public String getClientIPAddress(HttpServletRequest request);
    public List<Armor> getArmors(String locationName);
    public List<Potion> getPotions(String locationName);
    public List<Helper> getHelpers(String locationName);
    public List<Weapon> getWeapons(String locationName);
    public Location getLocation(String locationName);
    public List<Location> getLocations();
    public Issue finishQuest(Helper helper, String lastLocation, Hero hero);
    public Storage getSessionRepo();
    public Personage getPersonage(String personageName, String lastLocation);
    public Issue getIssue(String personageName, String nextQuestion, String lastLocation);
    public Issue getFirstIssue(Personage personage, int index);
    public void toOpenWickets(List<Wicket> wickets);
    void passQuestToHero(String personageName, String lastLocation, Hero hero);

    Issue calculateIssue(String personage, Hero hero, String lastLocation);
}
