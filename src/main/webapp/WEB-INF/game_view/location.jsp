<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>

<html>
<head>
    <title>Location</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

<div class="container text-center">
    <div class="row">

        <div class="col">
            <div class="container">
                <br><br>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Show statistic
                </button>
                <br><br>
                <c:if test="${personages.size() > 0}">

                    <h3>Personages on location:</h3>
                    <br>

                    <c:forEach var="personage" items="${personages}">
                        <form action="personage" method="POST">
                                <%--                            <input type="hidden" name="endGame" value="gameEnded">--%>
                            <input type="hidden" name="personageName" value="${personage.name}">
                            <input class="nice_button" type="submit" value="${personage.name}"/>
                        </form>
                    </c:forEach>
                </c:if>
            </div>
        </div>


        <div class="col">
            <br>
            <div class="container">
                <h1>${location.name}</h1>
            </div>
            <br><br>
            <c:if test="${answers.size() > 0}">
                <form action="questions" method="POST">
                    <c:forEach var="answer" items="${answers}">
                        Introduce yourself: <input name="visitorName" required/>
                        <br><br>
                        <input class="nice_button" type="submit" value="Introduce"/>
                        <%--                        <input type="radio" name="nextQuestion" value="${answer.nextQuestion}"--%>
                        <%--                               required/>${ answer.text}--%>
                        <%--                        <br>--%>
                    </c:forEach>
                    <br>
                    <input class="nice_button" type="submit" value="Send"/>
                </form>
            </c:if>
        </div>


        <div class="col">
            <div class="container">

            </div>
        </div>

    </div>
</div>
<div class="container">
    ${hero}

    <br><br>
    ${location}

    <br><br>
    ${location2}

    <br><br>
    ${repository}
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Statistic:</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div>Ip address: ${clientIPAddress}</div>
                <div>Name in the game: ${name}</div>
                <div>Count of games: ${countOfGames}</div>
            </div>
            <div class="modal-footer">
                <%--                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Ok</button>--%>
                <%--                <button type="button" class="btn btn-primary">Save changes</button>--%>
            </div>
        </div>
    </div>
</div>


</body>
</html>
