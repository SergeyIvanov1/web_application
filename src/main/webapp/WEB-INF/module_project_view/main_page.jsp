<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<h1>Question: ${requestScope.get("question")}</h1>--%>
<br>
<h1>${question.text}</h1>
<%--<p>${answers}</p>--%>
<p>el = ${visitor}</p>
<p>sessionScope = ${sessionScope.visitor}</p>

<c:if test="${answers.size() > 0}">
    <form action="questions" method="POST">
        <c:forEach var="answer" items="${answers}">
            <input type="radio" name="nextQuestion" value="${answer.nextQuestion}" required/>${answer.text}
            <br>
        </c:forEach>
        <br>
        <input type="submit" value="Send"/>
    </form>
</c:if>
<c:if test="${answers.size() == 0}">
    <form action="questions" method="GET">
        <p>Come back to first question:</p>
        <input type="hidden" name="endGame" value="gameEnded">
        <input type="submit" value="Submit"/>
    </form>
</c:if>
<br>
<h3>Statistic:</h3>
<div>Ip address: ${clientIPAddress}</div>
<div>Name in the game: ${name}</div>
<div>Count of games: ${countOfGames}</div>

</body>
</html>
