
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
  <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html>
<head>
    <title>Defeat</title>
</head>
<body class="background">
<h3>The player is defeated</h3>

<br>
<br>
<form action="${pageContext.request.contextPath}/start_game" method="get">
    <button class="btn btn-default btn-sm my_svg box" title="${armor.name}"
            type="submit"
            value="Submit">
        <img src="${pageContext.request.contextPath}/images/amod.jpeg"
             class="box1"
             alt="Box" title="Return to start game">
    </button>
</form>
</body>
</html>
