package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.entity.Location;

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

@WebServlet("/things")
public class ThingsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentLocation = req.getParameter("currentLocation");
        HttpSession session = req.getSession();
        List<Location> locations = (List<Location>) session.getAttribute("locations");
        Optional<Location> optional = locations.stream()
                .filter((location) -> currentLocation.equals(location.getName()))
                .findFirst();
        optional.ifPresent(returnLocation -> {
            req.setAttribute("currentLocation", returnLocation);
            req.setAttribute("armors", returnLocation.getArmors());
            req.setAttribute("potions", returnLocation.getPotions());
            req.setAttribute("helpers", returnLocation.getHelpers());
            req.setAttribute("weapons", returnLocation.getWeapons());
        });

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/game_view/location.jsp");
        requestDispatcher.forward(req, resp);
    }
}
