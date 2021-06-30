<%--
  Created by IntelliJ IDEA.
  User: KILL YOU
  Date: 6/14/2021
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp" />

<form method="post" action="/student?action=create">
    <div>
        <span>Name:</span>
        <input type="text" name="name">
    </div>
    <div>
        <span>Gender:</span>
        <input type="number" name="gender">
    </div>
    <div>
        <span>Point:</span>
        <input type="number" name="point">
    </div>
    <div>
        <span>Image:</span>
        <input type="text" name="image">
    </div>
    <button type="submit" >Create</button>
</form>
</body>
</html>
