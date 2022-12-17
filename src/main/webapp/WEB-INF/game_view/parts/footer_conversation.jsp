<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html lang="en">
<head>
    <title>Main page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>

<body>
<br>
<div class="container text-center border">
    <div class="row border">

        <div class="col">
            <!-- Scrollable modal -->
            <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#staticBackdrop"
                    aria-controls="staticBackdrop">
                Global statistic
            </button>

            <div class="offcanvas offcanvas-start" data-bs-backdrop="static" tabindex="-1" id="staticBackdrop"
                 aria-labelledby="staticBackdropLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="staticBackdropLabel">Global</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <div>
                        <table class="table table-success table-striped statistic">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Ended games</th>
                                <th>Killed personages</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="heroFromDB" items="${heroes}">
                                <tr>
                                    <td></td>
                                    <td>${heroFromDB.getName()}</td>
                                    <td>${heroFromDB.getCountOfEndedGames()}</td>
                                    <td>${heroFromDB.getCountOfKilledPersonages()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">

        </div>
        <div class="col">

            <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
                    aria-controls="offcanvasRight">
                Hero inventory
            </button>

            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight"
                 aria-labelledby="offcanvasRightLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasRightLabel">Hero inventory</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <div class="container_inventory">
                        <div id="con-inv1">
                            <H6>Armor</H6>
                            <c:set var="armors_is_present" scope="page" value="${!heroArmors.isEmpty()}"/>
                            <c:if test="${armors_is_present}">
                                <c:forEach var="armor" items="${heroArmors}">
<%--                                    <form action="#" method="post">--%>
                                    <p><button class="btn btn-default btn-sm my_svg box"
                                                title="${armor.name} +${armor.value} dexterity"
                                                type="submit"
                                                value="Submit">
                                            <img src="${pageContext.request.contextPath}/images/svg/${armor.name}.svg"
                                                 class="box1"
                                                 alt="Box">
                                        </button></p>
<%--                                    </form>--%>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div id="con-inv2">
                            <h6>Potion</h6>
                            <c:set var="potions_is_present" scope="page" value="${!heroPotions.isEmpty()}"/>
                            <c:if test="${potions_is_present}">
                                <c:forEach var="potion" items="${heroPotions}">
<%--                                    <form action="#" method="post">--%>
                                    <p><button class="btn btn-default btn-sm my_svg box"
                                                title="${potion.name} +${potion.value} health"
                                                type="submit"
                                                value="Submit">
                                            <img src="${pageContext.request.contextPath}/images/svg/${potion.name}.svg"
                                                 class="box1"
                                                 alt="Box">
                                        </button></p>
<%--                                    </form>--%>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div id="con-inv3">
                            <h6>Helpers</h6>
                            <c:set var="helpers_is_present" scope="page" value="${!heroHelpers.isEmpty()}"/>
                            <c:if test="${helpers_is_present}">
                                <c:forEach var="helper" items="${heroHelpers}">
<%--                                    <form action="#" method="post">--%>
                                    <p> <button class="btn btn-default btn-sm my_svg box" title="${helper.name}"
                                                type="submit"
                                                value="Submit">
                                            <img src="${pageContext.request.contextPath}/images/svg/${helper.name}.svg"
                                                 class="box1"
                                                 alt="Box">
                                        </button></p>
<%--                                    </form>--%>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div id="con-inv4">
                            <h6>Weapon</h6>
                            <c:set var="weapons_is_present" scope="page" value="${!heroWeapons.isEmpty()}"/>
                            <c:if test="${weapons_is_present}">
                                <c:forEach var="weapon" items="${heroWeapons}">
<%--                                    <form action="#" method="post">--%>
                                    <p><button class="btn btn-default btn-sm my_svg box"
                                                title="${weapon.name} +${weapon.value} strength"
                                                type="submit"
                                                value="Submit">
                                            <img src="${pageContext.request.contextPath}/images/svg/${weapon.name}.svg"
                                                 class="box1"
                                                 alt="Box">
                                        </button></p>
<%--                                    </form>--%>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
