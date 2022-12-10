package com.ivanov_sergey.init;

import com.ivanov_sergey.game.entity.*;
import com.ivanov_sergey.game.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    static final Logger LOGGER = LogManager.getRootLogger();
    public static final int INITIAL_ID = 1;

    ModuleService moduleService;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Location.class)
                .addAnnotatedClass(Hero.class)
                .addAnnotatedClass(Personage.class)
                .addAnnotatedClass(Armor.class)
                .addAnnotatedClass(Potion.class)
                .addAnnotatedClass(Weapon.class)
                .addAnnotatedClass(Repository.class)
                .addAnnotatedClass(Helper.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Issue.class)
                .addAnnotatedClass(Reply.class)
                .addAnnotatedClass(Quest.class);
        LOGGER.info("Hibernate Configuration created successfully");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        LOGGER.info("ServiceRegistry created successfully");
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
        LOGGER.info("SessionFactory created successfully");

        servletContextEvent.getServletContext().setAttribute("SessionFactory", sessionFactory);
        LOGGER.info("Hibernate SessionFactory Configured successfully");

        ServletContext servletContext = servletContextEvent.getServletContext();
        moduleService = new ModuleServiceImpl(sessionFactory);
        servletContext.setAttribute("moduleService", moduleService);
        Storage mainRepo = moduleService.fillRepositoryDBData(INITIAL_ID);
        servletContext.setAttribute("mainRepo", mainRepo);

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
        SessionFactory sessionFactory = (SessionFactory) servletContextEvent.getServletContext().getAttribute("SessionFactory");
        if(sessionFactory != null && !sessionFactory.isClosed()){
            LOGGER.info("Closing sessionFactory");
            sessionFactory.close();
        }
        LOGGER.info("Released Hibernate sessionFactory resource");
    }
}
