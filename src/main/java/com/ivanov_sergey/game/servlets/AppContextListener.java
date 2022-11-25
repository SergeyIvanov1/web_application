package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.repository.Repository;
import com.ivanov_sergey.game.repository.Storage;
import com.ivanov_sergey.game.service.LocationService;
import com.ivanov_sergey.game.service.LocationServiceImpl;
import com.ivanov_sergey.game.service.ModuleService;
import com.ivanov_sergey.game.service.ModuleServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@WebListener
public class AppContextListener implements ServletContextListener {
    public static final int INITIAL_ID = 1;

    ModuleService moduleService = new ModuleServiceImpl();
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Storage repository = moduleService.fillRepositoryDBData(INITIAL_ID);
        LocationService locationService = new LocationServiceImpl(repository);

        servletContext.setAttribute("locationService", locationService);


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
