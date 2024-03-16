<%@ page import="java.util.List" %>
<%@ page import="com.rodemark.services.MatchesService" %>
<%@ page import="com.rodemark.models.Match" %><%--
  Created by IntelliJ IDEA.
  User: rodemark
  Date: 07.03.2024
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Match score</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
</head>

<style>
    <%@ include file="/view/css/matches.css" %>
</style>

<body>
<div class="container">
    <div class="search-form">
        <form action="matches" method="get">
            <div class="search-container"> <!-- Новый контейнер для инпута и кнопки -->
                <input type="text" name="playerName" class="search-input" placeholder="Search by player name">
                <button type="submit" class="search-button">Search</button>
            </div>
        </form>
    </div>


    <table>
        <thead>
        <tr>
            <th>Player 1</th>
            <th>Player 2</th>
            <th>Winner</th>
        </tr>
        </thead>
        <tbody>
        <%
            MatchesService matchesService = (MatchesService) request.getAttribute("matchesService");
            List<Match> matches = (List<Match>) request.getAttribute("matches");
            for (Match match : matches) {
                String player1Name = matchesService.getNameByID(match.getPlayerFirstID());
                String player2Name = matchesService.getNameByID(match.getPlayerSecondID());
                String winnerName = matchesService.getNameByID(match.getWinner());
        %>
        <tr>
            <td><%= player1Name %></td>
            <td><%= player2Name %></td>
            <td><%= winnerName %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <div class="links_container">
        <a href="${pageContext.request.contextPath}/">Go back to the main page</a>
    </div>
</div>
</body>
</html>
