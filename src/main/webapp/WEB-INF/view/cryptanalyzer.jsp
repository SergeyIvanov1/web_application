<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<style>
    <%@include file="/WEB-INF/styles/styles.css" %>
</style>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cryptanalyzer page</title>

</head>
<body>
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
            <div class="button_crypto"><a href="/manual_decryption_statistic_analise">Manual decryption statistic
                analise method's</a></div>
            <br>
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

                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkk3IAJvB7sjEEOv1vpBgDzdk6p84jzmCbyg&usqp=CAU"
                     class="img-fluid" alt="image">

                <br><br>

                <p>Description program:</p>
                <p>The program encodes and decodes text Caesar's cipher.</p>
                <p>At the beginning program's work user must choose the language.</p>
                <p>User indicate two path for each mode program's working (where from take text and where to save).</p>

                <br><br>

                <h3>The program had six modes of using.<br>Description:</h3>



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
    <p>Here is footer</p>
    <br>
</footer>
</html>