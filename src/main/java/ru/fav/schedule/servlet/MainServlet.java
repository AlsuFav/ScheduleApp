package ru.fav.schedule.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.fav.schedule.model.Schedule;
import ru.fav.schedule.service.ScheduleService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("")
public class MainServlet extends HttpServlet {
    private ScheduleService scheduleService;

    @Override
    public void init() {
        this.scheduleService = (ScheduleService) getServletContext().getAttribute("scheduleService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List<Schedule> schedules = scheduleService.findAll();

            request.setAttribute("schedules", schedules);

            request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
