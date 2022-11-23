package com.ivanov_sergey.game.dao;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ModuleDAOImpl implements ModuleDAO {

    private SessionFactory sessionFactory;
    Session session;

    {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Location.class)
                .addAnnotatedClass(Hero.class)
                .addAnnotatedClass(Personage.class)
                .addAnnotatedClass(Armor.class)
                .addAnnotatedClass(Potion.class)
                .addAnnotatedClass(Weapon.class)
                .addAnnotatedClass(Repository.class)
                .addAnnotatedClass(Helper.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Issue.class)
                .addAnnotatedClass(Reply.class)
                .buildSessionFactory();
    }

    @Override
    public Location getLocation(int id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Location location = session.get(Location.class, id);
        session.getTransaction().commit();
        return location;
    }

    @Override
    public Repository getRepository(int id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Repository repository = session.get(Repository.class, id);
        session.getTransaction().commit();
        return repository;
    }

    @Override
    public Optional<Location> getLocation(String nextLocation) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Location> query = session.createQuery("from Location where name = '" + nextLocation + "'");
        List<Location> resultList = query.getResultList();

        Optional<Location> optional;
        if (resultList.size() > 0) {
            optional = Optional.of(query.getResultList().get(0));
        } else {
            optional = Optional.empty();
        }
        session.getTransaction().commit();
        return optional;
//        Question question = query.getResultList().get(0);
//
////        Question question = session.get(Question.class, question1.getId());
//        session.getTransaction().commit();
//        return question;
    }

    @Override
    public Optional<Hero> getHero(String nameHero) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Hero> query = session.createQuery("from Hero where name = '" + nameHero + "'");
        List<Hero> resultList = query.getResultList();

        Optional<Hero> optional;
        if (resultList.size() > 0) {
            optional = Optional.of(query.getResultList().get(0));
        } else {
            optional = Optional.empty();
        }
        session.getTransaction().commit();
        return optional;
//        Visitor question = session.get(Visitor.class, visitor.getId());
//        return visitor;
    }

    @Override
    public void saveHero(Hero hero) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(hero);
        session.getTransaction().commit();
    }

    @Override
    public Integer increaseCountOfGame(Hero hero) {
        int countOfGames = hero.getCountOfGames();
        System.out.println("countOfGames1 = " + countOfGames);
        countOfGames++;
        int id = hero.getId();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("update Visitor set countOfGames = " + countOfGames + " where id = " + id
            ).executeUpdate();
        System.out.println("countOfGames2 = " + countOfGames);
        session.getTransaction().commit();
        return countOfGames;
    }
}
