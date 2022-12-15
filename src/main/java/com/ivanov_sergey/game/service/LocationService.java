package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.entity.Storage;

import java.util.List;

public interface LocationService extends Storage {
    public List<Armor> getArmors(String locationName);
    public List<Potion> getPotions(String locationName);
    public List<Helper> getHelpers(String locationName);
    public List<Weapon> getWeapons(String locationName);
    public Location getLocation(String locationName);
    public List<Location> getLocations();
    public Storage getSessionRepo();
    public void toOpenWickets(List<Wicket> wickets);
}
