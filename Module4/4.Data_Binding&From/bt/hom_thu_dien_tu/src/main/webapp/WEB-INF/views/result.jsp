<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/19/2021
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result setting</title>
</head>
<body>
<h3>Result setting</h3>
<table>
    <tr>
        <td>Languages: </td>
        <td>${setting.language}</td>
    </tr>
    <tr>
        <td>Page size: </td>
        <td>${setting.size}</td>
    </tr>
    <tr>
        <td>Spams filter: </td>
        <td>${setting.filter}</td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>${setting.signature}</td>
    </tr>
</table>
</body>
</html>
