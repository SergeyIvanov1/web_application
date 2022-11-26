package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.Personage;
import com.ivanov_sergey.game.service.LocationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/conversation")
public class ConversationServlet extends HttpServlet {
    static final Logger LOGGER = LogManager.getRootLogger();
    private final int INITIAL_INDEX = 0;

    LocationServiceImpl service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        service = (LocationServiceImpl) servletContext.getAttribute("locationService");
        System.out.println("service = " + service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("ConversationServlet, doGet started");

        String lastLocation = req.getParameter("lastLocation");
        HttpSession session = req.getSession();
        session.setAttribute("lastLocation", lastLocation);
        String personageName = req.getParameter("personageName");
        req.setAttribute("personageName", personageName);

        Personage personage = service.getPersonage(personageName, lastLocation);
        req.setAttribute("issue", service.getFirstIssue(personage, INITIAL_INDEX));

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/conversation.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastLocation = req.getParameter("lastLocation");
        String personageName = req.getParameter("personageName");
        String nextQuestion = req.getParameter("nextQuestion");
        LOGGER.debug("ConversationServlet, doPost started. " +
                "LastLocation = " + lastLocation + ", personageName = " + personageName +
                ", nextQuestion = " + nextQuestion);


        req.setAttribute("personageName", personageName);
        req.setAttribute("lastLocation", lastLocation);

        RequestDispatcher requestDispatcher;
        if ("fight".equals(nextQuestion)){
            requestDispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/game_view/fight.jsp");
            requestDispatcher.forward(req, resp);
        }
        req.setAttribute("issue", service.getIssue(personageName, nextQuestion, lastLocation));

        requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/conversation.jsp");
        requestDispatcher.forward(req, resp);
    }
}
