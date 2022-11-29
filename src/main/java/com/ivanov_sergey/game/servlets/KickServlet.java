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

@WebServlet("/kick")
public class KickServlet extends HttpServlet {
    static final Logger LOGGER = LogManager.getRootLogger();

    ModuleService moduleService = new ModuleServiceImpl();
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
        LOGGER.debug("KickServlet, doPost is started with " +
                "nextLocationName = " + lastLocation +
                "nextLocationName = " + lastLocation +
                "attack = " + attack
                + "block = " + block);

        HttpSession session = req.getSession();
        Hero hero = (Hero) session.getAttribute("hero");
        Personage personage = service.getPersonage(personageName, lastLocation);




        Inventory heroInventory = hero.getInventory();
        req.setAttribute("personageName", personageName);
        req.setAttribute("lastLocation", lastLocation);
        resp.sendRedirect(req.getContextPath() + "/fight");


//        RequestDispatcher requestDispatcher = getServletContext()
//                .getRequestDispatcher("/WEB-INF/game_view/fight.jsp");
//        requestDispatcher.forward(req, resp);
    }


}
