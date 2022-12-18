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
</head>
<body>
<br>
    <h2>Cryptanalyzer</h2>
<div id="tablecont">
    <div>
        <nav>
<%--            <br>--%>
            <div class="main-page"><h3><a href="${pageContext.request.contextPath}/">Main page</a></h3></div>
            <br><br>

            <div class="button_crypto"><a href="${pageContext.request.contextPath}/encrypt">Encryption</a></div>
            <br>
            <div class="button_crypto"><a href="${pageContext.request.contextPath}/decryption_with_key">Decryption with key</a></div>
            <br>
            <div class="button_crypto"><a href="${pageContext.request.contextPath}/manual_decryption_brute_force">Manual decryption brute force
                method's</a></div>
            <br>
            <div class="button_crypto"><a href="${pageContext.request.contextPath}/auto_decryption_brute_force">Auto decryption brute force method's</a>
            </div>
            <br>
            <div class="button_crypto"><a href="${pageContext.request.contextPath}/auto_decryption_statistic_analise">Auto decryption statistic
                analise method's</a></div>
            <br>
        </nav>

            <c:if test="${getForm == null && encrypt == null}">

                <div class="container">
<%--                    <br>--%>
<%--                    <br>--%>
<%--                    <img src="${pageContext.request.contextPath}/images/crypto.jpeg" class="img-fluid" alt="image">--%>
<%--                    <br><br>--%>
<%--                    <h2>Description program:</h2>--%>
                    <p>Application encodes and decodes text Caesar's cipher.</p>
                    <p>In first part of application you can to get crypto analyzer.</p>
                    <p>On page this application you should specify path to file with text,
                        which application must encode/decode.</p>
                    <p>Result of running application - will be text on page (encode or decode).</p>
                    <p>The program had five modes of using.</p>
                </div>
                <br><br>
            </c:if>

            <c:choose>
                <c:when test="${nameAction == 'Encryption'}">
                    <c:set var="description" scope="page" value="For encode text you need specify the key of encoding.
                                The program encode the text and return encoded text."/>
                </c:when>

                <c:when test="${nameAction == 'Decryption with key'}">
                    <c:set var="description" scope="page" value="The program will request from user the key for
                                decryption.
                                If you have encoded text and key of encoding, you can to get decoded text."/>
                </c:when>

                <c:when test="${nameAction == 'Manual decryption brute force method'}">
                    <c:set var="description" scope="page" value="This part of program is calculating possible keys and
                                decodes text using each key.
                                Return results of applying all keys, which depends from amount of language's
                                letters.
                                User should choose right variant of decoding yourself."/>
                </c:when>

                <c:when test="${nameAction == 'Auto decryption brute force method'}">
                    <c:set var="description" scope="page" value="Program will use all possible keys in order
                                automatically.
                                Each of decrypted text will verify of program to correct decryption,
                                using statistic most frequently words of language.
                                Program will choose right decoded text and show it on page."/>
                </c:when>

                <c:when test="${nameAction == 'Auto decryption statistic analise method'}">
                    <c:set var="description" scope="page" value="The program gets the text and is searching most frequent
                                letters of encrypted text.
                                By statistics exist the greatest frequent letters of alphabets, which are using in
                                practice.
                                The program is taking first six in order and calculate indexes of letters,
                                the key is difference between letter's of indexes.
                                Program will choose right decoded text by most frequent words of language and show
                                it on page."/>
                </c:when>
            </c:choose>

            <div class="container">
                <c:if test="${getForm != null}">
<%--                    <br><br>--%>
                    <h3>${nameAction}</h3>
                    <c:out value="${description}"/>
                    <br>
                    <br>
                    <form action="${pageContext.request.contextPath}/${getForm}" method="post" enctype="multipart/form-data">
                        <p>Upload file
                            <input type="file" name="file" accept=".txt"></p>
                        <c:if test="${needKey != null}">
                            <p><label for="key">Input key</label>
                                <input type="text" name="key" id="key" required></p>
                        </c:if>
                        <p><input type="submit" name="button" value="Encrypt"></p>
                    </form>
                </c:if>

                <c:if test="${encrypt != null}">
                    <br>
                    <p><strong>Result:</strong></p>
                    ${encrypt}
                </c:if>
            </div>
    </div>
</div>
</body>

</html>
