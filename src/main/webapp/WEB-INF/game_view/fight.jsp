<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="/WEB-INF/styles/module_project_view_styles.css" %>
</style>

<html>
<head>
    <title>Fight</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>

<body class="background">
<script src="${pageContext.request.contextPath}/js/bootstrap.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<jsp:include page="parts/game_header.jsp"/>

<div class="container text-center border">
    <br>
    <h1>Fighting</h1>
    <form action="${pageContext.request.contextPath}/fight" method="POST">
        <div class="row border">
            <div class="col border">
                <br>
                <h2>${heroName}</h2>
                <p>Health: ${heroCurrentHealth}/${heroHealth}</p>
                <div class="progress">
                    <div class="progress-bar" role="progressbar" aria-label="Example with label"
                         style="width: ${heroCurrentPercentOfHealth}%;" aria-valuenow="${heroCurrentHealth}"
                         aria-valuemin="0" aria-valuemax="${heroHealth}">${heroCurrentPercentOfHealth}%
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col">
                        <p>Strength: ${heroStrength}</p>
                        <p>Dexterity: ${heroDexterity}</p>
                        <div class="fighting-history">

                        </div>
                        <%--                        <c:set var="potions_is_present" scope="page" value="${!heroPotions.isEmpty()}"/>--%>
                        <%--                        <c:if test="${potions_is_present}">--%>
<%--                        <h6>Potions:</h6>--%>
<%--                        <button type="button" class="btn btn-default btn-sm"--%>
<%--                                onclick="window.location.href = '/addNewEmployee'" title="water">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"--%>
<%--                                 class="bi bi-droplet"--%>
<%--                                 viewBox="0 0 16 16">--%>
<%--                                <path fill-rule="evenodd"--%>
<%--                                      d="M7.21.8C7.69.295 8 0 8 0c.109.363.234.708.371 1.038.812 1.946 2.073 3.35 3.197 4.6C12.878 7.096 14 8.345 14 10a6 6 0 0 1-12 0C2 6.668 5.58 2.517 7.21.8zm.413 1.021A31.25 31.25 0 0 0 5.794 3.99c-.726.95-1.436 2.008-1.96 3.07C3.304 8.133 3 9.138 3 10a5 5 0 0 0 10 0c0-1.201-.796-2.157-2.181-3.7l-.03-.032C9.75 5.11 8.5 3.72 7.623 1.82z"/>--%>
<%--                                <path fill-rule="evenodd"--%>
<%--                                      d="M4.553 7.776c.82-1.641 1.717-2.753 2.093-3.13l.708.708c-.29.29-1.128 1.311-1.907 2.87l-.894-.448z"/>--%>
<%--                            </svg>--%>
<%--                        </button>--%>
<%--                        <button type="button" class="btn btn-default btn-sm" title="cocktail">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"--%>
<%--                                 class="bi bi-cup-straw"--%>
<%--                                 viewBox="0 0 16 16">--%>
<%--                                <path d="M13.902.334a.5.5 0 0 1-.28.65l-2.254.902-.4 1.927c.376.095.715.215.972.367.228.135.56.396.56.82 0 .046-.004.09-.011.132l-.962 9.068a1.28 1.28 0 0 1-.524.93c-.488.34-1.494.87-3.01.87-1.516 0-2.522-.53-3.01-.87a1.28 1.28 0 0 1-.524-.93L3.51 5.132A.78.78 0 0 1 3.5 5c0-.424.332-.685.56-.82.262-.154.607-.276.99-.372C5.824 3.614 6.867 3.5 8 3.5c.712 0 1.389.045 1.985.127l.464-2.215a.5.5 0 0 1 .303-.356l2.5-1a.5.5 0 0 1 .65.278zM9.768 4.607A13.991 13.991 0 0 0 8 4.5c-1.076 0-2.033.11-2.707.278A3.284 3.284 0 0 0 4.645 5c.146.073.362.15.648.222C5.967 5.39 6.924 5.5 8 5.5c.571 0 1.109-.03 1.588-.085l.18-.808zm.292 1.756C9.445 6.45 8.742 6.5 8 6.5c-1.133 0-2.176-.114-2.95-.308a5.514 5.514 0 0 1-.435-.127l.838 8.03c.013.121.06.186.102.215.357.249 1.168.69 2.438.69 1.27 0 2.081-.441 2.438-.69.042-.029.09-.094.102-.215l.852-8.03a5.517 5.517 0 0 1-.435.127 8.88 8.88 0 0 1-.89.17zM4.467 4.884s.003.002.005.006l-.005-.006zm7.066 0-.005.006c.002-.004.005-.006.005-.006zM11.354 5a3.174 3.174 0 0 0-.604-.21l-.099.445.055-.013c.286-.072.502-.149.648-.222z"/>--%>
<%--                            </svg>--%>
<%--                        </button>--%>

