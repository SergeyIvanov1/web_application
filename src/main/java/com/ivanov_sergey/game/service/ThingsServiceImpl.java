package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.service.exceptions.InvalidParameters;

import java.util.List;
import java.util.Optional;

public class ThingsServiceImpl implements ThingsService{
    private final int ZERO_INDEX = 0;

    @Override
    public void transferThingFromBoxToInventory(String transferredThing, Location location, Hero hero) {
        checkParametersByNull(transferredThing, location, hero);
        Inventory inventory = hero.getInventory();
        Optional<Armor> armorOptional = location.getArmors().stream()
                .filter((armor) -> transferredThing.equals(armor.getName()))
                .findFirst();
        Armor armor;
        if (armorOptional.isPresent()){
            armor = armorOptional.get();
            location.getArmors().remove(armor);

            List<Armor> armors = inventory.getArmors();
            armors.add(armor);
            return;
        }

        Optional<Potion> potionOptional = location.getPotions().stream()
                .filter((potion) -> transferredThing.equals(potion.getName()))
                .findFirst();
        Potion potion;
        if (potionOptional.isPresent()) {
            potion = potionOptional.get();
            location.getPotions().remove(potion);
            List<Potion> potions = inventory.getPotions();
            potions.add(potion);
            return;
        }

        Optional<Helper> helperOptional = location.getHelpers().stream()
                .filter((helper) -> transferredThing.equals(helper.getName()))
                .findFirst();
        Helper helper;
        if (helperOptional.isPresent()) {
            helper = helperOptional.get();
            location.getHelpers().remove(helper);
            List<Helper> helpers = inventory.getHelpers();
            helpers.add(helper);
            return;
        }

        Optional<Weapon> weaponOptional = location.getWeapons().stream()
                .filter((weapon) -> transferredThing.equals(weapon.getName()))
                .findFirst();
        Weapon weapon;
        if (weaponOptional.isPresent()) {
            weapon = weaponOptional.get();
            location.getWeapons().remove(weapon);
            List<Weapon> weapons = inventory.getWeapons();
            weapons.add(weapon);
        }
    }

    public String useThing(String thing, Location location, Hero hero) {
        checkParametersByNull(thing, location, hero);

        String report = "";
        Optional<Armor> armorOptional = hero.getInventory().getArmors().stream()
                .filter((armor) -> thing.equals(armor.getName()))
                .findFirst();
        if (armorOptional.isPresent()) {
            report = useArmor(thing, location, hero);
            return report;
        }

        Optional<Potion> optionalPotion = hero.getInventory().getPotions().stream()
                .filter((potion) -> thing.equals(potion.getName()))
                .findFirst();
        if (optionalPotion.isPresent()) {
            report = usePotion(thing, location, hero);
            return report;
        }

        Optional<Weapon> optionalWeapon = hero.getInventory().getWeapons().stream()
                .filter((weapon) -> thing.equals(weapon.getName()))
                .findFirst();
        if (optionalWeapon.isPresent()) {
            report = useWeapon(thing, location, hero);
            return report;
        }
        return report;
    }

    @Override
    public String useArmor(String useArmor, Location location, Hero hero) {
        checkParametersByNull(useArmor, location, hero);

        Optional<Armor> optionalArmor = hero.getInventory().getArmors().stream()
                .filter((armor) -> useArmor.equals(armor.getName()))
                .findFirst();
        Armor armor;
        if (optionalArmor.isPresent()) {
            armor = optionalArmor.get();
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
        checkParametersByNull(usePotion, location, hero);

        if (hero.getCurrentHealth() < hero.getMaxHealth()) {
            Optional<Potion> optionalPotion = hero.getInventory().getPotions().stream()
                    .filter((potion) -> usePotion.equals(potion.getName()))
                    .findFirst();
            if (optionalPotion.isPresent()) {
                Potion potion = optionalPotion.get();
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
    public void useKey(String helperName, Location location, Hero hero) {
        checkParametersByNull(helperName, location, hero);

        Optional<Helper> optionalHelper = hero.getInventory().getHelpers().stream()
                .filter(helper -> helperName.equals(helper.getName()))
                .findFirst();
        Helper helper;
        if (optionalHelper.isPresent()) {
            helper = optionalHelper.get();
            hero.getInventory().getHelpers().remove(helper);
        }
    }

    @Override
    public String useWeapon(String useWeapon, Location location, Hero hero) {
        checkParametersByNull(useWeapon, location, hero);

        Optional<Weapon> optionalWeapon = hero.getInventory().getWeapons().stream()
                .filter((armor) -> useWeapon.equals(armor.getName()))
                .findFirst();
        Weapon weapon;
        if (optionalWeapon.isPresent()) {
            List<Weapon> usingWeapons = hero.getUsingWeapons();
            if ( usingWeapons.size() > 0){
                Weapon removedWeapon = usingWeapons.remove(ZERO_INDEX);
                hero.getInventory().getWeapons().add(removedWeapon);
                int Strength = hero.getStrength() - removedWeapon.getValue();
                hero.setStrength(Strength);
            }
            weapon = optionalWeapon.get();
            int newStrength = hero.getStrength() + weapon.getValue();
            hero.setStrength(newStrength);
            hero.getInventory().getWeapons().remove(weapon);


            usingWeapons.add(weapon);
            return hero.getName() + " is using " + weapon.getName()
                    + ". Strength increase by " + weapon.getValue() + ".";
        }
        return "";
    }

    private void checkParametersByNull(String parameter, Location location, Hero hero) {
        if (parameter == null) {
            throw new InvalidParameters("First parameter is null");
        }
        if (location == null) {
            throw new InvalidParameters("Parameter location is null");
        }
        if (hero == null) {
            throw new InvalidParameters("Parameter hero is null");
        }
    }
}
