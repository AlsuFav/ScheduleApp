package ru.fav.schedule.dao;

import lombok.AllArgsConstructor;
import ru.fav.schedule.model.Schedule;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ScheduleDAO {
    private final DataSource dataSource;

    public List<Schedule> findAll() throws SQLException {
        List<Schedule> schedules = new ArrayList<>();
        String query = "SELECT * FROM schedule";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Schedule schedule = new Schedule(
                        resultSet.getInt("id"),
                        resultSet.getString("classroom"),
                        resultSet.getString("time"),
                        resultSet.getString("day_of_week"),
                        resultSet.getString("teacher"),
                        resultSet.getString("group_name")
                );
                schedules.add(schedule);
            }
        }

        return schedules;
    }

    public Optional<Schedule> findById(int id) throws SQLException {
        String query = "SELECT * FROM schedule WHERE id = ?";
        Schedule schedule = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                schedule = new Schedule(
                        resultSet.getInt("id"),
                        resultSet.getString("classroom"),
                        resultSet.getString("time"),
                        resultSet.getString("day_of_week"),
                        resultSet.getString("teacher"),
                        resultSet.getString("group_name")
                );
            }

        }

        return Optional.ofNullable(schedule);
    }
}