<%--                        <button type="button" class="btn btn-default btn-sm" title="coffee">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"--%>
<%--                                 class="bi bi-cup-hot"--%>
<%--                                 viewBox="0 0 16 16">--%>
<%--                                <path fill-rule="evenodd"--%>
<%--                                      d="M.5 6a.5.5 0 0 0-.488.608l1.652 7.434A2.5 2.5 0 0 0 4.104 16h5.792a2.5 2.5 0 0 0 2.44-1.958l.131-.59a3 3 0 0 0 1.3-5.854l.221-.99A.5.5 0 0 0 13.5 6H.5ZM13 12.5a2.01 2.01 0 0 1-.316-.025l.867-3.898A2.001 2.001 0 0 1 13 12.5ZM2.64 13.825 1.123 7h11.754l-1.517 6.825A1.5 1.5 0 0 1 9.896 15H4.104a1.5 1.5 0 0 1-1.464-1.175Z"/>--%>
<%--                                <path d="m4.4.8-.003.004-.014.019a4.167 4.167 0 0 0-.204.31 2.327 2.327 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.593.593 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3.31 3.31 0 0 1-.202.388 5.444 5.444 0 0 1-.253.382l-.018.025-.005.008-.002.002A.5.5 0 0 1 3.6 4.2l.003-.004.014-.019a4.149 4.149 0 0 0 .204-.31 2.06 2.06 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.593.593 0 0 0-.09-.252A4.334 4.334 0 0 0 3.6 2.8l-.01-.012a5.099 5.099 0 0 1-.37-.543A1.53 1.53 0 0 1 3 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a5.446 5.446 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 4.4.8Zm3 0-.003.004-.014.019a4.167 4.167 0 0 0-.204.31 2.327 2.327 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.593.593 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3.31 3.31 0 0 1-.202.388 5.444 5.444 0 0 1-.253.382l-.018.025-.005.008-.002.002A.5.5 0 0 1 6.6 4.2l.003-.004.014-.019a4.149 4.149 0 0 0 .204-.31 2.06 2.06 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.593.593 0 0 0-.09-.252A4.334 4.334 0 0 0 6.6 2.8l-.01-.012a5.099 5.099 0 0 1-.37-.543A1.53 1.53 0 0 1 6 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a5.446 5.446 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 7.4.8Zm3 0-.003.004-.014.019a4.077 4.077 0 0 0-.204.31 2.337 2.337 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.593.593 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3.198 3.198 0 0 1-.202.388 5.385 5.385 0 0 1-.252.382l-.019.025-.005.008-.002.002A.5.5 0 0 1 9.6 4.2l.003-.004.014-.019a4.149 4.149 0 0 0 .204-.31 2.06 2.06 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.593.593 0 0 0-.09-.252A4.334 4.334 0 0 0 9.6 2.8l-.01-.012a5.099 5.099 0 0 1-.37-.543A1.53 1.53 0 0 1 9 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a5.446 5.446 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 10.4.8Z"/>--%>
<%--                            </svg>--%>
<%--                        </button>--%>
<%--                        &lt;%&ndash;                        </c:if>&ndash;%&gt;--%>

