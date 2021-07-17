<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/17/2021
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Check mail</h3>
<form action="/check" method="post">
    <label>Email: </label>
    <input name="email" value="${email}">
    <button>Check</button>
</form>
<p style="color: red" >${message}</p>
</body>
</html>
