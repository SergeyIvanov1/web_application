package com.ivanov_sergey.game.servlets;


import com.ivanov_sergey.game.entity.Repository;
import com.ivanov_sergey.game.entity.Storage;
import com.ivanov_sergey.game.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start_game")
public class StartGameServlet extends HttpServlet {
    private final int INTERVAL = 24*60*60;
    private Storage sessionRepo;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(INTERVAL);

        ModuleService moduleService = (ModuleServiceImpl)getServletContext().getAttribute("moduleService");
        Repository mainRepo = (Repository)getServletContext().getAttribute("mainRepo");

        sessionRepo = moduleService.copyObject(mainRepo);
        LocationService locationService = new LocationServiceImpl(sessionRepo);
        FightingService fightingService = new FightingServiceImpl(sessionRepo);

        session.setAttribute("sessionRepo", sessionRepo);
        session.setAttribute("locationService", locationService);
        session.setAttribute("fightingService", fightingService);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/start_game_page.jsp");
        requestDispatcher.forward(req, resp);
    }
}
