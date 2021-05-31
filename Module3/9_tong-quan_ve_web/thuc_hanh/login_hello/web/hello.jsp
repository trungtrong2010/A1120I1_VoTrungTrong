<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/31/2021
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .login {
            height: 200px;
            width: 350px;
            border: 2px solid saddlebrown;
            padding: 10px;
            margin-top: 200px;
            margin-left: 400px;
        }
        .login input {
            padding: 5px;
            margin: 10px;
        }
        .login h3 {
            text-align: center;
        }
    </style>
</head>
<body>
<form method="post">
    <div class="login">
        <h3>Login</h3>
        <input type="text" name="user" size="40" placeholder="Tên đăng nhập"/>
        <input type="password" name="pass" size="40" placeholder="Mật khẩu"/>
        <input type="submit" value="Sign-in"/>
    </div>
</form>
</body>
</html>
