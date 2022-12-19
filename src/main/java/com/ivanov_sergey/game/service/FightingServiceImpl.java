package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;

import java.lang.Math;
import java.util.List;
import java.util.Random;

import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.entity.Personage;
import com.ivanov_sergey.game.entity.Storage;
import com.ivanov_sergey.game.service.exceptions.LocationInvalidParameters;

public class FightingServiceImpl implements FightingService {

    private final List<String> personageBloke;
    private final List<String> personageAttack;
    private final Storage sessionRepo;
    private final Random random;

    public FightingServiceImpl(Storage sessionRepo) {
        this.sessionRepo = sessionRepo;
        random = new Random();
        personageBloke = List.of("head", "body", "legs");
        personageAttack = List.of("head", "body", "legs");
    }

    public String personageKickHero(Hero hero, Personage personage, String block) {
        checkParametersByNull(hero, personage, block);

        int personageRandomAttack = this.random.nextInt(personageAttack.size());
        int randomChanceToDodge = this.random.nextInt(0, 100);

        if (hero.getDexterity() > randomChanceToDodge) {
            return "Your dexterity equals " + hero.getDexterity()  + ". It allow you to be agile and dodges a direct hit. Damage by zero.";
        }

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
        int randomChanceToDodge = this.random.nextInt(0, 100);

        if (personage.getDexterity() > randomChanceToDodge) {
            return personage.getName() + " is agile and dodges a direct hit. Damage by zero.";
        }

        if (personageBloke.get(personageRandomBlock).equals(attack)) {
            return personage.getName() + " put block of " + attack + ". Damage by zero.";
        }
        int personageCurrentHealth = personage.getCurrentHealth() - hero.getStrength();
        personage.setCurrentHealth(Math.max(personageCurrentHealth, 0));
        return hero.getName() + " attack " + personage.getName() + " to " + attack + ". But " + personage.getName()
                + " mistakenly put block of "
                + personageBloke.get(personageRandomBlock) + ", damage is " + hero.getStrength() + ".";
    }

    @Override
    public void deletePersonage(Personage personage, Location location) {
        if (personage == null) {
            throw new LocationInvalidParameters("Parameter: personage - is null");
        }
        if (location == null) {
            throw new LocationInvalidParameters("Parameter: location - is null");
        }
        location.getPersonages().remove(personage);
    }

    private void checkParametersByNull(Hero hero, Personage personage, String action) {
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
