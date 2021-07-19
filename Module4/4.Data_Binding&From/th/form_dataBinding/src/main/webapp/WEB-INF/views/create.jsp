<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/19/2021
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h3>Create employee</h3>
<%--@elvariable id="employee" type=""--%>
<form:form method="post" action="/add" modelAttribute="employee">
    <table>
        <tr>
            <td><label>ID: </label></td>
            <td><form:input path="id"></form:input></td>
        </tr>
        <tr>
            <td><label>Name: </label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><label>Contact number: </label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
