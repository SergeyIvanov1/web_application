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
<div class="container text-center border">
    <div class="row">
        <div class="col">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="start_game">Start game page</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-bs-toggle="modal" href="#exampleModalToggle" role="button">View the
                        letter</a>
                </li>
                <li class="nav-item">
                    <div class="btn-group">
                        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                            Quests
                        </button>
                        <c:set var="quests_is_present" scope="page" value="${hero.getQuests().size() > 0}"/>
                        <c:if test="${quests_is_present}">
                            <ul class="dropdown-menu">
                                <c:forEach var="quest" items="${hero.getQuests()}">
                                    <li><a class="dropdown-item" href="#">${quest.text}</a></li>
                                </c:forEach>
                            </ul>
                        </c:if>
                        <c:if test="${hero.getQuests().isEmpty()}">
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">You have no quests</a></li>
                            </ul>
                        </c:if>
                    </div>
                </li>
            </ul>
        </div>
        <div class="col">

        </div>
        <div class="col">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModalMap">
                Map
            </button>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Statistic
            </button>
        </div>
    </div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Statistic</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div>Ip address: ${clientIPAddress}</div>
                <div>Time of starting this game: ${timeOfCreateGame}</div>
                <div>Name in the game: ${name}</div>
                <div>Count of ended games: ${hero.getCountOfEndedGames()}</div>
                <br>
                <div>Count of killed personages: ${count_of_killed_personages_in_game}</div>
                <div>Common of count killed personages during all games: ${hero.getCountOfKilledPersonages()}</div>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="exampleModalMap" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabelMap">Map</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <img src="${pageContext.request.contextPath}/images/Map.png" class="img-fluid" alt="Map">
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel"
     tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalToggleLabel">Content of letter</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Ymfsp dtz ktw uqfdji ymnx lfrj. N mtuj ny lfaj dtz uqjfxzwj.
            </div>
            <c:if test="${letterDecrypted == 'letterDecrypted'}">
            <div class="modal-footer">
                <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">Decrypt
                </button>
            </div>
            </c:if>
            <c:if test="${letterDecrypted == null}">
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-toggle="popover" data-bs-placement="right"
                        data-bs-custom-class="custom-popover"
                        data-bs-title="it is too early"
                        data-bs-content="You need the key." title="You need key!">
                    Decrypt
                </button>
            </div>
            </c:if>
        </div>
    </div>
</div>
<div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2"
     tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalToggleLabel2">Decrypt</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Thank you for played this game. I hope it gave you pleasure.
            </div>
        </div>
    </div>
</div>

</body>
</html>
