package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Location;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class HandleService {

    public void setAttributesToRequest(HttpServletRequest req, String nextLocationName){
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
    }
}
