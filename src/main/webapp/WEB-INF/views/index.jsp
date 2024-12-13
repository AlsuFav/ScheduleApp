<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Расписание</title>
</head>
<body>
<h1>Список расписаний</h1>
<table border="1">
    <thead>
    <tr>
        <th>Номер аудитории</th>
        <th>Время</th>
        <th>День недели</th>
        <th>Преподаватель</th>
        <th>Группа</th>
        <th>Детали</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="schedule" items="${schedules}">
        <tr>
            <td> ${schedule.classroom}</td>
            <td> ${schedule.time}</td>
            <td> ${schedule.dayOfWeek}</td>
            <td> ${schedule.teacher}</td>
            <td> ${schedule.groupName}</td>
            <td>
                <a href="schedule?id=${schedule.id}">Подробнее</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>