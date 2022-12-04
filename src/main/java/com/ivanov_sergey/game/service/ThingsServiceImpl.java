package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.*;

import javax.servlet.RequestDispatcher;
import java.util.Optional;

public class ThingsServiceImpl implements ThingsService{

    @Override
    public void transferThingFromBoxToInventory(String transferredThing, Location location, Hero hero) {

        Optional<Armor> optional = location.getArmors().stream()
                .filter((armor) -> transferredThing.equals(armor.getName()))
                .findFirst();
        Armor armor;
        if (optional.isPresent()){
            armor = optional.get();
            location.getArmors().remove(armor);
            hero.getInventory().getArmors().add(armor);
            return;
        }

        Optional<Potion> optional2 = location.getPotions().stream()
                .filter((potion) -> transferredThing.equals(potion.getName()))
                .findFirst();
        Potion potion;
        if (optional2.isPresent()){
            potion = optional2.get();
            location.getPotions().remove(potion);
            hero.getInventory().getPotions().add(potion);
            return;
        }

        Optional<Helper> optional3 = location.getHelpers().stream()
                .filter((helper) -> transferredThing.equals(helper.getName()))
                .findFirst();
        Helper helper;
        if (optional3.isPresent()){
            helper = optional3.get();
            location.getHelpers().remove(helper);
            hero.getInventory().getHelpers().add(helper);
            return;
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

    public void useThing(String thing, Location location, Hero hero){
        Optional<Potion> optional2 = hero.getInventory().getPotions().stream()
                .filter((potion) -> thing.equals(potion.getName()))
                .findFirst();
        Potion potion;
        if (optional2.isPresent()){
            usePotion(thing, location, hero);

            System.out.println("thing = " + thing);
            System.out.println("optional2 = " + optional2.get());
            System.out.println("thing = " + thing);
            return;
        }

//        if (useArmor != null){
//            useArmor(useArmor, location, hero);
//        }
//        if (usePotion != null){
//           usePotion(usePotion, location, hero);
//            req.setAttribute("lastLocation", nextLocationName);
//
//        }
//        if (useHelper != null){
//            useHelper(useHelper, location, hero);
//        }
//        if (useWeapon != null){
//            useWeapon(useWeapon, location, hero);
//        }
    }

    @Override
    public void useArmor(String useArmor, Location location, Hero hero) {

    }

    @Override
    public void usePotion(String usePotion, Location location, Hero hero) {
        if (hero.getCurrentHealth() < hero.getMaxHealth()){
            Optional<Potion> optional = hero.getInventory().getPotions().stream()
                    .filter((potion) -> usePotion.equals(potion.getName()))
                    .findFirst();
            if (optional.isPresent()){
                Potion potion = optional.get();
                hero.getInventory().getPotions().remove(potion);

                int currentHealth = hero.getCurrentHealth() + potion.getValue();
                if (currentHealth > hero.getMaxHealth()){
                    hero.setCurrentHealth(hero.getMaxHealth());
                } else {
                    System.out.println("currentHealth = " + currentHealth);
                    System.out.println("hero.getCurrentHealth() = " + hero.getCurrentHealth());


                    hero.setCurrentHealth(currentHealth);

                    System.out.println("hero.getCurrentHealth() = " + hero.getCurrentHealth());
                }
            }
        }
    }

    @Override
    public void useHelper(String useHelper, Location location, Hero hero) {

    }

    @Override
    public void useWeapon(String useWeapon, Location location, Hero hero) {

    }
}
