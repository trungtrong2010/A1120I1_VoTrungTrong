<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/9/2021
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>Customers</h1>
<p><a href="customers?action=create">Create new customer</a> </p>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items='${customers}' var="customers">
        <tr>
            <td>${customers.getId()}</td>
            <td>${customers.getName()}</td>
            <td>${customers.getEmail()}</td>
            <td>${customers.getAddress()}</td>
            <td><a href="customers?action=edit&id=${customers.getId()}">Edit</a></td>
            <td><a href="customers?action=delete&id=${customers.getId()}">Delete</a></td>
            <td><a href="customers?action=view&id=${customers.getId()}">View</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
