package com.ivanov_sergey.module_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "text")
    private String text;
    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "join_table",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private List<Answer> answers;

//    public Question() {
//    }

    public Question(String text) {
        this.text = text;
    }

//    @Override
//    public String toString() {
//        return "Question{" +
//                "id=" + id +
//                ", text='" + text + '\'' +
//                '}';
//    }
//
//    public int getId() {
//        return id;
//    }

    public void addAnswerToQuestion(Answer answer) {
        if (answers == null) {
            answers = new ArrayList<>();
        }
        answers.add(answer);
    }

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
//    public List<Answer> getAnswers() {
//        return answers;
//    }
//
//    public void setAnswers(List<Answer> answers) {
//        this.answers = answers;
//    }
}
