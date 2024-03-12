<%--
  Created by IntelliJ IDEA.
  User: rodemark
  Date: 07.03.2024
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tennis Scoreboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
</head>

<style>
    <%@ include file="/view/css/main.css" %>
</style>
<body>
<div class="main_container">
    <div class="header">
        <h1>Tennis scoreboard</h1>
    </div>
    <div class="links_container">
        <a href="${pageContext.request.contextPath}/new-match">Start a new match</a>
        <a href="${pageContext.request.contextPath}/matches">Matches played</a>
    </div>
</div>
</body>
</html>