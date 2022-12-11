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
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String STARTING_ROOM = "Gates";
    private ModuleService moduleService;
    private LocationServiceImpl locationService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        moduleService = (ModuleServiceImpl) servletContext.getAttribute("moduleService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy, HH-mm");
        String timeOfCreateGame = dateTimeFormatter.format(LocalDateTime.now());
        HttpSession session = req.getSession();
        locationService = (LocationServiceImpl)session.getAttribute("locationService");

        String heroName = req.getParameter("heroName");
        Hero hero;
        Location currentLocation;
        List<Hero> heroes;
        if (heroName == null){
            hero = (Hero) session.getAttribute("hero");
            currentLocation = locationService.getLocation((String) session.getAttribute("currentLocal"));
            heroes = (List<Hero>) session.getAttribute("heroes");
        } else {
            hero = moduleService.getOrCreateHero(heroName);
            heroes = moduleService.getAllHero();
            LOGGER.debug("LocationServlet, game started with hero = " + heroName);
            currentLocation = locationService.getLocation(STARTING_ROOM);
        }

        req.setAttribute("currentLocation", currentLocation);
        req.setAttribute("armors", locationService.getArmors(currentLocation.getName()));
        req.setAttribute("potions", locationService.getPotions(currentLocation.getName()));
        req.setAttribute("helpers", locationService.getHelpers(currentLocation.getName()));
        req.setAttribute("weapons", locationService.getWeapons(currentLocation.getName()));

        session.setAttribute("locations", locationService.getLocations());
        session.setAttribute("currentLocal", currentLocation.getName());
        session.setAttribute("repository", locationService.getSessionRepo());
        session.setAttribute("hero", hero);
        session.setAttribute("heroes", heroes);
        session.setAttribute("clientIPAddress", locationService.getClientIPAddress(req));
        session.setAttribute("name", hero.getName());
        session.setAttribute("countOfGames", hero.getCountOfEndedGames());
        session.setAttribute("timeOfCreateGame", timeOfCreateGame);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextLocationName = req.getParameter("nextLocationName");
        String personageName = req.getParameter("personageName");
        HttpSession httpSession = req.getSession();
        locationService = (LocationServiceImpl)httpSession.getAttribute("locationService");
        httpSession.setAttribute("currentLocal", nextLocationName);
        System.out.println("LocationServlet, doPost, nextLocationName = " + nextLocationName);

        LOGGER.debug("LocationServlet, doPost is started with nextLocationName = " + nextLocationName);

            req.setAttribute("currentLocation", locationService.getLocation(nextLocationName));
            req.setAttribute("personageName", personageName);
            req.setAttribute("armors", locationService.getArmors(nextLocationName));
            req.setAttribute("potions", locationService.getPotions(nextLocationName));
            req.setAttribute("helpers", locationService.getHelpers(nextLocationName));
            req.setAttribute("weapons", locationService.getWeapons(nextLocationName));

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }
}
