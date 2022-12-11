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
                <div>Count of ended games: ${hero.getCountOfEndedGames()}</div><br>
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

</body>
</html>
