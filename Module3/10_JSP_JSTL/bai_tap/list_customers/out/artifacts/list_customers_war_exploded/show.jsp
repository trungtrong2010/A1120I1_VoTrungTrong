<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/4/2021
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List of Customers</h2>
<table class="table">
    <tr >
        <th>Name</th>
        <th>Gender</th>
        <th>Date</th>
        <th>Address</th>
        <th>Avata</th>
    </tr>
    <c:forEach items="${listCustomers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.gender}</td>
            <td>${customer.date}</td>
            <td>${customer.address}</td>
            <td>
                <img src="/image/${customer.image}" width="100" height="100">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
