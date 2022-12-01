<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html>
<head>
    <title>Start game</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body class="background">
<%--<script src="${pageContext.request.contextPath}/js/bootstrap.js"--%>
<%--        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"--%>
<%--        crossorigin="anonymous"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<div class="container text-center border">
    <div class="row border ">
        <div class="col border">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Main page</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Actions
                                </a>
                                <ul class="dropdown-menu dropdown-menu-dark">
<%--                                    <li><a class="dropdown-item" href="#">Action</a></li>--%>
<%--                                    <li><a class="dropdown-item" href="#">Another action</a></li>--%>
                                    <li><a class="dropdown-item" href="remove_attribute_of_session">Sign out</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

        </div>
        <div class="col border">

        </div>
        <div class="col border">
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="outside">
                    Sign in
                </button>
                <form action="${pageContext.request.contextPath}/location" class="dropdown-menu p-4">
                    <div class="mb-3">
                        <label for="exampleDropdownFormName2" class="form-label">Nick name</label>
                        <input type="text" class="form-control" id="exampleDropdownFormName2" placeholder="Your nick" name="heroName" required>
                    </div>
<%--                    <div class="mb-3">--%>
<%--                        <label for="exampleDropdownFormEmail2" class="form-label">Email address</label>--%>
<%--                        <input type="email" class="form-control" id="exampleDropdownFormEmail2" placeholder="email@example.com">--%>
<%--                    </div>--%>
<%--                    <div class="mb-3">--%>
<%--                        <label for="exampleDropdownFormPassword2" class="form-label">Password</label>--%>
<%--                        <input type="password" class="form-control" id="exampleDropdownFormPassword2" placeholder="Password">--%>
<%--                    </div>--%>
                    <div class="mb-3">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="dropdownCheck2">
                            <label class="form-check-label" for="dropdownCheck2">
                                Remember me
                            </label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Continue</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container text-center border">
    <br>
    <h5>This is browser game. <br>
        Target of game - to implement quests and quit from game on last location.
        Please, register, for begin game.</h5>
    <br>
</div>
<div class="container text-center border">
    <div class="row border ">
        <div class="col border">
            <img src="data:image/jpeg;base64,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" width="100%" height="100%">
        </div>

        <div class="col border">
            <div class="accordion" id="accordionPanelsStayOpenExample">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingOne">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseOne">
                            Hero
                        </button>
                    </h2>
                    <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse"
                         aria-labelledby="panelsStayOpen-headingOne">
                        <div class="accordion-body">
                            Hero has health, strength and dexterity.
                            Health determines amount of life.
                            Strength shows power of kick during fight.
                            Dexterity determines chance do not get kick in fight.

                            Hero has inventory there he storage things, which he find.
                        </div>
                    </div>
                </div>

                <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingTwo">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseTwo">
                            Personage
                        </button>
                    </h2>
                    <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse"
                         aria-labelledby="panelsStayOpen-headingTwo">
                        <div class="accordion-body">
                            Hero can speak with any personage.
                            Personage can give quest to hero. (To find anything or to bring).
                            Also, personage can begin to fight with hero if he do not like conversation.
                        </div>
                    </div>
                </div>

                <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingThree">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseThree">
                            Things
                        </button>
                    </h2>
                    <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse"
                         aria-labelledby="panelsStayOpen-headingThree">
                        <div class="accordion-body">
                            In every location is box, inside can be usefull things:
                            armor, potion, helpers, weapons.

                            Weapon is increasing strength.
                            Armor is increase dexterity.
                            Hero can to use potions during figthing and increase health.
                            Helpers can to use during executing quests.
                        </div>
                    </div>
                </div>

                <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingFour">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseFour" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseFour">
                            Fight
                        </button>
                    </h2>
                    <div id="panelsStayOpen-collapseFour" class="accordion-collapse collapse"
                         aria-labelledby="panelsStayOpen-headingFour">
                        <div class="accordion-body">
                            While is fighting hero can to kick opponent to head, body or legs.
                            Also he can to close head, body or legs himself.
                            Opponent also can kick hero to head, body or legs and to close head,
                            body or legs himself.
                            If kick was to closed part, health is not decrease.
                            Also is chance, what hero or opponent can not to get kick (dexterity).
                            If one part of body is getting kick, decreasing N of health,
                            in dependence from strength.
                            If hero is dead, the game begin from start.
                            Hero can begin the game from start in any moment of game.
                        </div>
                    </div>
                </div>

                <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingFive">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseFive" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseFive">
                            Statistics
                        </button>
                    </h2>
                    <div id="panelsStayOpen-collapseFive" class="accordion-collapse collapse"
                         aria-labelledby="panelsStayOpen-headingFive">
                        <div class="accordion-body">
                            <strong>Global statistic shows:</strong><br>
                            - count of gamers and their names;<br>
                            - name hero with maximal of count ended games;<br>
                            - hero, has max count killed personages.<br>
                            <br><br>
                            <strong>Individual statistic shows:</strong><br>
                            - when started current game;<br>
                            - how many kills of personages is make hero;<br>
                            - count ended games;<br>
                            - common of count killed personages during all games this hero.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
