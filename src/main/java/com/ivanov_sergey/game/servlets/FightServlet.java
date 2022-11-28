package com.ivanov_sergey.game.servlets;

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
import java.io.IOException;

@WebServlet("/fight")
public class FightServlet extends HttpServlet {
    static final Logger LOGGER = LogManager.getRootLogger();

    ModuleService moduleService = new ModuleServiceImpl();
    LocationServiceImpl service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
//        service = (LocationServiceImpl) servletContext.getAttribute("locationService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personageName = req.getParameter("personageName");
        String nextLocationName = req.getParameter("nextLocationName");
        LOGGER.debug("LocationServlet, doPost is started with nextLocationName = " + nextLocationName);

//        req.setAttribute("currentLocation", service.getLocation(nextLocationName));
//        req.setAttribute("armors", service.getArmors(nextLocationName));
//        req.setAttribute("potions", service.getPotions(nextLocationName));
//        req.setAttribute("helpers", service.getHelpers(nextLocationName));
//        req.setAttribute("weapons", service.getWeapons(nextLocationName));
        req.setAttribute("personageName", personageName);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/fight.jsp");
        requestDispatcher.forward(req, resp);
    }
}
