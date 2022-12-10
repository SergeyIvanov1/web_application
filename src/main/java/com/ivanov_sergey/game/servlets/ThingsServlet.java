package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.service.LocationServiceImpl;
import com.ivanov_sergey.game.service.ThingsService;
import com.ivanov_sergey.game.service.ThingsServiceImpl;
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
import java.util.List;

@WebServlet("/things")
public class ThingsServlet extends HttpServlet {

    static final Logger LOGGER = LogManager.getRootLogger();

    LocationServiceImpl locationService;
    ThingsService thingsService = new ThingsServiceImpl();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextLocationName = req.getParameter("nextLocationName");
        HttpSession httpSession = req.getSession();
        LOGGER.debug("ThingsServlet, doPost is started with nextLocationName = " + nextLocationName);
        locationService = (LocationServiceImpl)httpSession.getAttribute("locationService");


        req.setAttribute("currentLocation", locationService.getLocation(nextLocationName));
        req.setAttribute("armors", locationService.getArmors(nextLocationName));
        req.setAttribute("potions", locationService.getPotions(nextLocationName));
        req.setAttribute("helpers", locationService.getHelpers(nextLocationName));
        req.setAttribute("weapons", locationService.getWeapons(nextLocationName));
        req.setAttribute("boxIsOpened", "boxIsOpened");

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        locationService = (LocationServiceImpl)httpSession.getAttribute("locationService");

        String nextLocationName = req.getParameter("nextLocationName");
        String transferredThing = req.getParameter("transferredThing");


        LOGGER.debug("ThingsServlet, doPost is started with nextLocationName = " + nextLocationName);

        Location location = locationService.getLocation(nextLocationName);
        Hero hero = (Hero) httpSession.getAttribute("hero");
        List<Armor> armors = locationService.getArmors(nextLocationName);
        List<Potion> potions = locationService.getPotions(nextLocationName);
        List<Helper> helpers = locationService.getHelpers(nextLocationName);
        List<Weapon> weapons = locationService.getWeapons(nextLocationName);

        req.setAttribute("currentLocation", location);
        req.setAttribute("armors", armors);
        req.setAttribute("potions", potions);
        req.setAttribute("helpers", helpers);
        req.setAttribute("weapons", weapons);
        req.setAttribute("boxIsOpened", "boxIsOpened");

        httpSession.setAttribute("heroArmors", hero.getInventory().getArmors());
        httpSession.setAttribute("heroPotions", hero.getInventory().getPotions());
        httpSession.setAttribute("heroHelpers", hero.getInventory().getHelpers());
        httpSession.setAttribute("heroWeapons", hero.getInventory().getWeapons());

        if (transferredThing != null){
            thingsService.transferThingFromBoxToInventory(transferredThing, location, hero);
        }

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }
}
