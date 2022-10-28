<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Employee info</h2>

<br>
<form:form action="saveEmployee" modelAttribute="employee">
<%--this field is not reflected and using only when /updateInfo --%>
    <form:hidden path="id"/>

<%--    all fields filling with halp GETTERS. After press "Ok" button worked SETTERS--%>
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Department <form:input path="department"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    <input type="submit" value="Ok">
</form:form>

</body>
</html>