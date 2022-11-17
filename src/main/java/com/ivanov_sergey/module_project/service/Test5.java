package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.entity.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//
//
public class Test5 {
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
            session.beginTransaction();

//            Answer answer = session.get(Answer.class, 2);
//            session.delete(answer);

            session.createQuery("delete Answer"
//                    " where next_question_id = 1"
            ).executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
