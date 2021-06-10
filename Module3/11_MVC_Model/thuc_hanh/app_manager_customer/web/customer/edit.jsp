<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/10/2021
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit</h1>
<p>
    <a href="customers">Back to customer list</a>
</p>

<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${customer.getName()}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${customer.getEmail()}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${customer.getAddress()}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update customer"></td>
        </tr>
    </table>
</form>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
</body>
</html>
