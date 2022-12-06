<style>
    <%@include file="/WEB-INF/styles/styles.css" %>
</style>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Start page</title>
</head>

<body>
<header>
    <h2>Web-application project</h2>
    <br>
</header>

<div id="tablecont">

    <div>
        <nav>
            <br>
            <div><a href="${pageContext.request.contextPath}/cryptanalyzer">Cryptanalyzer</a></div>
<%--            <div><a href="/allEmployee">all-employees</a></div>--%>
            <br>
            <div><a href="${pageContext.request.contextPath}/module">Solution for module 3</a></div>
            <br>
            <div><a href="${pageContext.request.contextPath}/start_game">Game</a></div>
            <br>
        </nav>

        <main>
            <div class="container">

                <h3>This project consists two parts:</h3>
                <p>1. Crypto analyzer;</p>
                <p>2. Mini game.</p>

                <h4>Application is using next technologies:</h4>
                <p>Java 17, Lombok, Tomcat 9, Maven, Log4j, Junit, Mockito, MySQL, Hibernate,
                    Docker-compose, HTML, CSS, Servlet, JSTL, CI.</p>

                <h4>Launch application:</h4>
                <p><a href="http://myapp-s.com:8080">http://myapp-s.com</a></p>

                <p>Github: <a href="https://github.com/SergeyIvanov1/web_application/tree/dev">https://github.com/SergeyIvanov1/web_application/tree/dev</a></p>
                <p>Path to war file: web_application\target\ROOT.war</p>

                <h4>Also you can use next commands:</h4>
                <ul>
                    <li> Clone repository https://github.com/SergeyIvanov1/web_application.git</li>
                    <li> Launch with Docker - (in working directory of terminal) use:
                        docker-compose up -d.
                    </li>
                </ul>
            </div>
        </main>
    </div>
</div>
</body>
<footer>
    <br>
    <p>Footer</p>
    <br>
</footer>
</html>
