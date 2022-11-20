
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html>
<head>
    <title>Start game</title>
</head>
<body>

<br>
<br>
<div class="container">
<form action="location" method="GET">
    Create nick name for hero: <input name="heroName" required/>
    <br><br>
    <input class="nice_button" type="submit" value="Walk to first location"/>
</form>
<br><br>
<form action="remove_attribute" method="GET">
    <p>Clear the session:</p>
    <input class="nice_button" type="submit" value="Clear"/>
</form>
</div>
</body>
</html>
