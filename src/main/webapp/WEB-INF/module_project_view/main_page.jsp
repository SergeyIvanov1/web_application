<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="parts/header.jsp" />

<br>
<div><a href="">Main page</a></div>
<div><a href="cryptanalyzer">Cryptanalyzer</a></div>
<div><a href="module">Hello page</a></div>
<br>
<br>
<h1>${question.text}</h1>

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
        <input type="hidden" name="visitorName" value="${name}">
        <input type="submit" value="Submit" />
    </form>
</c:if>
<br>


</body>
</html>
