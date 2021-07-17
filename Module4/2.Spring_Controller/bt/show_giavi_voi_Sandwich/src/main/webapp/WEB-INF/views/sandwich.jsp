<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/17/2021
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h2>Condiments Sandwich</h2>
<form method="post" action="/choice">
    <input type="checkbox" value="Lettuce" id="lettuce" name="condiment"/>
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" value="Tomato" id="tomato" name="condiment"/>
    <label for="tomato">Tomato</label>
    <input type="checkbox" value="Mustard" id="mustard" name="condiment"/>
    <label for="mustard">Mustard</label>
    <input type="checkbox" value="Sprouts" id="sprouts" name="condiment"/>
    <label for="sprouts">Sprouts</label>
    <br>
    <button>Submit</button>
</form>
</body>
</html>
