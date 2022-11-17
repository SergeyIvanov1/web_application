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

<form action="questions" method="POST">
    <c:if test="${answers.size() > 0}">
<%--        <p>${answers}</p>--%>
        <c:forEach var="answer" items="${answers}">
            <input type="radio" name="nextQuestion" value="${answer.nextQuestion}"/>${answer.text}
            <br>
        </c:forEach>
        <br>
        <input type="submit" value="Send"/>
    </c:if>
</form>


</body>
</html>
