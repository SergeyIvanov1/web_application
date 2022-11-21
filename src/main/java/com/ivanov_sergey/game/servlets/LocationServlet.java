package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.entity.Personage;
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

@WebServlet("/location")
public class LocationServlet extends HttpServlet {
    static final Logger LOGGER = LogManager.getRootLogger();
    public static final int INITIAL_ID = 1;
    ModuleService moduleService = new ModuleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("LocationServlet, doGet started");
        HttpSession session = req.getSession();

        Location location = moduleService.getLocation(INITIAL_ID);
        List<Personage> personages = location.getPersonages();
        req.setAttribute("location", location);
        req.setAttribute("personages", personages);

        String heroName = req.getParameter("heroName");
        System.out.println("heroName = " + heroName);
        String endGame = req.getParameter("endGame");
        System.out.println("endGame = " + endGame);

        Hero hero = getHero(heroName);
        hero.setCurrentLocation(location.getName());

        int countOfGames;
        if (endGame != null){
            countOfGames = moduleService.increaseCountOfGame(hero);
            session.setAttribute("countOfGames", countOfGames);
        }

        RequestDispatcher requestDispatcher;
        if (session.getAttribute("hero") != null) {
            requestDispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        System.out.println("test");

        session.setAttribute("hero", hero);
        session.setAttribute("clientIPAddress", getClientIPAddress(req));
        session.setAttribute("name", heroName);
        session.setAttribute("countOfGames", hero.getCountOfGames());

        requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("LocationServlet, doPost started");
        String nextLocation = req.getParameter("nextLocation");

        Optional<Location> optional = moduleService.getLocation(nextLocation);
        Location location;
        if (optional.isPresent()) {
            location = optional.get();
//            List<Personage> personages = location.getPersonages();
            req.setAttribute("location", location);
//            req.setAttribute("personages", personages);
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

    private Hero getHero(String heroName) {
        Optional<Hero> optional = moduleService.getHero(heroName);
        Hero hero;
        if (optional.isEmpty()) {
            hero = new Hero(heroName);
            moduleService.saveHero(hero);
        } else {
            hero = optional.get();
        }
        return hero;
    }
}
