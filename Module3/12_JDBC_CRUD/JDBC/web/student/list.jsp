<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KILL YOU
  Date: 6/4/2021
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="/css/bootstrap.css">

</head>
<body>
<jsp:include page="header.jsp" />

<h2>Student List</h2>

<div class="container">
    <c:if test="${empty studentListKey}">
        <h3 style="color: red">Student List Empty</h3>
    </c:if>

    <c:if test="${not empty studentListKey}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Point</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
<%--            <c:set var="index" value="0" />--%>
            <% int index=0; %>
            <c:forEach items="${studentListKey}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>
                        <c:choose>
                            <c:when test="${student.gender == 0}">Female</c:when>
                            <c:when test="${student.gender == 1}">Male</c:when>
                            <c:otherwise>LGBT</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${student.point >= 75}">Pass</c:if>
                        <c:if test="${student.point < 75}">Fail</c:if>
                    </td>
                    <td>
                        <img src="/img/${student.image}" width="50" height="50">
                    </td>
                    <td>
                        <a class="btn btn-primary" href="/student?action=delete&index=<%=index%>" role="button">Delete</a>
                    </td>
                </tr>
                <% index++; %>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>