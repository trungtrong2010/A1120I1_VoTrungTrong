<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/17/2021
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Translate</h3>
<form method="post" action="/translate">
    <label>English</label>
    <input type="text" name="english">
    <button>Translate</button>
</form>
<p>Vietnamese: ${vietnamese}</p>
</body>
</html>
