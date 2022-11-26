<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html>
<head>
    <title>Personage description</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
</script>
<div class="container">
    <br><br>
    <div><a href="location">Location</a></div>
    <br>
    <div class="container">
        <h2>${personageName}</h2>
    </div>
    <div class="container text-center">
        <div class="row">
            <div class="col">
                <div class="container">
                    <c:set var = "interlocutor" scope = "page" value = "${personageName}"/>
<%--                    <c:url var = "forester_page" value = "/images/Forester.jpeg"/>--%>
<%--                    <p>Your salary is : <c:out value = "${salary}"/></p>--%>
                    <c:choose>
                        <c:when test = "${interlocutor == 'Guarder'}">
                            <img src="data:image/jpeg;base64,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" class="img-fluid" alt="Guarder">
                        </c:when>
                        <c:when test = "${interlocutor == 'Forester'}">
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_J0KdxIQAT1vDfAaqYMMKC6IkN_S8zkOnww&usqp=CAU"
                                 class="img-fluid" alt="Forester">
                        </c:when>
                        <c:when test = "${interlocutor == 'Escaped prisoner'}">
                            <img src="https://avatars.mds.yandex.net/i?id=b141aa83e59dd735e50b52e31df15dae64cb56cb-6946760-images-thumbs&n=13"
                                 class="img-fluid" alt="Escaped prisoner">
                        </c:when>
                        <c:when test = "${interlocutor == 'Gnome'}">
                            <img src="https://avatars.mds.yandex.net/i?id=b022b8a2f13d8a98910c01420662ecd2-4869221-images-thumbs&n=13"
                                 class="img-fluid" alt="Gnome">
                        </c:when>
                        <c:when test = "${interlocutor == 'Tramp'}">
                            <img src="https://avatars.mds.yandex.net/i?id=991ebbc4cb86b7d2bd23fc010cdfe209-5482778-images-thumbs&n=13"
                                 class="img-fluid" alt="Tramp">
                        </c:when>
                        <c:when test = "${interlocutor == 'Hermit'}">
                            <img src="https://avatars.mds.yandex.net/i?id=29885c28c20745a08beb84ef4d408c40-5888854-images-thumbs&n=13"
                                 class="img-fluid" alt="Hermit">
                        </c:when>
                        <c:when test = "${interlocutor == 'Cheater'}">
                            <img src="https://avatars.mds.yandex.net/i?id=2b880afd424803dc6c3cb487c895eb8c8ca54a9b-5232923-images-thumbs&n=13"
                                 class="img-fluid" alt="Cheater">
                        </c:when>
<%--                        <c:otherwise>--%>
<%--                        </c:otherwise>--%>
                    </c:choose>
                </div>
            </div>

            <div class="col">
                <div class="container">
                    <br><br>
                    <h6>${issue.getText()}</h6>
                    <c:forEach var="reply" items="${issue.getReplies()}">
                        <div>
                            <form action="conversation" method="POST">
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
