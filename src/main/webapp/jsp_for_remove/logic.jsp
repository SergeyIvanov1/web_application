
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Application</title>
</head>
<body>
<p>Second: ${users[1]}</p>
<p>Third: ${users[2]}</p>

<c:forEach var="item" items="${users}">
    <tr>
        <td><c:out value="${item}"></c:out></td>
        <td><c:out value="${item}"></c:out></td>
        <td><c:out value="${item}"></c:out></td>
    </tr>
</c:forEach>
</body>
</html>