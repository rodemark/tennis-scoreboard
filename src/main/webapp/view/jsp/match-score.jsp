<jsp:useBean id="match" scope="request" type="com.rodemark.models.MatchScoreModel"/>

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
    <tr>
        <td class="player-name">
            <label>
                <input type="text" name="player1_name" value="${match.playerFirst.name}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player1_sets" value="${match.score.sets.get(1)}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player1_games" value="${match.score.currentSet.games.get(1)}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player1_points" value="${match.score.currentSet.currentGame.points.get(1)}" readonly>
            </label>
        </td>
        <td>
            <button class="add-point-button">Add Point</button>
        </td>
    </tr>
    <tr>
        <td class="player-name">
            <label>
                <input type="text" name="player2_name" value="${match.playerSecond.name}" readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player2_sets" value=" " readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player2_games" value=" " readonly>
            </label>
        </td>
        <td>
            <label>
                <input type="text" name="player2_points" value=" " readonly>
            </label>
        </td>
        <td>
            <button class="add-point-button">Add Point</button>
        </td>
    </tr>
</table>
</body>

</html>
