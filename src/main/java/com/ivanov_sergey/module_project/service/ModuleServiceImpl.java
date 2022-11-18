package com.ivanov_sergey.module_project.service;

import com.ivanov_sergey.module_project.dao.ModuleDAOImpl;
import com.ivanov_sergey.module_project.entity.Question;
import com.ivanov_sergey.module_project.entity.Visitor;

import java.util.Optional;

public class ModuleServiceImpl implements ModuleService {
    ModuleDAOImpl moduleDAO = new ModuleDAOImpl();
    @Override
    public Question getQuestion(int id) {
        return moduleDAO.getQuestion(id);
    }

    @Override
    public Optional<Question> getQuestion(String nextQuestion) {
        return moduleDAO.getQuestion(nextQuestion);
    }

    @Override
    public Optional<Visitor> getVisitor(String nameVisitor){
        return moduleDAO.getVisitor(nameVisitor);
    }

    @Override
    public void saveVisitor(Visitor visitor) {
        moduleDAO.saveVisitor(visitor);
    }

    @Override
    public void increaseCountOfGame(Visitor visitor) {
        moduleDAO.increaseCountOfGame(visitor);
    }
}
