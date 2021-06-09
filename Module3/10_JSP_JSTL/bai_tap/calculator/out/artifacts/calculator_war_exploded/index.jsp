<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/7/2021
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form method="post" action="giaodien">
    <table>
        <tr>
            <td>First operand: </td>
            <td><input name="first" type="number"/></td>
        </tr>
        <tr>
            <td>Operator: </td>
            <td>
                <select name="operator">
                    <option value="+">Addition</option>
                    <option value="-">Subtraction</option>
                    <option value="*">Multiplication</option>
                    <option value="/">Division</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Second operand: </td>
            <td><input name="second" type="number"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Calculator"/></td>
        </tr>
    </table>
    <c:if test="${error != null}">
        <h1>${error}</h1>
    </c:if>
</form>
</body>
</html>
