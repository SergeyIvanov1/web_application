<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Statistic:</h3>
<div>Ip address: ${clientIPAddress}</div>
<div>Name in the game: ${name}</div>
<div>Count of games: ${countOfGames}</div>

<form action="questions" method="GET">
    <p>Return to first question:</p>
    <input type="hidden" name="visitorName" value="${name}">
    <c:if test="${answers.size() == 0}">
        <input type="hidden" name="endGame" value="gameEnded">
    </c:if>
    <input type="submit" value="Submit"/>
</form>

<form action="remove_attribute" method="GET">
    <p>Sign out:</p>
    <input type="submit" value="Submit" />
</form>

</body>
</html>
