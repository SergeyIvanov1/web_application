package com.ivanov_sergey.module_project.servlets;

import com.ivanov_sergey.module_project.entity.Answer;
import com.ivanov_sergey.module_project.entity.Question;
import com.ivanov_sergey.module_project.service.ModuleService;
import com.ivanov_sergey.module_project.service.ModuleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/questions")
public class SecondServlet extends HttpServlet {
    public static final int INITIAL_ID = 1;
    ModuleService moduleService = new ModuleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question question = moduleService.getQuestion(INITIAL_ID);
        List<Answer> answers = question.getAnswers();

        req.setAttribute("question", question);
        req.setAttribute("answers", answers);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/module_project_view/main_page.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextQuestion = req.getParameter("nextQuestion");

        Question question = moduleService.getQuestion(nextQuestion);
        List<Answer> answers = question.getAnswers();

        req.setAttribute("question", question);
        req.setAttribute("answers", answers);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/module_project_view/main_page.jsp");
        requestDispatcher.forward(req, resp);
    }
}