<%--                        &lt;%&ndash;                    <c:set var="helpers_is_present" scope="page" value="${!helpers.isEmpty()}"/>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                    <c:if test="${helpers_is_present}">&ndash;%&gt;--%>
<%--                        <br>--%>
<%--                        <br>--%>
<%--                        <h6>Helpers:</h6>--%>
<%--                        <button type="button" class="btn btn-default btn-sm"--%>
<%--                                onclick="window.location.href = '${pageContext.request.contextPath}/addNewEmployee'"--%>
<%--                                title="key">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"--%>
<%--                                 class="bi bi-key" viewBox="0 0 16 16">--%>
<%--                                <path d="M0 8a4 4 0 0 1 7.465-2H14a.5.5 0 0 1 .354.146l1.5 1.5a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0L13 9.207l-.646.647a.5.5 0 0 1-.708 0L11 9.207l-.646.647a.5.5 0 0 1-.708 0L9 9.207l-.646.647A.5.5 0 0 1 8 10h-.535A4 4 0 0 1 0 8zm4-3a3 3 0 1 0 2.712 4.285A.5.5 0 0 1 7.163 9h.63l.853-.854a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.793-.793-1-1h-6.63a.5.5 0 0 1-.451-.285A3 3 0 0 0 4 5z"/>--%>
<%--                                <path d="M4 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>--%>
<%--                            </svg>--%>
<%--                        </button>--%>
<%--                        <button type="button" class="btn btn-default btn-sm"--%>
<%--                                onclick="window.location.href = '${pageContext.request.contextPath}/addNewEmployee'"--%>
<%--                                title="present">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"--%>
<%--                                 class="bi bi-gift" viewBox="0 0 16 16">--%>
<%--                                <path d="M3 2.5a2.5 2.5 0 0 1 5 0 2.5 2.5 0 0 1 5 0v.006c0 .07 0 .27-.038.494H15a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a1.5 1.5 0 0 1-1.5 1.5h-11A1.5 1.5 0 0 1 1 14.5V7a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h2.038A2.968 2.968 0 0 1 3 2.506V2.5zm1.068.5H7v-.5a1.5 1.5 0 1 0-3 0c0 .085.002.274.045.43a.522.522 0 0 0 .023.07zM9 3h2.932a.56.56 0 0 0 .023-.07c.043-.156.045-.345.045-.43a1.5 1.5 0 0 0-3 0V3zM1 4v2h6V4H1zm8 0v2h6V4H9zm5 3H9v8h4.5a.5.5 0 0 0 .5-.5V7zm-7 8V7H2v7.5a.5.5 0 0 0 .5.5H7z"/>--%>
<%--                            </svg>--%>
<%--                        </button>--%>
<%--                        <button type="button" class="btn btn-default btn-sm"--%>
<%--                                onclick="window.location.href = '${pageContext.request.contextPath}/addNewEmployee'"--%>
<%--                                title="cookie">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"--%>
<%--                                 class="bi bi-flower1" viewBox="0 0 16 16">--%>
<%--                                <path d="M6.174 1.184a2 2 0 0 1 3.652 0A2 2 0 0 1 12.99 3.01a2 2 0 0 1 1.826 3.164 2 2 0 0 1 0 3.652 2 2 0 0 1-1.826 3.164 2 2 0 0 1-3.164 1.826 2 2 0 0 1-3.652 0A2 2 0 0 1 3.01 12.99a2 2 0 0 1-1.826-3.164 2 2 0 0 1 0-3.652A2 2 0 0 1 3.01 3.01a2 2 0 0 1 3.164-1.826zM8 1a1 1 0 0 0-.998 1.03l.01.091c.012.077.029.176.054.296.049.241.122.542.213.887.182.688.428 1.513.676 2.314L8 5.762l.045-.144c.248-.8.494-1.626.676-2.314.091-.345.164-.646.213-.887a4.997 4.997 0 0 0 .064-.386L9 2a1 1 0 0 0-1-1zM2 9l.03-.002.091-.01a4.99 4.99 0 0 0 .296-.054c.241-.049.542-.122.887-.213a60.59 60.59 0 0 0 2.314-.676L5.762 8l-.144-.045a60.59 60.59 0 0 0-2.314-.676 16.705 16.705 0 0 0-.887-.213 4.99 4.99 0 0 0-.386-.064L2 7a1 1 0 1 0 0 2zm7 5-.002-.03a5.005 5.005 0 0 0-.064-.386 16.398 16.398 0 0 0-.213-.888 60.582 60.582 0 0 0-.676-2.314L8 10.238l-.045.144c-.248.8-.494 1.626-.676 2.314-.091.345-.164.646-.213.887a4.996 4.996 0 0 0-.064.386L7 14a1 1 0 1 0 2 0zm-5.696-2.134.025-.017a5.001 5.001 0 0 0 .303-.248c.184-.164.408-.377.661-.629A60.614 60.614 0 0 0 5.96 9.23l.103-.111-.147.033a60.88 60.88 0 0 0-2.343.572c-.344.093-.64.18-.874.258a5.063 5.063 0 0 0-.367.138l-.027.014a1 1 0 1 0 1 1.732zM4.5 14.062a1 1 0 0 0 1.366-.366l.014-.027c.01-.02.021-.048.036-.084a5.09 5.09 0 0 0 .102-.283c.078-.233.165-.53.258-.874a60.6 60.6 0 0 0 .572-2.343l.033-.147-.11.102a60.848 60.848 0 0 0-1.743 1.667 17.07 17.07 0 0 0-.629.66 5.06 5.06 0 0 0-.248.304l-.017.025a1 1 0 0 0 .366 1.366zm9.196-8.196a1 1 0 0 0-1-1.732l-.025.017a4.951 4.951 0 0 0-.303.248 16.69 16.69 0 0 0-.661.629A60.72 60.72 0 0 0 10.04 6.77l-.102.111.147-.033a60.6 60.6 0 0 0 2.342-.572c.345-.093.642-.18.875-.258a4.993 4.993 0 0 0 .367-.138.53.53 0 0 0 .027-.014zM11.5 1.938a1 1 0 0 0-1.366.366l-.014.027c-.01.02-.021.048-.036.084a5.09 5.09 0 0 0-.102.283c-.078.233-.165.53-.258.875a60.62 60.62 0 0 0-.572 2.342l-.033.147.11-.102a60.848 60.848 0 0 0 1.743-1.667c.252-.253.465-.477.629-.66a5.001 5.001 0 0 0 .248-.304l.017-.025a1 1 0 0 0-.366-1.366zM14 9a1 1 0 0 0 0-2l-.03.002a4.996 4.996 0 0 0-.386.064c-.242.049-.543.122-.888.213-.688.182-1.513.428-2.314.676L10.238 8l.144.045c.8.248 1.626.494 2.314.676.345.091.646.164.887.213a4.996 4.996 0 0 0 .386.064L14 9zM1.938 4.5a1 1 0 0 0 .393 1.38l.084.035c.072.03.166.064.283.103.233.078.53.165.874.258a60.88 60.88 0 0 0 2.343.572l.147.033-.103-.111a60.584 60.584 0 0 0-1.666-1.742 16.705 16.705 0 0 0-.66-.629 4.996 4.996 0 0 0-.304-.248l-.025-.017a1 1 0 0 0-1.366.366zm2.196-1.196.017.025a4.996 4.996 0 0 0 .248.303c.164.184.377.408.629.661A60.597 60.597 0 0 0 6.77 5.96l.111.102-.033-.147a60.602 60.602 0 0 0-.572-2.342c-.093-.345-.18-.642-.258-.875a5.006 5.006 0 0 0-.138-.367l-.014-.027a1 1 0 1 0-1.732 1zm9.928 8.196a1 1 0 0 0-.366-1.366l-.027-.014a5 5 0 0 0-.367-.138c-.233-.078-.53-.165-.875-.258a60.619 60.619 0 0 0-2.342-.572l-.147-.033.102.111a60.73 60.73 0 0 0 1.667 1.742c.253.252.477.465.66.629a4.946 4.946 0 0 0 .304.248l.025.017a1 1 0 0 0 1.366-.366zm-3.928 2.196a1 1 0 0 0 1.732-1l-.017-.025a5.065 5.065 0 0 0-.248-.303 16.705 16.705 0 0 0-.629-.661A60.462 60.462 0 0 0 9.23 10.04l-.111-.102.033.147a60.6 60.6 0 0 0 .572 2.342c.093.345.18.642.258.875a4.985 4.985 0 0 0 .138.367.575.575 0 0 0 .014.027zM8 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"/>--%>
<%--                            </svg>--%>
<%--                        </button>--%>

                        <%--                    </c:if>--%>

                    </div>
                    <div class="col">
                        <p>Block:</p>
                        <select name="block" class="form-select form-select-sm" aria-label=".form-select-sm example">
                            <option selected>Select</option>
                            <option value="head">Head</option>
                            <option value="body">Body</option>
                            <option value="legs">Legs</option>
                        </select>
                        <br>
                        <h6>Used armor:</h6>
                        <div class="fight-tools">

                        </div>
                        <c:if test="${usingArmor1 != null}">
                            <form action="${pageContext.request.contextPath}/things" method="post">
                                <input type="hidden" name="nextLocationName"
                                       value="${currentLocation.getName()}">
                                <input type="hidden" name="usingArmor2" value="${usingArmor2}">
                                <button class="btn btn-default btn-sm my_svg box" title="${usingArmor2}"
                                        type="submit"
                                        value="Submit">
                                    <img src="${pageContext.request.contextPath}/images/svg/${usingArmor1}.svg"
                                         class="box1"
                                         alt="Box">
                                </button>
                            </form>
                        </c:if>

                        <c:if test="${usingArmor2 != null}">
                            <form action="${pageContext.request.contextPath}/things" method="post">
                                <input type="hidden" name="nextLocationName"
                                       value="${currentLocation.getName()}">
                                <input type="hidden" name="usingArmor2" value="${usingArmor2}">
                                <button class="btn btn-default btn-sm my_svg box" title="${usingArmor2}"
                                        type="submit"
                                        value="Submit">
                                    <img src="${pageContext.request.contextPath}/images/svg/${usingArmor2}.svg"
                                         class="box1"
                                         alt="Box">
                                </button>
                            </form>
                        </c:if>
                    </div>
                    <div class="col">
                        <p> Attack:</p>
                        <select name="attack" class="form-select form-select-sm" aria-label=".form-select-sm example">
                            <option selected>Select</option>
                            <option value="head">Head</option>
                            <option value="body">Body</option>
                            <option value="legs">Legs</option>
                        </select>
                        <br>
                        <h6>Used weapon:</h6>
                        <div class="fight-tools">

                        </div>
