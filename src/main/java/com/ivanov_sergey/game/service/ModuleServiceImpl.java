package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.dao.ModuleDAOImpl;
import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.repository.Repository;

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
    public Optional<Hero> getHero(String nameHero){
        return moduleDAO.getHero(nameHero);
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
    public Repository getRepository(int id) {
        return moduleDAO.getRepository(id);
    }
}
