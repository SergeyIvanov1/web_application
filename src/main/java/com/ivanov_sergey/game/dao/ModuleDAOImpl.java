package com.ivanov_sergey.game.dao;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.entity.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ModuleDAOImpl implements ModuleDAO {

    private final SessionFactory sessionFactory;
    Session session;

//    {
//        sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Location.class)
//                .addAnnotatedClass(Hero.class)
//                .addAnnotatedClass(Personage.class)
//                .addAnnotatedClass(Armor.class)
//                .addAnnotatedClass(Potion.class)
//                .addAnnotatedClass(Weapon.class)
//                .addAnnotatedClass(Repository.class)
//                .addAnnotatedClass(Helper.class)
//                .addAnnotatedClass(Inventory.class)
//                .addAnnotatedClass(Issue.class)
//                .addAnnotatedClass(Reply.class)
//                .addAnnotatedClass(Quest.class)
//                .buildSessionFactory();
//    }

    public ModuleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Location getLocation(int id) {
//        session = sessionFactory.getCurrentSession();
        Location location;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            location = session.get(Location.class, id);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return location;
    }

    @Override
    public Repository getRepository(int id) {
        Repository repository;
        try {
//            session = sessionFactory.getCurrentSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            repository = session.get(Repository.class, id);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return repository;
    }

    @Override
    public Optional<Location> getLocation(String nextLocation) {
        Optional<Location> optional;
//        session = sessionFactory.getCurrentSession();
        try {
            session = sessionFactory.openSession();

            session.beginTransaction();
            Query<Location> query = session.createQuery("from Location where name = '" + nextLocation + "'");
            List<Location> resultList = query.getResultList();


            if (resultList.size() > 0) {
                optional = Optional.of(query.getResultList().get(0));
            } else {
                optional = Optional.empty();
            }
        } finally {
            session.close();
        }
        session.getTransaction().commit();
        return optional;
    }

    @Override
    public Optional<Hero> getHero(String nameHero) {
//        session = sessionFactory.getCurrentSession();
        Optional<Hero> optional;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query<Hero> query = session.createQuery("from Hero where name = '" + nameHero + "'");
            List<Hero> resultList = query.getResultList();


            if (resultList.size() > 0) {
                optional = Optional.of(query.getResultList().get(0));
            } else {
                optional = Optional.empty();
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return optional;
    }

    @Override
    public List<Hero> getAllHero() {
//        session = sessionFactory.getCurrentSession();
        List<Hero> resultList;
        try {
            session = sessionFactory.openSession();

            session.beginTransaction();
            Query<Hero> query = session.createQuery("from Hero", Hero.class);
            resultList = query.getResultList();
        } finally {
            session.close();
        }
        return resultList;
    }

    @Override
    public void saveHero(Hero hero) {
//        session = sessionFactory.getCurrentSession();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(hero);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public Integer increaseCountOfGame(Hero hero) {
//        int countOfGames = hero.getCountOfEndedGames();
//        System.out.println("countOfGames1 = " + countOfGames);
//        countOfGames++;
//        int id = hero.getId();
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        session.createQuery("update Visitor set countOfGames = " + countOfGames + " where id = " + id
//            ).executeUpdate();
//        System.out.println("countOfGames2 = " + countOfGames);
//        session.getTransaction().commit();
//        return countOfGames;
        return 0;
    }
}
