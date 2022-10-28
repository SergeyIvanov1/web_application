<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<br>
<div><a href="/">Main page</a></div>
<br>
<div><a href="/cryptanalyzer">Cryptanalyzer</a></div>

<br><br>
<h2>All employees</h2>

<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${allEmps}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>

        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>

        </c:url>

        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<input type="button" value="Add"
       onclick="window.location.href = '/addNewEmployee'"/>

</body>
</html>
