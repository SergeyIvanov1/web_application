package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.Issue;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.service.ModuleService;
import com.ivanov_sergey.game.service.ModuleServiceImpl;
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

@WebServlet("/conversation")
public class ConversationServlet extends HttpServlet {
    static final Logger LOGGER = LogManager.getRootLogger();
    private final int INITIAL_INDEX = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        LOGGER.debug("LocationServlet, doGet started");
        String lastLocation = req.getParameter("lastLocation");
        HttpSession session = req.getSession();
        session.setAttribute("lastLocation", lastLocation);
        String personageName = req.getParameter("personageName");
        req.setAttribute("personageName", personageName);

        List<Location> locations = (List<Location>) session.getAttribute("locations");
        Optional<Location> optional = locations.stream()
                .filter((location) -> lastLocation.equals(location.getName()))
                .findFirst();
        optional.ifPresent(location -> {
            req.setAttribute("issue", location.getPersonages()
                    .stream()
                    .filter(personage -> personageName.equals(personage.getName()))
                    .findFirst()
                    .get()
                    .getIssues()
                    .get(INITIAL_INDEX));
//            req.setAttribute("potions", location.getPotions());
        });

//
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/conversation.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        LOGGER.debug("LocationServlet, doGet started");
        HttpSession session = req.getSession();
        String personageName = req.getParameter("personageName");
        String nextQuestion = req.getParameter("nextQuestion");
        req.setAttribute("personageName", personageName);
        System.out.println("personageName =" + personageName);

        List<Location> locations = (List<Location>) session.getAttribute("locations");
        String lastLocation = (String) session.getAttribute("lastLocation");
        Optional<Issue> optional = locations.stream()
                .filter((location) -> lastLocation.equals(location.getName()))
                .findFirst()
                .get()
                .getPersonages()
                .stream()
                .filter(personage -> personageName.equals(personage.getName()))
                .findFirst()
                .get()
                .getIssues()
                .stream()
                .filter(issue -> nextQuestion.equals(issue.getText()))
                .findFirst();
        optional.ifPresent(issue -> {
            req.setAttribute("issue", issue);
        });

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/conversation.jsp");
        requestDispatcher.forward(req, resp);
    }
}
