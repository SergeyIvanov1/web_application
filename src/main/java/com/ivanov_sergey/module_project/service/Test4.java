package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.entity.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

//
//
public class Test4 {
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
//            answer.setText("Text4");    //change value in DB

//            session.createQuery("update Answer"
//                    " set next_question_id = 5 " +
//                    "where text = 'text2'"
//            ).executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
