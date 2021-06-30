<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/20/2021
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List sort Name</title>
</head>
<body>
<p><a href="/user">Back to list user</a></p>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
    </tr>
    <c:forEach items="${listSortName}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.email}</td>
            <td>${list.country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
