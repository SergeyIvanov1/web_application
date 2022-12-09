<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html>
<head>
    <title>Main page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.js"></script>
<br>
<div class="container">

    <form action="remove_attribute" method="GET">
        <input class="nice_button" type="submit" value="Sign out"/>
    </form>
    <form action="questions" method="GET">
        <input type="hidden" name="visitorName" value="${name}">
        <c:if test="${answers.size() == 0}">
            <input type="hidden" name="endGame" value="gameEnded">
        </c:if>
        <input class="nice_button" type="submit" value="Return to first question"/>
    </form>
    <br>

    <p>Application is using next technologies:
        Java 17, Lombok, Tomcat 9, Maven, Log4j, Junit, Mockito, MySQL, Hibernate,
        Docker-compose, HTML, CSS, Servlet, JSTL, CI.</p>

</div>
</body>
</html>
