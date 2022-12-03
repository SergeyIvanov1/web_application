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

    LocationServiceImpl service;
    ThingsService thingsService = new ThingsServiceImpl();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        service = (LocationServiceImpl) servletContext.getAttribute("locationService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextLocationName = req.getParameter("nextLocationName");
        LOGGER.debug("ThingsServlet, doPost is started with nextLocationName = " + nextLocationName);

        req.setAttribute("currentLocation", service.getLocation(nextLocationName));
        req.setAttribute("armors", service.getArmors(nextLocationName));
        req.setAttribute("potions", service.getPotions(nextLocationName));
        req.setAttribute("helpers", service.getHelpers(nextLocationName));
        req.setAttribute("weapons", service.getWeapons(nextLocationName));
        req.setAttribute("boxIsOpened", "boxIsOpened");

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String nextLocationName = req.getParameter("nextLocationName");
        String transferredThing = req.getParameter("transferredThing");

        LOGGER.debug("ThingsServlet, doPost is started with nextLocationName = " + nextLocationName);

        Location location = service.getLocation(nextLocationName);
        Hero hero = (Hero) session.getAttribute("hero");
        List<Armor> armors = service.getArmors(nextLocationName);
        List<Potion> potions = service.getPotions(nextLocationName);
        List<Helper> helpers = service.getHelpers(nextLocationName);
        List<Weapon> weapons = service.getWeapons(nextLocationName);

        if (transferredThing != null){
            thingsService.transferThingToInventory(transferredThing, location, hero);
        }

        req.setAttribute("currentLocation", location);
        req.setAttribute("armors", armors);
        req.setAttribute("potions", potions);
        req.setAttribute("helpers", helpers);
        req.setAttribute("weapons", weapons);
        req.setAttribute("boxIsOpened", "boxIsOpened");

        session.setAttribute("heroArmors", hero.getInventory().getArmors());
        session.setAttribute("heroPotions", hero.getInventory().getPotions());
        session.setAttribute("heroHelpers", hero.getInventory().getHelpers());
        session.setAttribute("heroWeapons", hero.getInventory().getWeapons());

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }
}
