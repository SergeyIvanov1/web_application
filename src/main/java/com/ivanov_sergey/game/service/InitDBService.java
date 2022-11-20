package com.ivanov_sergey.game.service;

import com.ivanov_sergey.module_project.entity.Answer;
import com.ivanov_sergey.module_project.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InitDBService {

    SessionFactory factory;
    {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    }
    public void createQuestion(Question question, Answer ... answers) {

        Session session = factory.getCurrentSession();
        for (Answer answer: answers) {
            question.addAnswerToQuestion(answer);
        }

        session.beginTransaction();
        session.save(question);
        session.getTransaction().commit();
    }

    public void createQuestion(Question question) {

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.save(question);
        session.getTransaction().commit();
    }



////*****************************************************************
//        try {
//            session = factory.getCurrentSession();
//            Question question1 = new Question("Ты принял вывоз. Поднимаешься на мостик к капитану?", 3, 0, 0);
//            Question question2 = new Question("Ты поднялся на мостик. Ты кто?", 4, 0, 0);
//            Question question3 = new Question("Тебя вернули домой", 5, 0, 0);
//            Answer answer2 = new Answer("Подняться на мостик", 9, 2);
//
//            answer2.addQuestionToAnswer(question1);
//            answer2.addQuestionToAnswer(question2);
//            answer2.addQuestionToAnswer(question3);
////            question1.addAnswerToQuestion(answer2);
//
//            session.beginTransaction();
//            session.save(answer2);
//            session.getTransaction().commit();
//
//        } finally {
////            session.close();
//            factory.close();
//        }
        //*****************************************************************

//        try {
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            //получаю список ответов по вопросу
//            Question question = session.get(Question.class, 1);
//
//            System.out.println(question);
//            System.out.println(question.getAnswers());
//
//            session.getTransaction().commit();
//
//        } finally {
////            session.close();
//            factory.close();
//        }

        //*****************************************************************

//        try {
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            //получаю список вопросов по ответу
////            [Question{id=2, text='Ты принял вывоз. Поднимаешься на мостик к капитану?', question_id=3, is_loose=0, is_win=0}, Question{id=3, text='Ты поднялся на мостик. Ты кто?', question_id=4, is_loose=0, is_win=0}, Question{id=4, text='Тебя вернули домой', question_id=5, is_loose=0, is_win=0}]
//            Answer answer = session.get(Answer.class, 3);
//
//            System.out.println(answer);
//            System.out.println(answer.getQuestions());
//
//            session.getTransaction().commit();
//
//        } finally {
////            session.close();
//            factory.close();
//        }

//        try {
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//           // при удалении вопроса, удалятся все привязанные ответы.
//            //чтобы не удалять вопросы, нужно изменить каскад
//            Question question = session.get(Question.class, 1);
//            session.delete(question);
//
//
//            session.getTransaction().commit();
//
//        } finally {
////            session.close();
//            factory.close();
//        }
}
