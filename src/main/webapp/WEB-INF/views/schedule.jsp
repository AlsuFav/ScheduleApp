<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Детали расписания</title>
</head>
<body>
<h1>Детали расписания</h1>

<p>Номер аудитории: ${schedule.classroom}</p>
<p>Время: ${schedule.time}</p>
<p>День недели: ${schedule.dayOfWeek}</p>
<p>Преподаватель: ${schedule.teacher}</p>
<p>Группа: ${schedule.groupName}</p>

<p><a href="${pageContext.request.contextPath}">Назад к списку расписаний</a></p>

</body>
</html>