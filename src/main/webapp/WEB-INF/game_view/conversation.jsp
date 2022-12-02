<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html>
<head>
    <title>Personage description</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>

<body class="background">
<script src="${pageContext.request.contextPath}/js/bootstrap.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<jsp:include page="parts/game_header.jsp"/>

<div class="container">
    <div class="container">
        <h2>${personageName}</h2>
    </div>
    <div class="container text-center border">
        <div class="row border">
            <div class="col border">
                <div class="container">
                    <c:set var="interlocutor" scope="page" value="${personageName}"/>
                    <c:choose>
                        <c:when test="${interlocutor == 'Guarder'}">
                            <img src="${pageContext.request.contextPath}/images/guarder.jpeg" class="img-fluid" alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Forester'}">
                            <img src="${pageContext.request.contextPath}/images/forester.jpeg" class="img-fluid" alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Escaped prisoner'}">
                            <img src="${pageContext.request.contextPath}/images/escaped_prisoner.jpeg" class="img-fluid" alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Gnome'}">
                            <img src="${pageContext.request.contextPath}/images/gnome.jpeg" class="img-fluid" alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Tramp'}">
                            <img src="${pageContext.request.contextPath}/images/tramp2.jpeg" class="img-fluid" alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Hermit'}">
                            <img src="${pageContext.request.contextPath}/images/hermit2.jpeg" class="img-fluid" alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Cheater'}">
                            <img src="${pageContext.request.contextPath}/images/cheater2.jpeg" class="img-fluid" alt="Tramp">
                        </c:when>
                    </c:choose>
                </div>
            </div>

            <div class="col border">
                <div class="container">
                    <br><br>
                    <h6>${issue.getText()}</h6>
                    <c:forEach var="reply" items="${issue.getReplies()}">
                        <div>
                            <form action="${pageContext.request.contextPath}/conversation" method="POST">
                                <input type="hidden" name="lastLocation" value="${lastLocation}">
                                <input type="hidden" name="personageName" value="${personageName}">
                                <input type="hidden" name="nextQuestion" value="${reply.getNextQuestion()}">
                                <input class="nice_button" type="submit" value="${reply.getText()}"/>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
