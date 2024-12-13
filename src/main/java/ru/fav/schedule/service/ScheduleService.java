package ru.fav.schedule.service;

import lombok.AllArgsConstructor;
import ru.fav.schedule.dao.ScheduleDAO;
import ru.fav.schedule.model.Schedule;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class ScheduleService {
    private final ScheduleDAO scheduleDAO;

    public List<Schedule> findAll() throws SQLException {
        return scheduleDAO.findAll();
    }

    public Schedule findById(int id) throws SQLException {
        return scheduleDAO.findById(id).orElse(null);
    }
}
