package ru.fav.schedule.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import ru.fav.schedule.config.DataSourceConfiguration;
import ru.fav.schedule.dao.ScheduleDAO;
import ru.fav.schedule.filter.LoggerFilter;
import ru.fav.schedule.model.Schedule;
import ru.fav.schedule.service.ScheduleService;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;


@WebListener
public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        Logger logger = LogManager.getLogger(LoggerFilter.class);
        servletContext.setAttribute("logger", logger);

        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("flyway.conf"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Flyway flyway = Flyway.configure()
                .configuration(properties)
                .load();

        flyway.migrate();



        properties = new Properties();

        try {
            properties.load(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataSourceConfiguration configuration =
                new DataSourceConfiguration(properties);

        DataSource dataSource = configuration.hikariDataSource();

        ScheduleDAO scheduleDAO = new ScheduleDAO(dataSource);
        ScheduleService scheduleService = new ScheduleService(scheduleDAO);

        servletContext.setAttribute("scheduleService", scheduleService);
    }

}
