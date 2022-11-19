package com.ivanov_sergey.module_project.dao;

import com.ivanov_sergey.module_project.entity.Answer;
import com.ivanov_sergey.module_project.entity.Question;
import com.ivanov_sergey.module_project.entity.Visitor;
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
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Visitor.class)
                .buildSessionFactory();
    }

    @Override
    public Question getQuestion(int id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Question question = session.get(Question.class, id);
        session.getTransaction().commit();
        return question;
    }

    @Override
    public Optional<Question> getQuestion(String nextQuestion) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Question> query = session.createQuery("from Question where text = '" + nextQuestion + "'");
        List<Question> resultList = query.getResultList();

        Optional<Question> optional;
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
    public Optional<Visitor> getVisitor(String nameVisitor) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Visitor> query = session.createQuery("from Visitor where name = '" + nameVisitor + "'");
        List<Visitor> resultList = query.getResultList();

        Optional<Visitor> optional;
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
    public void saveVisitor(Visitor visitor) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(visitor);
        session.getTransaction().commit();
    }

    @Override
    public Integer increaseCountOfGame(Visitor visitor) {
        int countOfGames = visitor.getCountOfGames();
        System.out.println("countOfGames1 = " + countOfGames);
        countOfGames++;
        int id = visitor.getId();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("update Visitor set countOfGames = " + countOfGames + " where id = " + id
            ).executeUpdate();
        System.out.println("countOfGames2 = " + countOfGames);
        session.getTransaction().commit();
        return countOfGames;
    }
}
