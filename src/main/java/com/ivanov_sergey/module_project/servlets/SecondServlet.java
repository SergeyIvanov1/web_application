package com.ivanov_sergey.module_project.servlets;

import com.ivanov_sergey.module_project.entity.Answer;
import com.ivanov_sergey.module_project.entity.Question;
import com.ivanov_sergey.module_project.entity.Visitor;
import com.ivanov_sergey.module_project.service.ModuleService;
import com.ivanov_sergey.module_project.service.ModuleServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/questions")
public class SecondServlet extends HttpServlet {
    static final Logger LOGGER = LogManager.getRootLogger();
    public static final int INITIAL_ID = 1;
    ModuleService moduleService = new ModuleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("SecondServlet, doGet started");
        HttpSession session = req.getSession();

        Question question = moduleService.getQuestion(INITIAL_ID);
        List<Answer> answers = question.getAnswers();
        req.setAttribute("question", question);
        req.setAttribute("answers", answers);

        String visitorName = req.getParameter("visitorName");
        System.out.println("visitorName = " + visitorName);
        String endGame = req.getParameter("endGame");
        System.out.println("endGame = " + endGame);

        Visitor visitor = getVisitor(visitorName);

        int countOfGames;
        if (endGame != null){
            countOfGames = moduleService.increaseCountOfGame(visitor);
            session.setAttribute("countOfGames", countOfGames);
        }

        RequestDispatcher requestDispatcher;
        if (session.getAttribute("visitor") != null) {
            requestDispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/module_project_view/main_page.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        System.out.println("test");

        session.setAttribute("visitor", visitor);
        session.setAttribute("clientIPAddress", getClientIPAddress(req));
        session.setAttribute("name", visitorName);
        session.setAttribute("countOfGames", visitor.getCountOfGames());

        requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/module_project_view/main_page.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("SecondServlet, doPost started");
        String nextQuestion = req.getParameter("nextQuestion");

        Optional<Question> optional = moduleService.getQuestion(nextQuestion);
        Question question;
        if (optional.isPresent()) {
            question = optional.get();
            List<Answer> answers = question.getAnswers();
            req.setAttribute("question", question);
            req.setAttribute("answers", answers);
        }
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/module_project_view/main_page.jsp");
        requestDispatcher.forward(req, resp);
    }

    private String getClientIPAddress(HttpServletRequest request){
        String remoteAddress = "";
        if (request != null){
            remoteAddress = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddress == null || "".equals(remoteAddress)){
                remoteAddress = request.getRemoteAddr();
            }
        }
        return remoteAddress;
    }

    private Visitor getVisitor(String visitorName) {
        Optional<Visitor> optional = moduleService.getVisitor(visitorName);
        Visitor visitor;
        if (optional.isEmpty()) {
            visitor = new Visitor(visitorName);
            moduleService.saveVisitor(visitor);
        } else {
            visitor = optional.get();
        }
        return visitor;
    }
}
