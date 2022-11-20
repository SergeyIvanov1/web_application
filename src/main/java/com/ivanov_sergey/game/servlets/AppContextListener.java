package com.ivanov_sergey.game.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
//        servletContext.setAttribute();


        try {
            URL resource = servletContext.getResource("/config.json");
            List<String> strings = Files.readAllLines(Path.of(resource.getPath()));
            System.out.println(strings);

            URL resource2 = getClass().getClassLoader().getResource("file.txt");
            List<String> strings2 = Files.readAllLines(Path.of(resource2.getPath()));
            System.out.println(strings2);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
