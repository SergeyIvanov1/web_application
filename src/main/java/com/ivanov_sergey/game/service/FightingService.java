package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.entity.Personage;

public interface FightingService {

    public String personageKickHero(Hero hero, Personage personage, String block);
    public String heroKickPersonage(Hero hero, Personage personage, String attack);

    void deletePersonage(Personage personage, Location location);
}
