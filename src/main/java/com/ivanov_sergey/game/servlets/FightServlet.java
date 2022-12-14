package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Inventory;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.entity.Personage;
import com.ivanov_sergey.game.service.*;
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

@WebServlet("/fight")
public class FightServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getRootLogger();

//    private ModuleService moduleService;
    private FightingService fightingService;
    private ThingsService thingsService = new ThingsServiceImpl();

    private LocationServiceImpl locationService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        ServletContext servletContext = config.getServletContext();
//        moduleService = (ModuleServiceImpl) servletContext.getAttribute("moduleService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personageName = req.getParameter("personageName");
        String lastLocation = req.getParameter("lastLocation");
        String attack = req.getParameter("attack");
        String block = req.getParameter("block");
        String kick = req.getParameter("kick");
        String thing = req.getParameter("useThing");
        LOGGER.debug("LocationServlet, doPost is started with nextLocationName = " + lastLocation);

        HttpSession httpSession = req.getSession();
        locationService = (LocationServiceImpl) httpSession.getAttribute("locationService");
        fightingService = (FightingServiceImpl) httpSession.getAttribute("fightingService");

        String currentLocal = (String) httpSession.getAttribute("currentLocal");
        Hero hero = (Hero) httpSession.getAttribute("hero");
        Inventory heroInventory = hero.getInventory();

        Personage personage = null;
        if (!personageName.equals("")) {
            personage = locationService.getPersonage(personageName, currentLocal);
        }
        Location location = locationService.getLocation(currentLocal);

        String heroReport = "";
        String personageReport = "";

        if (kick != null) {
            personageReport = fightingService.heroKickPersonage(hero, personage, attack);
            if (personage.getCurrentHealth() == 0) {
                fightingService.deletePersonage(personage, location);
                int count = hero.getCountOfKilledPersonages();
                hero.setCountOfKilledPersonages(++count);

            } else {
                heroReport = fightingService.personageKickHero(hero, personage, block);
                if (hero.getCurrentHealth() == 0) {
                    resp.sendRedirect(req.getContextPath() + "/defeated");
                    return;
                }
            }
        }

        if (thing != null) {
            heroReport = thingsService.useThing(thing, location, hero);
        }

        int heroCurrentHealth = hero.getCurrentHealth();
        req.setAttribute("heroReport", heroReport);
        req.setAttribute("personageReport", personageReport);

        req.setAttribute("heroName", hero.getName());
        req.setAttribute("heroHealth", hero.getMaxHealth());
        req.setAttribute("heroCurrentHealth", heroCurrentHealth);
        req.setAttribute("heroCurrentPercentOfHealth", heroCurrentHealth * 100 / hero.getMaxHealth());
        req.setAttribute("heroStrength", hero.getStrength());
        req.setAttribute("heroDexterity", hero.getDexterity());
        req.setAttribute("usingArmors", hero.getUsingArmors());
        req.setAttribute("usingWeapons", hero.getUsingWeapons());
        req.setAttribute("heroArmors", heroInventory.getArmors());
        req.setAttribute("heroPotions", heroInventory.getPotions());
        req.setAttribute("heroWeapons", heroInventory.getWeapons());

        if (personage != null && personage.getCurrentHealth() != 0) {
            int personageCurrentHealth = personage.getCurrentHealth();
            req.setAttribute("personageName", personageName);
            req.setAttribute("personageHealth", personage.getMaxHealth());
            req.setAttribute("personageCurrentHealth", personageCurrentHealth);
            req.setAttribute("personageCurrentPercentOfHealth", personageCurrentHealth * 100 / personage.getMaxHealth());
            req.setAttribute("personageStrength", personage.getStrength());
            req.setAttribute("personageDexterity", personage.getDexterity());

        }
        httpSession.setAttribute("lastLocation", lastLocation);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/fight.jsp");
        requestDispatcher.forward(req, resp);
    }
}
