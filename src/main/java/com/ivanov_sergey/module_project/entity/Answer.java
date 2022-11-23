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

    public Answer(String text, String nextQuestion) {
        this.text = text;
        this.nextQuestion = nextQuestion;
    }

    public Answer(String text) {
        this.text = text;
    }

    public void addQuestionToAnswer(Question question){
        if (questions == null){
            questions = new ArrayList<>();
        }
        questions.add(question);
    }
}
