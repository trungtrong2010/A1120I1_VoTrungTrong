<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/11/2021
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find product from name</title>
</head>
<body>
<h1>Find product from name</h1>
<p><a href="product">Back to list product</a></p>
<form method="post">
    <input type="text" name="name" placeholder="input find name">
    <input type="submit" value="Seach">
</form>
<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span>${requestScope["message"]}</span>
    </c:if>
<%--    <c:if test='${requestScope["product"]!=null}'>--%>
<%--        <span>Id: ${requestScope["product"].getId()}</span> <br>--%>
<%--        <span>Name: ${requestScope["product"].getName()}</span><br>--%>
<%--        <span>Price: ${requestScope["product"].getPrice()}</span><br>--%>
<%--        <span>Descrip: ${requestScope["product"].getDescrip()}</span><br>--%>
<%--        <span>Producer: ${requestScope["product"].getProducer()}</span>--%>
<%--    </c:if>--%>
</p>
</body>
</html>
