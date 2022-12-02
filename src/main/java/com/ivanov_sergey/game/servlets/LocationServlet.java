package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.service.LocationServiceImpl;
import com.ivanov_sergey.game.service.ModuleService;
import com.ivanov_sergey.game.service.ModuleServiceImpl;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/location")
public class LocationServlet extends HttpServlet {
    static final Logger LOGGER = LogManager.getRootLogger();
    public static final String STARTING_ROOM = "Gates";
    ModuleService moduleService = new ModuleServiceImpl();
    LocationServiceImpl service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        service = (LocationServiceImpl) servletContext.getAttribute("locationService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy, HH-mm");
        String timeOfCreateGame = dateTimeFormatter.format(LocalDateTime.now());
        HttpSession session = req.getSession();

        String heroName = req.getParameter("heroName");
        Hero hero = moduleService.getOrCreateHero(heroName);
        List<Hero> heroes = moduleService.getAllHero();
        LOGGER.debug("LocationServlet, game started with hero = " + heroName);

        Location currentLocation = service.getLocation(STARTING_ROOM);

        req.setAttribute("currentLocation", currentLocation);
        req.setAttribute("armors", service.getArmors(currentLocation.getName()));
        req.setAttribute("potions", service.getPotions(currentLocation.getName()));
        req.setAttribute("helpers", service.getHelpers(currentLocation.getName()));
        req.setAttribute("weapons", service.getWeapons(currentLocation.getName()));

        session.setAttribute("locations", service.getLocations());
        session.setAttribute("repository", service.getRepository());
        session.setAttribute("hero", hero);
        session.setAttribute("heroes", heroes);
        session.setAttribute("clientIPAddress", service.getClientIPAddress(req));
        session.setAttribute("name", heroName);
        session.setAttribute("countOfGames", hero.getCountOfEndedGames());
        session.setAttribute("timeOfCreateGame", timeOfCreateGame);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextLocationName = req.getParameter("nextLocationName");
        LOGGER.debug("LocationServlet, doPost is started with nextLocationName = " + nextLocationName);

            req.setAttribute("currentLocation", service.getLocation(nextLocationName));
            req.setAttribute("armors", service.getArmors(nextLocationName));
            req.setAttribute("potions", service.getPotions(nextLocationName));
            req.setAttribute("helpers", service.getHelpers(nextLocationName));
            req.setAttribute("weapons", service.getWeapons(nextLocationName));

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }
}
