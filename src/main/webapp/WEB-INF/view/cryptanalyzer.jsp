<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    <%@include file="/WEB-INF/styles/styles.css" %>
</style>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cryptanalyzer page</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">--%>
</head>
<body>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"--%>
<%--        crossorigin="anonymous"></script>--%>
<header>
    <h2>Cryptanalyzer</h2>
</header>
<div id="tablecont">
    <div>
        <nav>
            <br>
            <div><a href="/">Main page</a></div>
            <br>
            <div><a href="/allEmployee">Account</a></div>

            <br><br>
            <br><br>

            <div class="button_crypto">
                <a href="/encrypt">Encryption</a>
            </div>
            <br>
            <div class="button_crypto"><a href="/decryption_with_key">Decryption with key</a></div>
            <br>
            <div class="button_crypto"><a href="/manual_decryption_brute_force">Manual decryption brute force
                method's</a></div>
            <br>
            <div class="button_crypto"><a href="/auto_decryption_brute_force">Auto decryption brute force method's</a>
            </div>
            <br>
<%--            <div class="button_crypto"><a href="/manual_decryption_statistic_analise">Manual decryption statistic--%>
<%--                analise method's</a></div>--%>
<%--            <br>--%>
            <div class="button_crypto"><a href="/auto_decryption_statistic_analise">Auto decryption statistic
                analise method's</a></div>
            <br>
        </nav>
        <main>

            <div class="main_margin">


                <%
                    String form = (String) request.getAttribute("getForm");
                    String string = (String) request.getAttribute("encrypt");
                    if (string != null) {
                        out.println("<br><p><strong>Result:</strong></p> " + string);
                    } else if (form != null) {
                        switch (form) {
                            case "encrypt_form":
                %>
                <%--                можно попробовать {/encrypt} - ({form}) вместо /encrypt и тогда количество форм можно будет сократить--%>
                <br><br>
                <h3>Encryption</h3>
                <form action="/encrypt" method="post" enctype="multipart/form-data">
                    <p>Upload file
                        <input type="file" name="file" accept=".txt"></p>
                    <p><label for="key">Input key</label>
                        <input type="text" name="key" id="key" required></p>
                    <p><input type="submit" name="button" value="Encrypt"></p>
                </form>
                <%
                        break;
                    case "decryption_with_key":
                %>
                <br><br>
                <h3>Decryption with key</h3>
                <form action="/decryption_with_key" method="post" enctype="multipart/form-data">
                    <p>Upload file
                        <input type="file" name="file" accept=".txt"></p>
                    <p><label for="key">Input key</label>
                        <input type="text" name="key" id="key2" required></p>
                    <p><input type="submit" name="button" value="Encrypt"></p>
                </form>
                <%
                        break;
                    case "manual_decryption_brute_force":
                %>
                <br><br>
                <h3>Manual decryption brute force method's</h3>
                <form action="/manual_decryption_brute_force" method="post" enctype="multipart/form-data">
                    <p>Upload file
                        <input type="file" name="file" accept=".txt"></p>
                    <p><input type="submit" name="button" value="Encrypt"></p>
                </form>
                <%
                        break;
                    case "manual_decryption_statistic_analise":
                %>
                <br><br>
                <h3>Manual decryption statistic analise method's</h3>
                <form action="/manual_decryption_statistic_analise" method="post" enctype="multipart/form-data">
                    <p>Upload file
                        <input type="file" name="file" accept=".txt"></p>
                    <p><input type="submit" name="button" value="Encrypt"></p>
                </form>
                <%
                        break;
                    case "auto_decryption_brute_force":
                %>
                <br><br>
                <h3>Auto decryption brute force method's</h3>
                <form action="/auto_decryption_brute_force" method="post" enctype="multipart/form-data">
                    <p>Upload file
                        <input type="file" name="file" accept=".txt"></p>
                    <p><input type="submit" name="button" value="Encrypt"></p>
                </form>
                <%
                        break;
                    case "auto_decryption_statistic_analise":
                %>
                <br><br>
                <h3>Auto decryption statistic analise method's</h3>
                <form action="/auto_decryption_statistic_analise" method="post" enctype="multipart/form-data">
                    <p>Upload file
                        <input type="file" name="file" accept=".txt"></p>
                    <p><input type="submit" name="button" value="Encrypt"></p>
                </form>


                <%
                    }
                } else {
                %>
                <br><br>
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkk3IAJvB7sjEEOv1vpBgDzdk6p84jzmCbyg&usqp=CAU"
                     class="img-fluid" alt="image">

                <br><br>

                <h5>Description program:</h5>
                <p>Application encodes and decodes text Caesar's cipher.</p>

                <p>In first part of application you can to get crypto analyzer.</p>

                <p>On page this application you should specify path to file with text,
                    which application must encode/decode.</p>
                <p>Result of running application - will be text on page (encode or decode).</p>
                <br><br>

                <h3>The program had five modes of using:</h3>
                <div class="accordion accordion-flush" id="accordionFlushExample">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingOne">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseOne" aria-expanded="false"
                                    aria-controls="flush-collapseOne">
                                <strong>Encryption</strong>
                            </button>
                        </h2>
                        <div id="flush-collapseOne" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingOne"
                             data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"><em>TFor encode text you need specify the key of encoding.
                                The program encode the text and return encoded text.</em>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingTwo">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseTwo" aria-expanded="false"
                                    aria-controls="flush-collapseTwo">
                                <strong>Decryption with key</strong>
                            </button>
                        </h2>
                        <div id="flush-collapseTwo" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingTwo"
                             data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"><em>The program will request from user the key for decryption.
                                If you have encoded text and key of encoding, you can to get decoded text.</em></div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingThree">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseThree" aria-expanded="false"
                                    aria-controls="flush-collapseThree">
                                <strong>Manual decryption "Brute Force" method's</strong>
                            </button>
                        </h2>
                        <div id="flush-collapseThree" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingThree"
                             data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"><em>This part of program is calculating possible keys and
                                decodes text using each key.
                                Return results of applying all keys, which depends from amount of language's letters.
                                User should choose right variant of decoding yourself.</em></div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingFour">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseFour" aria-expanded="false"
                                    aria-controls="flush-collapseFour">
                                <strong>Auto Decryption "Brute Force" method's</strong>
                            </button>
                        </h2>
                        <div id="flush-collapseFour" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingFour"
                             data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"><em>Program will use all possible keys in order automatically.
                                Each of decrypted text will verify of program to correct decryption,
                                using statistic most frequently words of language.
                                Program will choose right decoded text and show it on page.
                            </em>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingSix">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseSix" aria-expanded="false"
                                    aria-controls="flush-collapseSix">
                                <strong>Auto decryption with statistic</strong>
                            </button>
                        </h2>
                        <div id="flush-collapseSix" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingSix"
                             data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"><em>The program gets the text and is searching most frequent
                                letters of encrypted text.
                                By statistics exist the greatest frequent letters of alphabets, which are using in
                                practice.
                                The program is taking first six in order and calculate indexes of letters,
                                the key is difference between letter's of indexes.
                                Program will choose right decoded text by most frequent words of language and show it on
                                page.
                            </em></div>
                        </div>
                    </div>
                </div>

                <br><br>
                <%
                    }
                %>
            </div>
        </main>
    </div>
</div>
</body>
<footer>
    <br>
    <p>Application is using next technologies:<br>
        Java 17, Lombok, Tomcat 9, Maven, Log4j, Junit, Mockito, MySQL, <br>
        Hibernate, Docker-compose, HTML, CSS, Servlet, JSTL, Spring MVC, CI.</p>
    <br>
</footer>
</html>