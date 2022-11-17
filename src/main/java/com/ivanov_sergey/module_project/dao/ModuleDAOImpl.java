package com.ivanov_sergey.module_project.dao;

import com.ivanov_sergey.module_project.entity.Answer;
import com.ivanov_sergey.module_project.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ModuleDAOImpl implements ModuleDAO {

    private SessionFactory sessionFactory;
    Session session;

    {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    }

    @Override
    public Question getQuestion(int id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Question question = session.get(Question.class, id);
        System.out.println("вывод из ModuleDAOImpl: " + question);
        session.getTransaction().commit();
        return question;
    }

    @Override
    public Question getQuestion(String nextQuestion) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Question> query = session.createQuery("from Question where text = '" + nextQuestion +"'");
        Question question1 = query.getResultList().get(0);

        Question question = session.get(Question.class, question1.getId());
        session.getTransaction().commit();
        return question;
    }
}
