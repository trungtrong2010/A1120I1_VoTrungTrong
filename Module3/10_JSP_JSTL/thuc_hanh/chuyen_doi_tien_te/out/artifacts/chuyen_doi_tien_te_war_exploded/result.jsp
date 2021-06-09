<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/1/2021
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<h1> Currency Converter</h1>
<form method="post">
    <label>Rate: </label> <br>
    <input type="number" name="rate" placeholder="RATE" value="22000"/><br>
    <label>Usd: </label><br>
    <input type="number" name="usd" placeholder="USD" value="0"/><br>
    <input type="submit" value="Converter"/>
</form>
<%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));
    float vnd = rate * usd;
%>
<h1>Rate: <%=rate%></h1>
<h1>USD: <%=usd%></h1>
<h1>VND: <%=vnd%></h1>
</body>
</html>
