<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html>
<head>
    <title>Defeat</title>
</head>
<body class="background">

<br>
<br>
<div class="container_defeat">
    <div id="defeat1">
    </div>
    <div id="defeat2">
        <form action="${pageContext.request.contextPath}/reset_game" method="get">
            <h3>The player is defeated</h3>
            <br>
            <br>
            <button class="btn btn-default btn-sm my_svg box" title="${armor.name}"
                    type="submit"
                    value="Submit">
                <img src="${pageContext.request.contextPath}/images/defeat.jpeg"
                     class="defeat"
                     alt="Box" title="Return to start game">
            </button>
        </form>
    </div>
    <div id="defeat3">
    </div>
</body>
</html>
