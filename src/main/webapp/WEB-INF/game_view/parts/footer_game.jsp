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
    <%--        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>

<body>
<div class="container text-center border">
    <div class="row border">
        <div class="col">

        </div>
        <div class="col">
            <!-- Scrollable modal -->
            <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#staticBackdrop" aria-controls="staticBackdrop">
                Global statistic
            </button>

            <div class="offcanvas offcanvas-start" data-bs-backdrop="static" tabindex="-1" id="staticBackdrop" aria-labelledby="staticBackdropLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="staticBackdropLabel">Global statistic</h5>
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
                            <c:forEach var="hero" items="${heroes}">
                                <tr>
                                    <td></td>
                                    <td>${hero.getName()}</td>
                                    <td>${hero.getCountOfEndedGames()}</td>
                                    <td>${hero.getCountOfKilledPersonages()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
