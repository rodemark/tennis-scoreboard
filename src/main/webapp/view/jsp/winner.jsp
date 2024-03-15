<%--
  Created by IntelliJ IDEA.
  User: rodemark
  Date: 15.03.2024
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Match score</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
</head>

<style>
    <%@ include file="/view/css/error.css" %>
</style>

<html>
<body>

<div class="main_container">
    <%
        String winner = (String) request.getAttribute("winner");
    %>
    <div class="header">
        <h1><%= winner %> is the winner!
        </h1>
    </div>
    <div class="links_container">
        <a href="${pageContext.request.contextPath}/">Go back to the main page</a>
    </div>
</div>

</body>
</html>
