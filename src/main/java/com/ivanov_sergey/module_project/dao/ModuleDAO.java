package com.ivanov_sergey.module_project.dao;


import com.ivanov_sergey.module_project.entity.Question;

public interface ModuleDAO {
    public Question getQuestion(int id);
    public Question getQuestion(String nextQuestion);

}
