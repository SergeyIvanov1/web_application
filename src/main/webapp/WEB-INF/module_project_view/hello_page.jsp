<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">--%>
    <%--    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

<div class="container">
    <div class="clearfix">
        <img src="${pageContext.request.contextPath}/images/ship.jpeg" class="col-md-6 float-md-end mb-3 ms-md-3" alt="space_ship">

        <h1>Prologue</h1>
        <p>You are standing at the space port and you are reading up of your sheep board. Do you dreamed about this?</p>
        <p>Became of captain galactic sheep, which make honors ander of your </p>
        <p>You are standing at the spaceport and you are ready up of your shipboard. Do you dreamed about this?</p>
        <p>To became of captain galactic ship, which make exploits under of your commands. Let's go!
            <br><br>
        <h1>Getting to know the crew:</h1>
        <p>When you boarded, you were greeted by a girl with a black stick in her hands:</p>
        <p>- Hello commander, I am Zinaida - your assistant.</p>
        <p>There's your navigator, Sergeant Popov, drinking coffee in the corner,</p>
        <p>and your flight mechanic is sleeping under the wheel. And how to contact you?</p>
        <br><br>
    </div>


    <form action="questions" method="GET">
        Introduce yourself: <input name="visitorName" required/>
        <br><br>
        <input class="nice_button" type="submit" value="Introduce"/>
    </form>
    <br><br>
    <form action="remove_attribute" method="GET">
        <p>Remove attribute "visitor" from session:</p>
        <input class="nice_button" type="submit" value="Remove"/>
    </form>
</div>


</body>
</html>
