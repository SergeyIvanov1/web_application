package com.ivanov_sergey.module_project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "next_question")
    private String nextQuestion;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "join_table",
            joinColumns = @JoinColumn(name = "answer_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    List<Question> questions;

//    public Answer() {
//    }

    public Answer(String text, String nextQuestion) {
        this.text = text;
        this.nextQuestion = nextQuestion;
    }

    public Answer(String text) {
        this.text = text;
    }

//    @Override
//    public String toString() {
//        return "Answer{" +
//                "id=" + id +
//                ", text='" + text + '\'' +
//                ", nextQuestion='" + nextQuestion + '\'' +
//                ", questions=" + questions +
//                '}';
//    }

    public void addQuestionToAnswer(Question question){
        if (questions == null){
            questions = new ArrayList<>();
        }
        questions.add(question);
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public String getNextQuestion() {
//        return nextQuestion;
//    }
//
//    public void setNextQuestion(String nextQuestion) {
//        this.nextQuestion = nextQuestion;
//    }
//
//    public List<Question> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<Question> questions) {
//        this.questions = questions;
//    }
}
