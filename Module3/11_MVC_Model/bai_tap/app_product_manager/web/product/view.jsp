<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/11/2021
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>View product</h1>
<p><a href="product">Back to list product</a></p>
<p><a href="product?action=find">Find from Name product</a></p>
<fieldset>
    <legend>View product</legend>
    <table>
        <tr>
            <td>Id</td>
            <td>${product.getId()}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${requestScope["product"].getPrice()}</td>
        </tr>
        <tr>
            <td>Descrip</td>
            <td>${requestScope["product"].getDescrip()}</td>
        </tr>
        <tr>
            <td>Producer</td>
            <td>${requestScope["product"].getProducer()}</td>
        </tr>
    </table>
</fieldset>
</body>
</html>
