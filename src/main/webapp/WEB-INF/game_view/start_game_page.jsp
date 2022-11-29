<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>
<html>
<head>
    <title>Start game</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body class="background">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<div class="container text-center border">
    <br>
    <h5>This is browser game. <br>
        Target of game - to implement quests and quit from game on last location.</h5>
    <br>
</div>
<div class="container text-center border">
    <div class="row border ">
        <div class="col border">
            <form action="location" method="GET">
                Create nick name for hero: <input name="heroName" required/>
                <br><br>
                <input class="nice_button" type="submit" value="Begin game"/>
            </form>
            <br><br>
            <form action="remove_attribute_of_session" method="GET">
                <p>Clear the session:</p>
                <input class="nice_button" type="submit" value="Clear"/>
            </form>
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
                            Strength shows power of kick during fighting.
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
                            Opponent also can kick hero to head, body or legs. and to close head,
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
