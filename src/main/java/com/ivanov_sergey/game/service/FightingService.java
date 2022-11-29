package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Personage;

public interface FightingService {

    public void personageKickHero(Hero hero, Personage personage, String block);
    public void heroKickPersonage(Hero hero, Personage personage, String attack);
}
