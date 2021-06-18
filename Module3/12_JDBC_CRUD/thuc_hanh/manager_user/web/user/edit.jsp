<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/18/2021
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h1>Edit User</h1>
<p><a href="/user">Back to list User</a></p>
<form method="post" action="user?action=edit">
    <input type="hidden" name="id" value="${user.getId()}">
    <div>
        <span>Name:</span>
        <input type="text" name="name" value="${user.getName()}">
    </div>
    <div>
        <span>Email:</span>
        <input type="text" name="email" value="${user.getEmail()}">
    </div>
    <div>
        <span>Country:</span>
        <input type="text" name="country" value="${user.getCountry()}">
    </div>
    <button type="submit" >Edit</button>
</form>
</body>
</html>
