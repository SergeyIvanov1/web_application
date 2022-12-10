<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>

<html>
<head>
    <title>Fight</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>

<body class="background">
<script src="${pageContext.request.contextPath}/js/bootstrap.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<jsp:include page="parts/game_header.jsp"/>

<div class="container text-center border">
    <br>
    <h1>Fighting</h1>
    <form action="${pageContext.request.contextPath}/fight" method="POST">
        <div class="row border">
            <div class="col border">
                <br>
                <h2>${heroName}</h2>
                <p>Health: ${heroCurrentHealth}/${heroHealth}</p>
                <div class="progress">
                    <div class="progress-bar" role="progressbar" aria-label="Example with label"
                         style="width: ${heroCurrentPercentOfHealth}%;" aria-valuenow="${heroCurrentHealth}"
                         aria-valuemin="0" aria-valuemax="${heroHealth}">${heroCurrentPercentOfHealth}%
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col">
                        <p>Strength: ${heroStrength}</p>
                        <p>Dexterity: ${heroDexterity}</p>
                        <div class="fighting-history">
                            <p>${heroReport}</p>
                        </div>
                    </div>

                    <div class="col">
                        <p>Block:</p>
                        <select name="block" class="form-select form-select-sm" aria-label=".form-select-sm example">
                            <option value="head" selected>Head</option>
                            <option value="body">Body</option>
                            <option value="legs">Legs</option>
                        </select>
                        <br>
                        <h6>Used armor:</h6>
                        <div class="fight-tools">
                            <c:forEach var="armor" items="${usingArmors}">
                                <div class="used-things"><img
                                        src="${pageContext.request.contextPath}/images/svg/${armor.name}.svg"
                                        class="box1"
                                        alt="Box"
                                        title="${armor.name}">
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="col">
                        <p> Attack:</p>
                        <select name="attack" class="form-select form-select-sm" aria-label=".form-select-sm example"
                                required>
                            <option value="head" selected>Head</option>
                            <option value="body">Body</option>
                            <option value="legs">Legs</option>
                        </select>
                        <br>
                        <h6>Used weapon:</h6>
                        <div class="fight-tools">
                            <c:forEach var="weapon" items="${usingWeapons}">
                                <div class="used-things"><img
                                        src="${pageContext.request.contextPath}/images/svg/${weapon.name}.svg"
                                        class="box1"
                                        alt="Box"
                                        title="${weapon.name}"></div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col border">
                <br>
                <c:set var="personages_is_not_present" scope="page" value="${personageName == null}"/>
                <c:if test="${personages_is_not_present}">
                    <h3>Personage killed</h3>
                </c:if>
                <c:set var="personages_is_present" scope="page" value="${personageName != null}"/>
                <c:if test="${personages_is_present}">
                    <h2>${personageName}</h2>
                    <p>Health: ${personageCurrentHealth}/${personageHealth}</p>
                    <div class="progress">
                        <div class="progress-bar" role="progressbar" aria-label="Example with label"
                             style="width: ${personageCurrentPercentOfHealth}%;"
                             aria-valuenow="${personageCurrentHealth}"
                             aria-valuemin="0" aria-valuemax="${personageHealth}">${personageCurrentPercentOfHealth}%
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col">
                            <c:set var="interlocutor" scope="page" value="${personageName}"/>
                            <img src="${pageContext.request.contextPath}/images/${interlocutor}.jpeg" class="img-fluid"
                                 alt="Tramp">
                                <%--                        <c:choose>--%>
                                <%--                            <c:when test="${interlocutor == 'Guarder'}">--%>
                                <%--                                <img src="${pageContext.request.contextPath}/images/Guarder.jpeg" class="img-fluid"--%>
                                <%--                                     alt="Tramp">--%>
                                <%--                            </c:when>--%>
                                <%--                            <c:when test="${interlocutor == 'Forester'}">--%>
                                <%--                                <img src="${pageContext.request.contextPath}/images/Forester.jpeg" class="img-fluid"--%>
                                <%--                                     alt="Tramp">--%>
                                <%--                            </c:when>--%>
                                <%--                            <c:when test="${interlocutor == 'Prisoner'}">--%>
                                <%--                                <img src="${pageContext.request.contextPath}/images/Prisoner.jpeg"--%>
                                <%--                                     class="img-fluid" alt="Tramp">--%>
                                <%--                            </c:when>--%>
                                <%--                            <c:when test="${interlocutor == 'Gnome'}">--%>
                                <%--                                <img src="${pageContext.request.contextPath}/images/Gnome.jpeg" class="img-fluid"--%>
                                <%--                                     alt="Tramp">--%>
                                <%--                            </c:when>--%>
                                <%--                            <c:when test="${interlocutor == 'Tramp'}">--%>
                                <%--                                <img src="${pageContext.request.contextPath}/images/Tramp.jpeg" class="img-fluid"--%>
                                <%--                                     alt="Tramp">--%>
                                <%--                            </c:when>--%>
                                <%--                            <c:when test="${interlocutor == 'Hermit'}">--%>
                                <%--                                <img src="${pageContext.request.contextPath}/images/Hermit.jpeg" class="img-fluid"--%>
                                <%--                                     alt="Tramp">--%>
                                <%--                            </c:when>--%>
                                <%--                            <c:when test="${interlocutor == 'Cheater'}">--%>
                                <%--                                <img src="${pageContext.request.contextPath}/images/Cheater.jpeg" class="img-fluid"--%>
                                <%--                                     alt="Tramp">--%>
                                <%--                            </c:when>--%>
                                <%--                        </c:choose>--%>
                        </div>
                        <div class="col">
                            <p>Strength: ${personageStrength}</p>
                            <p>Dexterity: ${personageDexterity}</p>
                            <div class="fighting-history">
                                <p>${personageReport}</p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
        <br>
        <input type="hidden" name="personageName" value="${personageName}">
        <input type="hidden" name="lastLocation" value="${lastLocation}">
        <input type="hidden" name="kick" value="kick">
        <c:if test="${personages_is_present}">
            <input type="submit" value="Kick ${personageName}"/>
        </c:if>
    </form>
</div>
<jsp:include page="parts/footer_game.jsp"/>
</body>
</html>
