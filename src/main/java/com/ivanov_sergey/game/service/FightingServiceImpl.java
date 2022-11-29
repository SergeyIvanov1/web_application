package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;
import java.lang.Math;
import java.util.List;
import java.util.Random;

import com.ivanov_sergey.game.entity.Personage;
import com.ivanov_sergey.game.repository.Storage;
import com.ivanov_sergey.game.service.exceptions.LocationInvalidParameters;

public class FightingServiceImpl implements FightingService {

    private List<String> personageBloke;
    private List<String> personageAttack;
    Storage repository;
    Random random;

    public FightingServiceImpl() {
        random = new Random();
        personageBloke = List.of("head", "body", "legs");
        personageAttack = List.of("head", "body", "legs");
    }

    public FightingServiceImpl(Storage repository) {
        this.repository = repository;
    }

    public void personageKickHero(Hero hero, Personage personage, String block) {
        checkParametersByNull(hero, personage, block);

        int personageRandomAttack = this.random.nextInt(personageAttack.size());

        if (personageAttack.get(personageRandomAttack).equals(block)){
            System.out.println("return");
            return;
        }
        System.out.println("block = " + block);
        System.out.println("personageRandomAttack = " + personageRandomAttack);
        System.out.println("personageRandomAttack = " + personageAttack.get(personageRandomAttack));

        int heroCurrentHealth = hero.getCurrentHealth() - personage.getStrength();
        hero.setCurrentHealth(Math.max(heroCurrentHealth, 0));
    }

    public void heroKickPersonage(Hero hero, Personage personage, String attack) {
        checkParametersByNull(hero, personage, attack);

        int personageRandomBlock = this.random.nextInt(personageBloke.size());

        if (personageBloke.get(personageRandomBlock).equals(attack)){
            System.out.println("return");

            return;
        }
        System.out.println("attack = " + attack);
        System.out.println("personageRandomBlock = " + personageRandomBlock);
        System.out.println("personageRandomBlock = " + personageBloke.get(personageRandomBlock));

        int personageCurrentHealth = personage.getCurrentHealth() - hero.getStrength();
        personage.setCurrentHealth(Math.max(personageCurrentHealth, 0));
    }

    public void checkParametersByNull(Hero hero, Personage personage, String action) {
        if (hero == null){
            throw new LocationInvalidParameters("Parameter: hero - is null");
        }
        if (personage == null){
            throw new LocationInvalidParameters("Parameter: personage - is null");
        }
        if (action == null){
            throw new LocationInvalidParameters("Parameter: action - is null");
        }
    }
}
