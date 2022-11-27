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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<header>
    <h2>Hi. This is "Hello page" for project by practice technologies.</h2>
    <h5>Here you can see implementation of following between pages.</h5>
    <br>
</header>

<div id="tablecont">

    <div>
        <nav>
            <br>
            <div><a href="/cryptanalyzer">Cryptanalyzer</a></div>
            <br>
            <div><a href="/allEmployee">all-employees</a></div>
            <br>
            <div><a href="module">Solution for module 3</a></div>
            <br>
            <div><a href="start_game">Game</a></div>
            <br>
        </nav>

        <main>
            <div class="main_margin">
                <br><br>
                <div>
                    <p>
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZg-gsHwMqLsNMbDUB5lkrD_y423zBRyfuKkcqILaRHXW_-BtZwLxvsNkFg-dVNbvHkYY&usqp=CAU"
                             class="img-fluid" alt="cryptography">
                    </p>
                    <p>
                        <img src="resources/image.jpg" class="img-fluid" alt="cryptography">
                    </p>
                </div>

                <br><br>

                <div class="card" style="width: 18rem;">
                    <img src="data:image/jpeg;base64,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"
                         class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                            the card's content.</p>
                        <a href="cryptanalyzer.jsp" class="btn btn-primary">Use criptanalyzer</a>
                    </div>
                </div>

                <form>
                    <div class="shadow p-3 mb-5 bg-body rounded">
                        <p><input type="button" value="Present yourself"
                        <%--              onclick="window.location = '/logic?submit="--%>
                        ></p>
                    </div>

                    <div class="mb-3">
                        <label for="formFileSm" class="form-label">Small file input example</label>
                        <input class="form-control form-control-sm" id="formFileSm" type="file">
                    </div>
                </form>

                <br><br>

                <br><br>
                <p>Determinations:</p>
                <dl>
                    <dt>Encryption</dt>
                    <dd>Text from first indicated file is encoding to second file.</dd>
                    <dt></dt>
                    <dd>Decryption with key</dd>
                    <dt>The program will request the key for decryption.</dt>
                    <dd>Manual decryption "Brute Force" method's</dd>
                    <dt>Decryption will make to indicated directory.
                        Amount of files depends from amount of language's letters (possible keys).
                    </dt>
                    <dd>Auto Decryption "Brute Force" method's</dd>
                    <dt>Program will use all possible keys in order.
                        Each of decrypted text will automatically verify to correct decryption,
                        using most frequently words of language. Decryption will make to indicate file.
                    </dt>
                    <dd>Manual decryption with statistic</dd>
                    <dt>The program gets most frequent letter of encrypted text and took--%>
                        it for six the greatest frequent letters of alphabets in order.
                        The key is difference between letter's indexes. Decryption will make to
                        indicate directory into different files.
                    </dt>
                </dl>


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
                            <div class="accordion-body"><em>Text from first indicated file is encoding to second
                                file.</em>
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
                            <div class="accordion-body"><em>The program will request the key for decryption.</em></div>
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
                            <div class="accordion-body"><em>Decryption will make to indicated directory.
                                Amount of files depends from amount of language's letters (possible keys).</em></div>
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
                            <div class="accordion-body"><em>Program will use all possible keys in order.
                                Each of decrypted text will automatically verify to correct decryption,
                                using most frequently words of language. Decryption will make to indicate file.</em>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingFive">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseFive" aria-expanded="false"
                                    aria-controls="flush-collapseFive">
                                <strong>Manual decryption with statistic</strong>
                            </button>
                        </h2>
                        <div id="flush-collapseFive" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingFive"
                             data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"><em>The program gets most frequent letter of encrypted text and
                                took
                                it for
                                six the
                                greatest frequent letters of alphabets in order. The key is difference between letter's
                                indexes.
                                Decryption will make to indicate directory into different files.</em></div>
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
                            <div class="accordion-body"><em>The program works like previous function,
                                but decryption will make to indicate file after automatically verify to correct
                                decryption,
                                using most frequently words of language.</em></div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>
