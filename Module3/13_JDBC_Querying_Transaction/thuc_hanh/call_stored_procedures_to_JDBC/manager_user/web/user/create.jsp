<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/18/2021
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<h1>Create User</h1>
<p><a href="/user">Back to list User</a></p>
<form method="post" action="/user?action=create">
    <div>
        <span>Name:</span>
        <input type="text" name="name">
    </div>
    <div>
        <span>Email:</span>
        <input type="text" name="email">
    </div>
    <div>
        <span>Country:</span>
        <input type="text" name="country">
    </div>
    <button type="submit" >Create</button>
</form>
</body>
</html>