<%--                        <button type="button" class="btn btn-default btn-sm"--%>
<%--                                onclick="window.location.href = '${pageContext.request.contextPath}/addNewEmployee'"--%>
<%--                                title="stick">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"--%>
<%--                                 class="bi bi-slash-lg" viewBox="0 0 16 16">--%>
<%--                                <path fill-rule="evenodd"--%>
<%--                                      d="M13.854 2.146a.5.5 0 0 1 0 .708l-11 11a.5.5 0 0 1-.708-.708l11-11a.5.5 0 0 1 .708 0Z"/>--%>
<%--                            </svg>--%>
<%--                        </button>--%>
<%--                        <button type="button" class="btn btn-default btn-sm"--%>
<%--                                onclick="window.location.href = '${pageContext.request.contextPath}/addNewEmployee'"--%>
<%--                                title="wrench">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"--%>
<%--                                 class="bi bi-wrench" viewBox="0 0 16 16">--%>
<%--                                <path d="M.102 2.223A3.004 3.004 0 0 0 3.78 5.897l6.341 6.252A3.003 3.003 0 0 0 13 16a3 3 0 1 0-.851-5.878L5.897 3.781A3.004 3.004 0 0 0 2.223.1l2.141 2.142L4 4l-1.757.364L.102 2.223zm13.37 9.019.528.026.287.445.445.287.026.529L15 13l-.242.471-.026.529-.445.287-.287.445-.529.026L13 15l-.471-.242-.529-.026-.287-.445-.445-.287-.026-.529L11 13l.242-.471.026-.529.445-.287.287-.445.529-.026L13 11l.471.242z"/>--%>
<%--                            </svg>--%>
<%--                        </button>--%>
<%--                        <button type="button" class="btn btn-default btn-sm"--%>
<%--                                onclick="window.location.href = '${pageContext.request.contextPath}/addNewEmployee'"--%>
<%--                                title="stun gun">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"--%>
<%--                                 class="bi bi-lightning" viewBox="0 0 16 16">--%>
<%--                                <path d="M5.52.359A.5.5 0 0 1 6 0h4a.5.5 0 0 1 .474.658L8.694 6H12.5a.5.5 0 0 1 .395.807l-7 9a.5.5 0 0 1-.873-.454L6.823 9.5H3.5a.5.5 0 0 1-.48-.641l2.5-8.5zM6.374 1 4.168 8.5H7.5a.5.5 0 0 1 .478.647L6.78 13.04 11.478 7H8a.5.5 0 0 1-.474-.658L9.306 1H6.374z"/>--%>
<%--                            </svg>--%>
<%--                        </button>--%>
                    </div>
                </div>
            </div>

            <div class="col border">
                <br>
                <h2>${personageName}</h2>
                <%--                    <c:forEach var="reply" items="${issue.getReplies()}">--%>
                <p>Health: ${personageCurrentHealth}/${personageHealth}</p>
                <div class="progress">
                    <div class="progress-bar" role="progressbar" aria-label="Example with label"
                         style="width: ${personageCurrentPercentOfHealth}%;" aria-valuenow="${personageCurrentHealth}"
                         aria-valuemin="0" aria-valuemax="${personageHealth}">${personageCurrentPercentOfHealth}%
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col">
                        <c:set var="interlocutor" scope="page" value="${personageName}"/>
                        <c:choose>
                            <c:when test="${interlocutor == 'Guarder'}">
                                <img src="${pageContext.request.contextPath}/images/guarder.jpeg" class="img-fluid"
                                     alt="Tramp">
                            </c:when>
                            <c:when test="${interlocutor == 'Forester'}">
                                <img src="${pageContext.request.contextPath}/images/forester.jpeg" class="img-fluid"
                                     alt="Tramp">
                            </c:when>
                            <c:when test="${interlocutor == 'Prisoner'}">
                                <img src="${pageContext.request.contextPath}/images/Prisoner.jpeg"
                                     class="img-fluid" alt="Tramp">
                            </c:when>
                            <c:when test="${interlocutor == 'Gnome'}">
                                <img src="${pageContext.request.contextPath}/images/gnome.jpeg" class="img-fluid"
                                     alt="Tramp">
                            </c:when>
                            <c:when test="${interlocutor == 'Tramp'}">
                                <img src="${pageContext.request.contextPath}/images/tramp2.jpeg" class="img-fluid"
                                     alt="Tramp">
                            </c:when>
                            <c:when test="${interlocutor == 'Hermit'}">
                                <img src="${pageContext.request.contextPath}/images/hermit2.jpeg" class="img-fluid"
                                     alt="Tramp">
                            </c:when>
                            <c:when test="${interlocutor == 'Cheater'}">
                                <img src="${pageContext.request.contextPath}/images/cheater2.jpeg" class="img-fluid"
                                     alt="Tramp">
                            </c:when>
                            <%--                        <c:otherwise>--%>
                            <%--                        </c:otherwise>--%>
                        </c:choose>
                    </div>
                    <div class="col">
                        <p>Strength: ${personageStrength}</p>
                        <p>Dexterity: ${personageDexterity}</p>
                        <div class="fighting-history">

                        </div>
                    </div>
                </div>
                <%--                    </c:forEach>--%>
            </div>
            <%--        </div>--%>
        </div>
        <br>
        <input type="hidden" name="personageName" value="${personageName}">
        <input type="hidden" name="lastLocation" value="${lastLocation}">
        <input type="hidden" name="kick" value="kick">
        <input type="submit" value="Kick ${personageName}"/>
    </form>
</div>
<jsp:include page="parts/footer_game.jsp"/>
</body>
</html>
