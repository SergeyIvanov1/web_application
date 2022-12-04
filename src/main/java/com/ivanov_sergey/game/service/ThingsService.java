package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Location;

public interface ThingsService {
    void transferThingFromBoxToInventory(String transferredThing, Location location, Hero hero);

    void useArmor(String getThingOut, Location location, Hero hero);

    void usePotion(String usePotion, Location location, Hero hero);

    void useHelper(String useHelper, Location location, Hero hero);

    void useWeapon(String useWeapon, Location location, Hero hero);

    public void useThing(String thing, Location location, Hero hero);
}
