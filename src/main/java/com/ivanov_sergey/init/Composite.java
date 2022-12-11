package com.ivanov_sergey.init;

import com.ivanov_sergey.game.entity.Location;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Moving{
    private List<Location> components = new ArrayList<>();

    public void addComponent(Location location){
        components.add(location);
    }

    public void removeComponent(Location location){
        components.remove(location);
    }
    @Override
    public List<Location> getComponents(){
        return components;
    }
}
