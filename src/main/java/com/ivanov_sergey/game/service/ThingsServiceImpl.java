package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.*;

import java.util.Optional;

public class ThingsServiceImpl implements ThingsService{

    @Override
    public void transferThingToInventory(String transferredThing, Location location, Hero hero) {

        Optional<Armor> optional = location.getArmors().stream()
                .filter((armor) -> transferredThing.equals(armor.getName()))
                .findFirst();
        Armor armor;
        if (optional.isPresent()){
            armor = optional.get();
            location.getArmors().remove(armor);
            hero.getInventory().getArmors().add(armor);
        }

        Optional<Potion> optional2 = location.getPotions().stream()
                .filter((potion) -> transferredThing.equals(potion.getName()))
                .findFirst();
        Potion potion;
        if (optional2.isPresent()){
            potion = optional2.get();
            location.getPotions().remove(potion);
            hero.getInventory().getPotions().add(potion);
        }

        Optional<Helper> optional3 = location.getHelpers().stream()
                .filter((helper) -> transferredThing.equals(helper.getName()))
                .findFirst();
        Helper helper;
        if (optional3.isPresent()){
            helper = optional3.get();
            location.getHelpers().remove(helper);
            hero.getInventory().getHelpers().add(helper);
        }

        Optional<Weapon> optional4 = location.getWeapons().stream()
                .filter((weapon) -> transferredThing.equals(weapon.getName()))
                .findFirst();
        Weapon weapon;
        if (optional4.isPresent()){
            weapon = optional4.get();
            location.getWeapons().remove(weapon);
            hero.getInventory().getWeapons().add(weapon);
        }
    }
}
