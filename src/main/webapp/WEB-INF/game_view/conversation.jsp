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
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.js"></script>
<jsp:include page="parts/game_header.jsp"/>

<div class="container">
    <div class="container">
        <br>
        <h1>${personageName}</h1>
    </div>
    <div class="container text-center border">
        <div class="row border">
            <div class="col border">
                <div class="container">
                    <c:set var="interlocutor" scope="page" value="${personageName}"/>
                    <c:choose>
                        <c:when test="${interlocutor == 'Guarder'}">
                            <img src="${pageContext.request.contextPath}/images/Guarder.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Forester'}">
                            <img src="${pageContext.request.contextPath}/images/Forester.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Prisoner'}">
                            <img src="${pageContext.request.contextPath}/images/Prisoner.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Gnome'}">
                            <img src="${pageContext.request.contextPath}/images/Gnome.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Tramp'}">
                            <img src="${pageContext.request.contextPath}/images/Tramp.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Hermit'}">
                            <img src="${pageContext.request.contextPath}/images/Hermit.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${interlocutor == 'Cheater'}">
                            <img src="${pageContext.request.contextPath}/images/Cheater.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                    </c:choose>
                </div>
            </div>

            <div class="col border">
                <div class="container">
                    <br><br>
<%--                    <c:set var="fighting" scope="page" value="${issue == 'fight'}"/>--%>
                    <c:if test="${fighting == 'fighting'}">
                        <h6>${personageName} was humiliated. He wants to kill you.</h6>
                        <div>
                            <form action="${pageContext.request.contextPath}/fight" method="POST">
                                <input type="hidden" name="lastLocation" value="${lastLocation}">
                                <input type="hidden" name="personageName" value="${personageName}">
                                <input class="nice_button" type="submit" value="Fight"/>
                            </form>
                        </div>
                    </c:if>
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
<jsp:include page="parts/footer_location_and_conversation.jsp"/>
</body>
</html>
