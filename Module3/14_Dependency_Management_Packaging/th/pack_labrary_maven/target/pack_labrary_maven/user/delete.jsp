<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/18/2021
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<h1>Delete User</h1>
<form method="post" action="user?action=delete">
    <input type="hidden" name="id" value="${user.getId()}">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Id</td>
                <td>${user.getId()}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${requestScope["user"].getName()}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${requestScope["user"].getEmail()}</td>
            </tr>
            <tr>
                <td>Country</td>
                <td>${requestScope["user"].getCountry()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete user"> </td>
                <td><a href="/user">Back to list user</a> </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
