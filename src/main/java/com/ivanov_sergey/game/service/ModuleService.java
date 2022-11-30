package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ModuleService {
    public Location getLocation(int id);
    public Optional<Location> getLocation(String nextLocation);
    public Hero getOrCreateHero(String nameHero);
    public void saveHero(Hero hero);
    public Integer increaseCountOfGame(Hero visitor);
    public Repository fillRepositoryDBData(int id);
    public List<Hero> getAllHero();
}
