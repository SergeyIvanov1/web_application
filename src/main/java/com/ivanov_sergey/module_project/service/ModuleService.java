package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.entity.Question;
import com.ivanov_sergey.module_project.entity.Visitor;

import java.util.Optional;

public interface ModuleService {
    public Question getQuestion(int id);
    public Optional<Question> getQuestion(String nextQuestion);
    public Optional<Visitor> getVisitor(String nameVisitor);
    public void saveVisitor(Visitor visitor);
    public void increaseCountOfGame(Visitor visitor);
}
