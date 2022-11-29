package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.repository.Storage;
import com.ivanov_sergey.game.service.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    public static final int INITIAL_ID = 1;

    ModuleService moduleService = new ModuleServiceImpl();
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Storage repository = moduleService.fillRepositoryDBData(INITIAL_ID);
        LocationService locationService = new LocationServiceImpl(repository);
        FightingService fightingService = new FightingServiceImpl(repository);

        servletContext.setAttribute("locationService", locationService);
        servletContext.setAttribute("fightingService", fightingService);

//        try {
//            URL resource = servletContext.getResource("/config.json");
//            List<String> strings = Files.readAllLines(Path.of(resource.getPath()));
////            System.out.println(strings);
//
//            URL resource2 = getClass().getClassLoader().getResource("file.txt");
//            List<String> strings2 = Files.readAllLines(Path.of(resource2.getPath()));
////            System.out.println(strings2);
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
