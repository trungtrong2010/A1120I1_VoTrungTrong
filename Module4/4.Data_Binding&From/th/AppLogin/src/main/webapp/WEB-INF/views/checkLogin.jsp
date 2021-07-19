<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/19/2021
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check login</title>
    <style>
        h2,h3{
            text-align: center;
        }
        h2{
            color: red;
        }
    </style>
</head>
<body>
<c:if test="${message != null}">
    <h2>Login error</h2>
    <h3>${message} Account "${login.account}"</h3>
</c:if>
<c:if test="${user.account != null}">
    <h2>Welcome</h2>
    <h3>Account: ${user.account}</h3>
    <h3>Name: ${user.name}</h3>
    <h3>Email: ${user.email}</h3>
    <h3>Age: ${user.age}</h3>
</c:if>
</body>
</html>
