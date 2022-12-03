package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Location;

public interface ThingsService {
    void transferThingToInventory(String transferredThing, Location location, Hero hero);
}
