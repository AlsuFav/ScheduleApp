package ru.fav.schedule.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Schedule {
    private int id;
    private String classroom;
    private String time;
    private String dayOfWeek;
    private String teacher;
    private String groupName;

    public Schedule(String classroom, String time, String dayOfWeek, String teacher, String groupName) {
        this.classroom = classroom;
        this.time = time;
        this.dayOfWeek = dayOfWeek;
        this.teacher = teacher;
        this.groupName = groupName;
    }
}