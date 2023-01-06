package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.dao.ModuleDAOImpl;
import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.service.exceptions.InvalidParameters;
import org.hibernate.SessionFactory;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class ModuleServiceImpl implements ModuleService {
    private ModuleDAOImpl moduleDAO;

    public ModuleServiceImpl(SessionFactory sessionFactory) {
        moduleDAO = new ModuleDAOImpl(sessionFactory);
    }

    @Override
    public Location getLocation(int id) {
        if (id < 0) {
            throw new InvalidParameters("Parameter: id - is negative");
        }
        return moduleDAO.getLocation(id);
    }

    @Override
    public Optional<Location> getLocation(String nextLocation) {
        if (nextLocation == null) {
            throw new InvalidParameters("Parameter: nextLocation - is null");
        }
        return moduleDAO.getLocation(nextLocation);
    }

    @Override
    public Hero getOrCreateHero(String nameHero){
        if (nameHero == null){
            throw new InvalidParameters("Parameter nameHero is null");
        }
        Optional<Hero> optionalHero = moduleDAO.getHero(nameHero);
        Hero hero;
        if (optionalHero.isEmpty()) {
            hero = new Hero(nameHero);
            hero.initValuesOfFields();
            hero.setInventory(new Inventory(nameHero));
            moduleDAO.saveHero(hero);
        } else {
            hero = optionalHero.get();
        }
        return hero;
    }

    @Override
    public void saveHero(Hero hero) {
        if (hero == null){
            throw new InvalidParameters("Parameter hero is null");
        }
        moduleDAO.saveHero(hero);
    }

    @Override
    public Integer increaseCountOfGame(Hero hero) {
        if (hero == null){
            throw new InvalidParameters("Parameter hero is null");
        }
        return moduleDAO.increaseCountOfGame(hero);
    }

    @Override
    public Repository fillRepositoryDBData(int id) {
        if (id < 0) {
            throw new InvalidParameters("Parameter: id - is negative");
        }
        return moduleDAO.getRepository(id);
    }

    @Override
    public List<Hero> getAllHero() {
        return moduleDAO.getAllHero();
    }

     @Override
    public <T extends Object> T copyObject(T sourceObject) {
         if (sourceObject == null){
             throw new InvalidParameters("Parameter sourceObject is null");
         }
        T copyObject = null;

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(sourceObject);
            objectOutputStream.flush();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            byte[] byteData = byteArrayOutputStream.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteData);
            try {
                copyObject = (T) new ObjectInputStream(byteArrayInputStream).readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return copyObject;
    }
}
