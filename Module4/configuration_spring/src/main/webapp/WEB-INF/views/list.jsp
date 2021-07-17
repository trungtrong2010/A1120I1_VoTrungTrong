<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/14/2021
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
