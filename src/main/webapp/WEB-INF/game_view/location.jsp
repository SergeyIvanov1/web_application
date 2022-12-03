<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>

<html>
<head>
    <title>Location</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body class="background">
<script src="${pageContext.request.contextPath}/js/bootstrap.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<jsp:include page="parts/game_header.jsp"/>
<header>
    <div class="container text-center">
        <div class="row">
            <h1>${currentLocation.getName()}</h1>
        </div>
    </div>
</header>
<div class="container text-center border">
    <div class="row border">
        <div class="col border">
            <div class="container">
                <br>
                <c:set var="personages_is_present" scope="page" value="${!currentLocation.getPersonages().isEmpty()}"/>
                <c:if test="${personages_is_present}">
                    <c:forEach var="personage" items="${currentLocation.getPersonages()}">
                        <div>${personage.name}
                            <br><br>
                            <c:set var="interlocutor" scope="page" value="${personage.name}"/>
                            <c:choose>
                                <c:when test="${interlocutor == 'Guarder'}">
                                    <img src="${pageContext.request.contextPath}/images/guarder.jpeg" class="img-fluid"
                                         alt="Tramp">
                                </c:when>
                                <c:when test="${interlocutor == 'Forester'}">
                                    <img src="${pageContext.request.contextPath}/images/forester.jpeg" class="img-fluid"
                                         alt="Tramp">
                                </c:when>
                                <c:when test="${interlocutor == 'Prisoner'}">
                                    <img src="${pageContext.request.contextPath}/images/Prisoner.jpeg"
                                         class="img-fluid" alt="Tramp">
                                </c:when>
                                <c:when test="${interlocutor == 'Gnome'}">
                                    <img src="${pageContext.request.contextPath}/images/gnome.jpeg" class="img-fluid"
                                         alt="Tramp">
                                </c:when>
                                <c:when test="${interlocutor == 'Tramp'}">
                                    <img src="${pageContext.request.contextPath}/images/tramp2.jpeg" class="img-fluid"
                                         alt="Tramp">
                                </c:when>
                                <c:when test="${interlocutor == 'Hermit'}">
                                    <img src="${pageContext.request.contextPath}/images/hermit2.jpeg" class="img-fluid"
                                         alt="Tramp">
                                </c:when>
                                <c:when test="${interlocutor == 'Cheater'}">
                                    <img src="${pageContext.request.contextPath}/images/cheater2.jpeg" class="img-fluid"
                                         alt="Tramp">
                                </c:when>
                                <%--                        <c:otherwise>--%>
                                <%--                        </c:otherwise>--%>
                            </c:choose>
                            <br><br>
                            <form action="${pageContext.request.contextPath}/conversation" method="GET">
                                <input type="hidden" name="personageName" value="${personage.name}">
                                <input type="hidden" name="lastLocation" value="${currentLocation.getName()}">
                                <input class="nice_button" type="submit" value="Speak"/>
                            </form>
                            <form action="${pageContext.request.contextPath}/fight" method="POST">
                                <input type="hidden" name="personageName" value="${personage.name}">
                                <input type="hidden" name="lastLocation" value="${currentLocation.getName()}">
                                <input class="nice_button" type="submit" value="Attack"/>
                            </form>
                        </div>
                        <h6>Quest: ${personage.getQuests()}</h6>
                    </c:forEach>
                </c:if>
            </div>
        </div>

        <div class="col border">
            <div class="container">
                <c:set var="locations_is_present" scope="page" value="${!locations.isEmpty()}"/>
                <c:if test="${locations_is_present}">

                    <br><br><br>
                    <c:set var="thisLocation" scope="page" value="${currentLocation.getName()}"/>
                    <c:choose>
                        <c:when test="${thisLocation == 'Gates'}">
                            <img src="${pageContext.request.contextPath}/images/gate.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${thisLocation == 'Forest'}">
                            <img src="${pageContext.request.contextPath}/images/forest.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${thisLocation == 'Town'}">
                            <img src="${pageContext.request.contextPath}/images/town.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${thisLocation == 'Mountain'}">
                            <img src="${pageContext.request.contextPath}/images/mountain.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${thisLocation == 'Field'}">
                            <img src="${pageContext.request.contextPath}/images/field2.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${thisLocation == 'Swamp'}">
                            <img src="${pageContext.request.contextPath}/images/swamp.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <c:when test="${thisLocation == 'Village'}">
                            <img src="${pageContext.request.contextPath}/images/village.jpeg" class="img-fluid"
                                 alt="Tramp">
                        </c:when>
                        <%--                        <c:otherwise>--%>
                        <%--                        </c:otherwise>--%>
                    </c:choose>
                    <br><br>
                    <h6>Available locations:</h6>
                    <c:forEach var="location" items="${locations}">
                        <form action="${pageContext.request.contextPath}/location" method="POST">
                                <%--<input type="hidden" name="endGame" value="gameEnded">--%>
                            <input type="hidden" name="nextLocationName" value="${location.name}">
                            <input class="nice_button" type="submit" value="${location.name}"/>
                        </form>
                    </c:forEach>
                </c:if>
            </div>
        </div>

        <div class="col border">
            <div class="container">
                <br><br><br>
                <form action="${pageContext.request.contextPath}/things" method="post">
                    <input type="hidden" name="nextLocationName" value="${currentLocation.getName()}">
                    <button class="btn btn-default btn-sm my_svg box" title="coffee" type="submit" value="Submit">
                        <img class="box" src="${pageContext.request.contextPath}/images/box3.jpg" alt="Box">
                    </button>
                </form>
                <br><br>
                <c:set var="boxIsOpened" scope="page" value="${boxIsOpened != null}"/>
                <c:if test="${boxIsOpened}">

                    <div class="container2">
                        <div id="con1">
                            <H6>Armor</H6>
                            <c:set var="armors_is_present" scope="page" value="${!armors.isEmpty()}"/>
                            <c:if test="${armors_is_present}">
                                <c:forEach var="armor" items="${armors}">
                                    <form action="${pageContext.request.contextPath}/things" method="post">
                                        <input type="hidden" name="nextLocationName"
                                               value="${currentLocation.getName()}">
                                        <input type="hidden" name="transferredThing" value="${armor.name}">
                                        <button class="btn btn-default btn-sm my_svg box" title="${armor.name}"
                                                type="submit"
                                                value="Submit">
                                            <img src="${pageContext.request.contextPath}/images/svg/${armor.name}.svg"
                                                 class="box1"
                                                 alt="Box">
                                        </button>
                                    </form>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div id="con2">
                            <h6>Potion</h6>
                            <c:set var="potions_is_present" scope="page" value="${!potions.isEmpty()}"/>
                            <c:if test="${potions_is_present}">
                                <c:forEach var="potion" items="${potions}">
                                    <form action="${pageContext.request.contextPath}/things" method="post">
                                        <input type="hidden" name="nextLocationName"
                                               value="${currentLocation.getName()}">
                                        <input type="hidden" name="transferredThing" value="${potion.name}">
                                        <button class="btn btn-default btn-sm my_svg box" title="${potion.name}"
                                                type="submit"
                                                value="Submit">
                                            <img src="${pageContext.request.contextPath}/images/svg/${potion.name}.svg"
                                                 class="box1"
                                                 alt="Box">
                                        </button>
                                    </form>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div id="con3">
                            <h6>Helpers</h6>
                            <c:set var="helpers_is_present" scope="page" value="${!helpers.isEmpty()}"/>
                            <c:if test="${helpers_is_present}">
                                <c:forEach var="helper" items="${helpers}">
                                    <form action="${pageContext.request.contextPath}/things" method="post">
                                        <input type="hidden" name="nextLocationName"
                                               value="${currentLocation.getName()}">
                                        <input type="hidden" name="transferredThing" value="${helper.name}">
                                        <button class="btn btn-default btn-sm my_svg box" title="${helper.name}"
                                                type="submit"
                                                value="Submit">
                                            <img src="${pageContext.request.contextPath}/images/svg/${helper.name}.svg"
                                                 class="box1"
                                                 alt="Box">
                                        </button>
                                    </form>
                                </c:forEach>
                            </c:if>
                            </form>
                        </div>
                        <div id="con4">
                            <h6>Weapon</h6>
                            <c:set var="weapons_is_present" scope="page" value="${!weapons.isEmpty()}"/>
                            <c:if test="${weapons_is_present}">
                                <c:forEach var="weapon" items="${weapons}">
                                    <form action="${pageContext.request.contextPath}/things" method="post">
                                        <input type="hidden" name="nextLocationName"
                                               value="${currentLocation.getName()}">
                                        <input type="hidden" name="transferredThing" value="${weapon.name}">
                                        <button class="btn btn-default btn-sm my_svg box" title="${weapon.name}"
                                                type="submit"
                                                value="Submit">
                                            <img src="${pageContext.request.contextPath}/images/svg/${weapon.name}.svg"
                                                 class="box1"
                                                 alt="Box">
                                        </button>
                                    </form>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>

<br><br><br><br>
</body>
</html>
