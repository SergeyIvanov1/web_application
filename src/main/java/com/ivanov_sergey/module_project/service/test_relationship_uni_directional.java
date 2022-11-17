package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//
//
public class test_relationship_uni_directional {
    public static void main(String[] args) {
//        saveQuestion();
        saveInfo();
    }
    public static void saveInfo(){
        Test.Extract();
    }

    public static void saveQuestion(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Question answer = new Question("text");

            session.beginTransaction();
            session.save(answer);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }


}
