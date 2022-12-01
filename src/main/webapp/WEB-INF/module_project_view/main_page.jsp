<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<jsp:include page="parts/header.jsp"/>

<br>
<div class="container">
    <h1>${question.text}</h1>

    <c:if test="${answers.size() > 0}">
        <form action="${pageContext.request.contextPath}/questions" method="POST">
            <c:forEach var="answer" items="${answers}">
                <input type="radio" name="nextQuestion" value="${answer.nextQuestion}" required/>${ answer.text}
                <br>
            </c:forEach>
            <br>
            <input class="nice_button" type="submit" value="Send"/>
        </form>
    </c:if>
    <c:if test="${answers.size() == 0}">
        <form action="${pageContext.request.contextPath}/questions" method="GET">
            <input type="hidden" name="endGame" value="gameEnded">
            <input type="hidden" name="visitorName" value="${name}">
            <input class="nice_button" type="submit" value="Come back to first question"/>
        </form>
    </c:if>
    <br>
    <br>
    <br>
</div>
<jsp:include page="parts/footer.jsp"/>

</body>
</html>
