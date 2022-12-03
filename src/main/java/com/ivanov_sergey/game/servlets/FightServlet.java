package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Inventory;
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
    static final Logger LOGGER = LogManager.getRootLogger();

    ModuleService moduleService = new ModuleServiceImpl();
    FightingService fightingService = new FightingServiceImpl();

    LocationServiceImpl service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        service = (LocationServiceImpl) servletContext.getAttribute("locationService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personageName = req.getParameter("personageName");
        String lastLocation = req.getParameter("lastLocation");
        String attack = req.getParameter("attack");
        String block = req.getParameter("block");
        String kick = req.getParameter("kick");
        LOGGER.debug("LocationServlet, doPost is started with nextLocationName = " + lastLocation);

        HttpSession session = req.getSession();
        Hero hero = (Hero) session.getAttribute("hero");
        Inventory heroInventory = hero.getInventory();
        Personage personage = service.getPersonage(personageName, lastLocation);

        if(kick != null) {
            fightingService.heroKickPersonage(hero, personage, attack);
            fightingService.personageKickHero(hero, personage, block);
        }

        int heroCurrentHealth = hero.getCurrentHealth();
        req.setAttribute("heroName", hero.getName());
        req.setAttribute("heroHealth", hero.getMaxHealth());
        req.setAttribute("heroCurrentHealth", heroCurrentHealth);
        req.setAttribute("heroCurrentPercentOfHealth", heroCurrentHealth * 100 / hero.getMaxHealth());
        req.setAttribute("heroStrength", hero.getStrength());
        req.setAttribute("heroDexterity", hero.getDexterity());
        req.setAttribute("heroArmors", heroInventory.getArmors());
        req.setAttribute("heroPotions", heroInventory.getPotions());
        req.setAttribute("heroWeapons", heroInventory.getWeapons());

        int personageCurrentHealth = personage.getCurrentHealth();
        req.setAttribute("personageName", personageName);
        req.setAttribute("personageHealth", personage.getMaxHealth());
        req.setAttribute("personageCurrentHealth", personageCurrentHealth);
        req.setAttribute("personageCurrentPercentOfHealth", personageCurrentHealth * 100 / personage.getMaxHealth());
        req.setAttribute("personageStrength", personage.getStrength());
        req.setAttribute("personageDexterity", personage.getDexterity());
        req.setAttribute("lastLocation", lastLocation);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/fight.jsp");
        requestDispatcher.forward(req, resp);
    }
}
