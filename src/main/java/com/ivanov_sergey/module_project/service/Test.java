package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.entity.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//
//
public class Test {
    public static void main(String[] args) {
//        saveQuestion();
        saveInfo();
    }

    public static void saveInfo() {
        Extract();
    }

    static void Extract() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Answer.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Answer answer = new Answer("text2");

            session.beginTransaction();
            session.save(answer);
            session.getTransaction().commit();

            int myId = answer.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Answer answer1 = session.get(Answer.class, myId);
            session.getTransaction().commit();
            System.out.println(answer1);
        } finally {
            factory.close();
        }
    }
}
