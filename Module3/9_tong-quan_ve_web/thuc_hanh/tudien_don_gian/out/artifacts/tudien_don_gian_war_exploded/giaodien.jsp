<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/1/2021
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dịch</h2>
<form method="post">
    <input type="text" name="search" placeholder="Enter your word: ">
    <input type="submit" name="submit" value="Search">
</form>
<h2>Search: ${search}</h2>
<h2>Result: ${result}</h2>
</body>
</html>
