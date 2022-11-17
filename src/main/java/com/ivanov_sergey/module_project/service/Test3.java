package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.entity.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

//
//
public class Test3 {
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
//            List<Answer> answers = session.createQuery("from Answer")
//                            .getResultList();

//            List<Answer> answers = session.createQuery("from Answer where next_question_id = 1")
//                            .getResultList();
//            for (Answer answer:answers) {
//                System.out.println(answer);
//            }
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
