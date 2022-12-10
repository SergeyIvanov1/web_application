package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;

import java.lang.Math;
import java.util.List;
import java.util.Random;

import com.ivanov_sergey.game.entity.Personage;
import com.ivanov_sergey.game.entity.Storage;
import com.ivanov_sergey.game.service.exceptions.LocationInvalidParameters;

public class FightingServiceImpl implements FightingService {

    private List<String> personageBloke;
    private List<String> personageAttack;
    Storage sessionRepo;
    Random random;

    public FightingServiceImpl() {
        random = new Random();
        personageBloke = List.of("head", "body", "legs");
        personageAttack = List.of("head", "body", "legs");
    }

//    public FightingServiceImpl(Storage sessionRepo) {
//        this.sessionRepo = sessionRepo;
//    }

    public String personageKickHero(Hero hero, Personage personage, String block) {
        checkParametersByNull(hero, personage, block);

        int personageRandomAttack = this.random.nextInt(personageAttack.size());

        if (personageAttack.get(personageRandomAttack).equals(block)) {
            return personage.getName() + " attack to " + personageAttack.get(personageRandomAttack)
                    + ". " + hero.getName() + " put block of " + block
                    + ". Damage by zero.";
        }
        int heroCurrentHealth = hero.getCurrentHealth() - personage.getStrength();
        hero.setCurrentHealth(Math.max(heroCurrentHealth, 0));

        return personage.getName() + " attack " + hero.getName() + " to " + personageAttack.get(personageRandomAttack)
                + ". But " + hero.getName() + " put block of "
                + block + ". Damage by " + personage.getStrength() + ".";
    }

    public String heroKickPersonage(Hero hero, Personage personage, String attack) {
        checkParametersByNull(hero, personage, attack);

        int personageRandomBlock = this.random.nextInt(personageBloke.size());

        if (personageBloke.get(personageRandomBlock).equals(attack)) {
            return personage.getName() + " put block of " + attack + ". Damage by zero.";
        }
        int personageCurrentHealth = personage.getCurrentHealth() - hero.getStrength();
        personage.setCurrentHealth(Math.max(personageCurrentHealth, 0));
        return hero.getName() + " attack " + personage.getName() + " to " + attack + ". But " + personage.getName() + " put block of "
                + personageBloke.get(personageRandomBlock) + ". Damage by " + hero.getStrength() + ".";
    }

    public void checkParametersByNull(Hero hero, Personage personage, String action) {
        if (hero == null) {
            throw new LocationInvalidParameters("Parameter: hero - is null");
        }
        if (personage == null) {
            throw new LocationInvalidParameters("Parameter: personage - is null");
        }
        if (action == null) {
            throw new LocationInvalidParameters("Parameter: action - is null");
        }
    }
}
