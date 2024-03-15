<%@ page import="com.rodemark.models.MatchScoreModel" %><%--
  Created by IntelliJ IDEA.
  User: rodemark
  Date: 11.03.2024
  Time: 08:17
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
    <%@ include file="/view/css/match-score.css" %>
</style>

<body>
<table border="1">
    <tr>
        <th>Players</th>
        <th>Sets</th>
        <th>Games</th>
        <th>Points</th>
        <th></th> <!-- Пустая ячейка для кнопок -->
    </tr>

    <%

    %>

    <tr>
        <td class="player-name">
            <label>
                <input type="text" name="player1_name" value="${requestScope.match.playerFirst.name}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player1_sets" value="${requestScope.match.score.winSetsPlayer1}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player1_games" value="${requestScope.match.score.winGamesPlayer1}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player1_points" value="${requestScope.match.score.getFormattedPoints(requestScope.match.score.winPointsPlayer1, requestScope.match.score.winPointsPlayer2)}" readonly>
            </label>
        </td>
        <td>
            <form method="POST" action="${pageContext.request.contextPath}/match-score?uuid=${requestScope.match.uuidStr}">
                <input type="hidden" name="selectedID" value="1">
                <button type="submit" class="award" >Add point</button>
            </form>
        </td>
    </tr>

    <tr>
        <td class="player-name">
            <label>
                <input type="text" name="player2_name" value="${requestScope.match.playerSecond.name}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player2_sets" value="${requestScope.match.score.winSetsPlayer2}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player2_games" value="${requestScope.match.score.winGamesPlayer2}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player2_points" value="${requestScope.match.score.getFormattedPoints(requestScope.match.score.winPointsPlayer2, requestScope.match.score.winPointsPlayer1)}" readonly>
            </label>
        </td>
        <td>
            <form method="POST" action="${pageContext.request.contextPath}/match-score?uuid=${requestScope.match.uuidStr}">
                <input type="hidden" name="selectedID" value="2">
                <button type="submit" class="award" style="width: 100%">Add Point</button>
            </form>
        </td>
    </tr>
</table>
</body>

</html>
