package com.ivanov_sergey.game.dao;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.entity.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ModuleDAOImpl implements ModuleDAO {

    private final SessionFactory sessionFactory;
    private Session session;

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
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            repository = session.get(Repository.class, id);
            transaction.commit();
        } finally {
            session.close();
        }
        return repository;
    }

    @Override
    public Optional<Location> getLocation(String nextLocation) {
        Optional<Location> optionalLocation;
        try {
            session = sessionFactory.openSession();

            session.beginTransaction();
            Query<Location> query = session.createQuery("from Location where name = '" + nextLocation + "'");
            List<Location> resultList = query.getResultList();


            if (resultList.size() > 0) {
                optionalLocation = Optional.of(query.getResultList().get(0));
            } else {
                optionalLocation = Optional.empty();
            }
        } finally {
            session.close();
        }
        session.getTransaction().commit();
        return optionalLocation;
    }

    @Override
    public Optional<Hero> getHero(String nameHero) {
        Optional<Hero> optionalHero;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query<Hero> query = session.createQuery("from Hero where name = '" + nameHero + "'");
            List<Hero> resultList = query.getResultList();


            if (resultList.size() > 0) {
                optionalHero = Optional.of(query.getResultList().get(0));
            } else {
                optionalHero = Optional.empty();
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return optionalHero;
    }

    @Override
    public List<Hero> getAllHero() {
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
