<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/1/2021
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<h1> Currency Converter</h1>
<form method="post" action="result.jsp">
    <label>Rate: </label> <br>
    <input type="number" name="rate" placeholder="RATE" value="22000"/><br>
    <label>Usd: </label><br>
    <input type="number" name="usd" placeholder="USD" value="0"/><br>
    <input type="submit" value="Converter"/>
</form>
</body>
</html>
