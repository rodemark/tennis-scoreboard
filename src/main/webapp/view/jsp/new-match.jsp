<%--
  Created by IntelliJ IDEA.
  User: rodemark
  Date: 07.03.2024
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
    <%@ include file="/view/css/new-match.css" %>
</style>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New match</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
</head>

<body>
<div class="container">
    <h1>New Match</h1>

    <form method="post">
        <label for="player1">Player 1:</label>
        <input type="text" id="player1" name="player1" required><br><br>

        <label for="player2">Player 2:</label>
        <input type="text" id="player2" name="player2" required><br><br>

        <input type="submit" value="Start Match">
    </form>
    <div class="links_container">
        <a href="${pageContext.request.contextPath}/">Go back to the main page</a>
    </div>

</div>
</body>




</html>
