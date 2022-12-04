package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.*;

import javax.servlet.RequestDispatcher;
import java.util.List;
import java.util.Optional;

public class ThingsServiceImpl implements ThingsService{
    private final int ZERO_INDEX = 0;

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
        if (optional2.isPresent()) {
            potion = optional2.get();
            location.getPotions().remove(potion);
            hero.getInventory().getPotions().add(potion);
            return;
        }

        Optional<Helper> optional3 = location.getHelpers().stream()
                .filter((helper) -> transferredThing.equals(helper.getName()))
                .findFirst();
        Helper helper;
        if (optional3.isPresent()) {
            helper = optional3.get();
            location.getHelpers().remove(helper);
            hero.getInventory().getHelpers().add(helper);
            return;
        }

        Optional<Weapon> optional4 = location.getWeapons().stream()
                .filter((weapon) -> transferredThing.equals(weapon.getName()))
                .findFirst();
        Weapon weapon;
        if (optional4.isPresent()) {
            weapon = optional4.get();
            location.getWeapons().remove(weapon);
            hero.getInventory().getWeapons().add(weapon);
        }
    }

    public String useThing(String thing, Location location, Hero hero) {
        String report = "";
        Optional<Armor> optional = hero.getInventory().getArmors().stream()
                .filter((armor) -> thing.equals(armor.getName()))
                .findFirst();
        if (optional.isPresent()) {
            report = useArmor(thing, location, hero);
            return report;
        }

        Optional<Potion> optional2 = hero.getInventory().getPotions().stream()
                .filter((potion) -> thing.equals(potion.getName()))
                .findFirst();
        if (optional2.isPresent()) {
            report = usePotion(thing, location, hero);
            return report;
        }

        Optional<Weapon> optional3 = hero.getInventory().getWeapons().stream()
                .filter((weapon) -> thing.equals(weapon.getName()))
                .findFirst();
        if (optional3.isPresent()) {
            report = useWeapon(thing, location, hero);
            return report;
        }
        return report;
    }

    @Override
    public String useArmor(String useArmor, Location location, Hero hero) {
        Optional<Armor> optional = hero.getInventory().getArmors().stream()
                .filter((armor) -> useArmor.equals(armor.getName()))
                .findFirst();
        Armor armor;
        if (optional.isPresent()) {
            armor = optional.get();
            int newDexterity = hero.getDexterity() + armor.getValue();
            hero.setDexterity(newDexterity);
            hero.getInventory().getArmors().remove(armor);
            hero.getUsingArmors().add(armor);
            return hero.getName() + "is using " + armor.getName()
                    + ". Dexterity increase by " + armor.getValue() + ".";
        }
        return "";
    }

    @Override
    public String usePotion(String usePotion, Location location, Hero hero) {
        if (hero.getCurrentHealth() < hero.getMaxHealth()) {
            Optional<Potion> optional = hero.getInventory().getPotions().stream()
                    .filter((potion) -> usePotion.equals(potion.getName()))
                    .findFirst();
            if (optional.isPresent()) {
                Potion potion = optional.get();
                hero.getInventory().getPotions().remove(potion);

                int currentHealth = hero.getCurrentHealth() + potion.getValue();
                if (currentHealth > hero.getMaxHealth()) {
                    hero.setCurrentHealth(hero.getMaxHealth());
                    return hero.getName() + " used " + usePotion + "(+" + potion.getValue() + "). \nHealth is max.";
                } else {
                    hero.setCurrentHealth(currentHealth);
                    return hero.getName() + " used " + usePotion + "(+" + potion.getValue() + "). \nHealth is " + currentHealth;
                }
            }
        }
        return hero.getName() + " can't use " + usePotion + ". \nHealth is max.";
    }

    @Override
    public void useHelper(String useHelper, Location location, Hero hero) {

    }

    @Override
    public String useWeapon(String useWeapon, Location location, Hero hero) {
        Optional<Weapon> optional = hero.getInventory().getWeapons().stream()
                .filter((armor) -> useWeapon.equals(armor.getName()))
                .findFirst();
        Weapon weapon;
        if (optional.isPresent()) {
            List<Weapon> usingWeapons = hero.getUsingWeapons();
            if ( usingWeapons.size() > 0){
                Weapon removedWeapon = usingWeapons.remove(ZERO_INDEX);
                hero.getInventory().getWeapons().add(removedWeapon);
                int Strength = hero.getStrength() - removedWeapon.getValue();
                hero.setStrength(Strength);
            }
            weapon = optional.get();
            int newStrength = hero.getStrength() + weapon.getValue();
            hero.setStrength(newStrength);
            hero.getInventory().getWeapons().remove(weapon);


            usingWeapons.add(weapon);
            return hero.getName() + " is using " + weapon.getName()
                    + ". Strength increase by " + weapon.getValue() + ".";
        }
        return "";
    }
}
