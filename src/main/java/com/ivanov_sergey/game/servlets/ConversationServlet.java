package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.Helper;
import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Personage;
import com.ivanov_sergey.game.service.LocationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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

    LocationServiceImpl locationService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("ConversationServlet, doGet started");

        String lastLocation = req.getParameter("lastLocation");
        HttpSession httpSession = req.getSession();
        locationService = (LocationServiceImpl) httpSession.getAttribute("locationService");

        httpSession.setAttribute("lastLocation", lastLocation);
        String personageName = req.getParameter("personageName");
        req.setAttribute("personageName", personageName);

        Personage personage = locationService.getPersonage(personageName, lastLocation);
        req.setAttribute("issue", locationService.getFirstIssue(personage, INITIAL_INDEX));

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/conversation.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastLocation = req.getParameter("lastLocation");
        String personageName = req.getParameter("personageName");
        String nextQuestion = req.getParameter("nextQuestion");
        String currentReply = req.getParameter("currentReply");
        HttpSession httpSession = req.getSession();
        Hero hero = (Hero) httpSession.getAttribute("hero");
        LOGGER.debug("ConversationServlet, doPost started. " +
                "LastLocation = " + lastLocation + ", personageName = " + personageName +
                ", nextQuestion = " + nextQuestion);

        req.setAttribute("personageName", personageName);
        req.setAttribute("lastLocation", lastLocation);

//        Helper helper;

        for (Helper helper : hero.getInventory().getHelpers()) {
            if (helper.getName().equals("present") && personageName.equals("Forester")){

            }
        }


        if (currentReply.startsWith("Ok")) {
            locationService.passQuestToHero(personageName, lastLocation, hero);
        }

        if ("".equals(nextQuestion)) {
            resp.sendRedirect(req.getContextPath() + "/location");
            return;
        }

        if ("fight".equals(nextQuestion)) {
            req.setAttribute("fighting", "fighting");
        } else {
            req.setAttribute("issue", locationService.getIssue(personageName, nextQuestion, lastLocation));
        }

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/conversation.jsp");
        requestDispatcher.forward(req, resp);
    }
}
