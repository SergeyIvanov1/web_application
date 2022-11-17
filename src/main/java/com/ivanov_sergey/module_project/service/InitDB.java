package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.entity.Answer;
import com.ivanov_sergey.module_project.entity.Question;

public class InitDB {
    public static void main(String[] args) {
//        Question question1 = new Question("Ты потерял память. Принять вызов?");
//        Question question2 = new Question("Ты принял вызов. Поднимешься на мостик к капитану?");
//        Question question3 = new Question("Ты отклонил вызов. Поражение");
//        Question question4 = new Question("Ты поднялся на мостик. Ты кто?");
//        Question question5 = new Question("Ты не пошел на переговоры. Поражение");
//        Question question6 = new Question("Тебя вернули домой. Победа");
//        Question question7 = new Question("Твою ложь разоблачили. Поражение");
//
//        Answer answer1 = new Answer("Принять вызов", "Ты принял вызов. Поднимешься на мостик к капитану?");
//        Answer answer2 = new Answer("Отклонить вызов", "Ты отклонил вызов. Поражение");
//        Answer answer3 = new Answer("Подняться на мостик", "Ты поднялся на мостик. Ты кто?");
//        Answer answer4 = new Answer("Отказаться подниматься на мостик", "Ты не пошел на переговоры. Поражение");
//        Answer answer5 = new Answer("Рассказать правду о себе", "Тебя вернули домой. Победа");
//        Answer answer6 = new Answer("Солгать о себе", "Твою ложь разоблачили. Поражение");

        Question question1 = new Question("Tou are loose memory. Take the challenge?");
        Question question2 = new Question("You accepted the challenge. Will you go up to the bridge to the captain?");
        Question question3 = new Question("You declined the call. Defeat");
        Question question4 = new Question("You went up to the bridge. Who are you?");
        Question question5 = new Question("You did not negotiate. Defeat?");
        Question question6 = new Question("You have been brought home. Victory");
        Question question7 = new Question("Your lies have been exposed. Defeat");

        Answer answer1 = new Answer("Reject a call", "You declined the call. Defeat");
        Answer answer2 = new Answer("Take the challenge", "You accepted the challenge. Will you go up to the bridge to the captain?");
        Answer answer3 = new Answer("Climb to the bridge", "You went up to the bridge. Who are you?");
        Answer answer4 = new Answer("Refuse to go up to the bridge", "You did not negotiate. Defeat?");
        Answer answer5 = new Answer("Tell the truth about yourself", "You have been brought home. Victory");
        Answer answer6 = new Answer("Lie about yourself", "Your lies have been exposed. Defeat");

        InitDBService initDBService = new InitDBService();
        initDBService.createQuestion(question1, answer1, answer2);
        initDBService.createQuestion(question2, answer3, answer4);
        initDBService.createQuestion(question4, answer5, answer6);
        initDBService.createQuestion(question3);
        initDBService.createQuestion(question5);
        initDBService.createQuestion(question6);
        initDBService.createQuestion(question7);
    }
}
