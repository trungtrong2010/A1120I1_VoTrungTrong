<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/1/2021
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        .box{
            height: 300px;
            width: 400px;
            margin-left: 400px;
            margin-top: 30px;
        }
        .main {
            margin-left: 40px;
            height: 220px;
            width: 200px;
            padding: 5px;
            border: 2px solid burlywood;
            background-color: bisque;
        }

        .main input, label {
            margin: 10px;
        }

        .main h3{
            margin-left: 40px;
        }
    </style>
</head>
<body>
<div class="box">
    <h2>Product discount calculator</h2>
    <form method="post" class="main">
        <label>Product description: </label><br>
        <input type="text" name="description" placeholder="Mô tả sản phẩm"/><br>
        <label>List price: </label><br>
        <input type="number" name="price" placeholder="Giá niên yết $"/><br>
        <label>Discount percent: </label><br>
        <input type="number" name="percent" placeholder="Tỷ lệ chiết khấu %"><br>
        <input type="submit" name="submit" value="Result">
    </form>
    <h3>Mô tả sản phẩm: ${description}</h3>
    <h3>Price: ${price} $</h3>
    <h3>Percent: ${percent} %</h3>
    <h3>Result: ${result} $</h3>
</div>
</body>
</html>
