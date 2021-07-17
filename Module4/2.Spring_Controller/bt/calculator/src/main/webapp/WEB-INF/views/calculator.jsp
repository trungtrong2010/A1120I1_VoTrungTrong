<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/17/2021
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3>Calculator</h3>
<form method="post" action="/showResult">
    <input type="number" name="number1" value="${number1}" placeholder="number1">
    <input type="number" name="number2" value="${number2}" placeholder="number2">
    <br>
    <input type="submit" value="Addition(+)" name="calculator">
    <input type="submit" value="Subtraction(-)" name="calculator">
    <input type="submit" value="Multiptication(x)" name="calculator">
    <input type="submit" value="Division(/)" name="calculator">
</form>
<c:if test="${calculator != null}">
    <c:if test="${message == null}">
        <p>${calculator}: ${result}</p>
    </c:if>
</c:if>
<c:if test="${message != null}">
    <p style="color: red">${message}</p>
</c:if>
</body>
</html>
