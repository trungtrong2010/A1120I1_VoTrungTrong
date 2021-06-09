<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/2/2021
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
<%! Map<String, String> dich = new HashMap<>();%>
<%
    request.setCharacterEncoding("UTF-8");
//    response.setCharacterEncoding("UTF-8");
    dich.put("hello", "Xin chào");
    dich.put("how", "Thế nào?");
    dich.put("what", "Cái gì?");
    dich.put("book", "Quyển vở");
    dich.put("computer", "Máy tính");
    String search = request.getParameter("search");
    String result = dich.get(search);
    if (result == null) {
        result = "Not found";
//        request.setAttribute("result", "Not found");
//    } else {
//        request.setAttribute("result", result);
    }
%>
<h3>Input: <%=search%>
</h3>
<h3>Result: <%=result%>
</h3>
</body>
</html>
