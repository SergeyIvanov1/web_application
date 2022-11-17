package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.dao.ModuleDAOImpl;
import com.ivanov_sergey.module_project.entity.Question;

public class ModuleServiceImpl implements ModuleService {
    ModuleDAOImpl moduleDAO = new ModuleDAOImpl();
    @Override
    public Question getQuestion(int id) {
        return moduleDAO.getQuestion(id);
    }

    @Override
    public Question getQuestion(String nextQuestion) {
        return moduleDAO.getQuestion(nextQuestion);
    }
}
