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
<header>
    <div class="container text-center">
        <div class="row">

            <div class="col">
                <div class="container">
                    <br><br>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Show statistic
                    </button>
                </div>
            </div>

            <div class="col">
                <br>
                <div class="container">
                    <h1>${currentLocation.getName()}</h1>
                </div>
            </div>

            <div class="col">
                <div class="container">

                </div>
            </div>
        </div>
    </div>
</header>
<div class="container text-center">
    <div class="row">

        <div class="col">
            <div class="container">
                <br><br>
                <c:set var="personages_is_present" scope="page" value="${!currentLocation.getPersonages().isEmpty()}"/>

                <c:if test="${personages_is_present}">

                    <h6>Personages on location:</h6>
                    <c:forEach var="personage" items="${currentLocation.getPersonages()}">
                        <div>${personage.name}
                            <br>
                            <form action="conversation" method="GET">
                                <input type="hidden" name="personageName" value="${personage.name}">
                                <input type="hidden" name="lastLocation" value="${currentLocation.getName()}">
                                <input class="nice_button" type="submit" value="Speak"/>
                            </form>
                            <form action="#" method="POST">
                                <input type="hidden" name="personageName" value="${personage.name}">
                                <input class="nice_button" type="submit" value="Attack"/>
                            </form>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>

        <div class="col">
            <div class="container">
                <br><br>
                <c:set var="locations_is_present" scope="page" value="${!locations.isEmpty()}"/>
                <c:if test="${locations_is_present}">
                    <h6>Available locations:</h6>
<%--                    <br>--%>
                    <c:forEach var="location" items="${locations}">
                        <form action="location" method="POST">
                                <%--<input type="hidden" name="endGame" value="gameEnded">--%>
                            <input type="hidden" name="nextLocationName" value="${location.name}">
                            <input class="nice_button" type="submit" value="${location.name}"/>
                        </form>
                    </c:forEach>
                </c:if>
            </div>
        </div>

        <div class="col">
            <div class="container">
                <br><br>
                <c:set var="armors_is_present" scope="page" value="${!armors.isEmpty()}"/>
                <c:if test="${armors_is_present}">
                    <h6>Armors:</h6>
<%--                    <br>--%>
                    <c:forEach var="armor" items="${armors}">
                        <form action="things" method="POST">
                            <input type="hidden" name="currentLocation" value="${currentLocation.getName()}">
                            <input type="hidden" name="armorName" value="${armor.name}">
                            <input class="nice_button" type="submit" value="${armor.name}"/>
                        </form>
                    </c:forEach>
                </c:if>
                <%--            </div>--%>

                <%--            <div class="container">--%>
<%--                <br><br>--%>
                <c:set var="potions_is_present" scope="page" value="${!potions.isEmpty()}"/>
                <c:if test="${potions_is_present}">
                    <h6>Potions:</h6>
<%--                    <br>--%>
                    <c:forEach var="potion" items="${potions}">
                        <form action="things" method="POST">
                            <input type="hidden" name="currentLocation" value="${currentLocation.getName()}">
                            <input type="hidden" name="potionName" value="${potion.name}">
                            <input class="nice_button" type="submit" value="${potion.name}"/>
                        </form>
                    </c:forEach>
                </c:if>
                <%--            </div>--%>

                <%--            <div class="container">--%>
<%--                <br><br>--%>
                <c:set var="helpers_is_present" scope="page" value="${!helpers.isEmpty()}"/>
                <c:if test="${helpers_is_present}">
                    <h6>Helpers:</h6>
<%--                    <br>--%>
                    <c:forEach var="helper" items="${helpers}">
                        <form action="things" method="POST">
                            <input type="hidden" name="currentLocation" value="${currentLocation.getName()}">
                            <input type="hidden" name="helperName" value="${helper.name}">
                            <input class="nice_button" type="submit" value="${helper.name}"/>
                        </form>
                    </c:forEach>
                </c:if>
                <%--            </div>--%>

                <%--            <div class="container">--%>
<%--                <br><br>--%>
                <c:set var="weapons_is_present" scope="page" value="${!weapons.isEmpty()}"/>
                <c:if test="${weapons_is_present}">
                    <h6>Weapons:</h6>
<%--                    <br>--%>
                    <c:forEach var="weapon" items="${weapons}">
                        <form action="things" method="POST">
                            <input type="hidden" name="currentLocation" value="${currentLocation.getName()}">
                            <input type="hidden" name="weaponName" value="${weapon.name}">
                            <input class="nice_button" type="submit" value="${weapon.name}"/>
                        </form>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
</div>

<br><br><br><br>
<footer>
    <div class="container">
        <h3> hero: </h3>
        ${hero}

        <br><br>
        <h3> repository: </h3>${repository}
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
                </div>
            </div>
        </div>
    </div>

</footer>
</body>
</html>
