package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.dao.ModuleDAOImpl;
import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Inventory;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.repository.Repository;

import java.util.List;
import java.util.Optional;

public class ModuleServiceImpl implements ModuleService {
    ModuleDAOImpl moduleDAO = new ModuleDAOImpl();
    @Override
    public Location getLocation(int id) {
        return moduleDAO.getLocation(id);
    }

    @Override
    public Optional<Location> getLocation(String nextLocation) {
        return moduleDAO.getLocation(nextLocation);
    }

    @Override
    public Hero getOrCreateHero(String nameHero){
        Optional<Hero> optional = moduleDAO.getHero(nameHero);
        Hero hero;
        if (optional.isEmpty()) {
            hero = new Hero(nameHero);
            hero.initValuesOfFields();
            hero.setInventory(new Inventory(nameHero));
            moduleDAO.saveHero(hero);
        } else {
            hero = optional.get();
        }
        return hero;
    }

    @Override
    public void saveHero(Hero hero) {
        moduleDAO.saveHero(hero);
    }

    @Override
    public Integer increaseCountOfGame(Hero hero) {
        return moduleDAO.increaseCountOfGame(hero);
    }

    @Override
    public Repository fillRepositoryDBData(int id) {
        return moduleDAO.getRepository(id);
    }

    @Override
    public List<Hero> getAllHero() {
        return moduleDAO.getAllHero();
    }

}
