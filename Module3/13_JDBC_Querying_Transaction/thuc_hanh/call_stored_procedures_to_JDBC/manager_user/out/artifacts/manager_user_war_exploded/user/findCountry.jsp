<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/18/2021
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Find User country</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<div class="menu">
    <h1>List User</h1>
    <p><a href="/user">Back to list User</a></p>
    <form method="post" action="/user?action=findCountry">
        <input type="text" name="country">
        <span><input type="submit" value="Seach"></span>
    </form>
    <c:if test="${error!=null}">
        <h1>${error}</h1>
    </c:if>
    <c:if test="${listUser!=null}">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
            </tr>
            <c:forEach items="${listUser}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.country}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
