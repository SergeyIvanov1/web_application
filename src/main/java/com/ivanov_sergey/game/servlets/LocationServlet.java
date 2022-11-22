package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Inventory;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.repository.Repository;
import com.ivanov_sergey.game.service.HandleService;
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
    public static final int STARTING_ROOM = 0;
    ModuleService moduleService = new ModuleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("LocationServlet, doGet started");
        HandleService handleService = new HandleService();

        HttpSession session = req.getSession();
        Repository repository = moduleService.getRepository(INITIAL_ID);
        String heroName = req.getParameter("heroName");
        String endGame = req.getParameter("endGame");
        Hero hero = getHero(heroName);
        List<Location> locations = repository.getLocations();
        Location currentLocation = locations.get(STARTING_ROOM);
//        List<Personage> personages = location.getPersonages();

        hero.setCurrentLocation(currentLocation.getName());
        req.setAttribute("currentLocation", currentLocation);
        session.setAttribute("locations", locations);

        int countOfGames;
        if (endGame != null) {
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
        session.setAttribute("repository", repository);
        session.setAttribute("hero", hero);
        session.setAttribute("clientIPAddress", getClientIPAddress(req));
        session.setAttribute("name", heroName);
        session.setAttribute("countOfGames", hero.getCountOfGames());
        handleService.setAttributesToRequest(req, currentLocation.getName());

        requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("LocationServlet, doPost started");

        String nextLocationName = req.getParameter("nextLocationName");
        HttpSession session = req.getSession();
        List<Location> locations = (List<Location>) session.getAttribute("locations");
        Optional<Location> optional = locations.stream()
                .filter((location) -> nextLocationName.equals(location.getName()))
                .findFirst();
        optional.ifPresent(currentLocation -> {
            req.setAttribute("currentLocation", currentLocation);
            req.setAttribute("armors", currentLocation.getArmors());
            req.setAttribute("potions", currentLocation.getPotions());
            req.setAttribute("helpers", currentLocation.getHelpers());
            req.setAttribute("weapons", currentLocation.getWeapons());
        });



        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }

    private String getClientIPAddress(HttpServletRequest request) {
        String remoteAddress = "";
        if (request != null) {
            remoteAddress = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddress == null || "".equals(remoteAddress)) {
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
            hero.initValuesOfFields();
            hero.setInventory(new Inventory(heroName));
            moduleService.saveHero(hero);
        } else {
            hero = optional.get();
        }
        return hero;
    }
}
