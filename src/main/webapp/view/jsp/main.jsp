<%--
  Created by IntelliJ IDEA.
  User: rodemark
  Date: 07.03.2024
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="main_container">
    <div class="header">
        <h1>Tennis</h1>
    </div>
    <div class="links_container">
        <a href="${pageContext.request.contextPath}/new-match">Start a new match</a>
        <a href="${pageContext.request.contextPath}/matches">Matches played</a>
    </div>
</div>
</body>
</html>
