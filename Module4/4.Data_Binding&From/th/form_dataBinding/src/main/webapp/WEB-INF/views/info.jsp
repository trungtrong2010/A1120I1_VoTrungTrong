<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/19/2021
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Infor</title>
</head>
<body>
<h3>Submitted Employee Information</h3>
<table>
    <tr>
        <td>Name :</td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>ID :</td>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <td>Contact Number :</td>
        <td>${employee.contactNumber}</td>
    </tr>
</table>
</body>
</html>
