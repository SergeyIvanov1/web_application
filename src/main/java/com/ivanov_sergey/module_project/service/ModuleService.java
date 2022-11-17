package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.entity.Question;

public interface ModuleService {
    public Question getQuestion(int id);
    public Question getQuestion(String nextQuestion);

}
