<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/21/2021
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>get User by Id</title>
</head>
<body>
<h1>Infomation User by Id</h1>
<% request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<div class="menu">
    <h1>List User</h1>
    <p><a href="/user">Back to list User</a></p>
    <form method="post" action="/user?action=a">
        <input type="number" name="id">
        <span><input type="submit" value="Seach"></span>
    </form>
    <c:if test="${error!=null}">
        <h1>${error} : ${id}</h1>
    </c:if>
    <c:if test="${user.getName()!=null}">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
            </tr>
            <tr>
                <td>${id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
            </tr>

        </table>
    </c:if>
</div>
</body>
</html>
