<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/11/2021
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete product</h1>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
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
            <tr>
                <td><input type="submit" value="Delete product"> </td>
                <td><a href="product">Back to list product</a> </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
