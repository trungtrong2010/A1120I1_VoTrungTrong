<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/19/2021
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
<div class="display">
    <div class="header">
        <nav class="navbar navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="image/logoCG.jpg" alt="" width="30" height="30"
                         class="d-inline-block align-text-top">
                </a>
                <p class="d-flex">Võ Trung Trọng</p>
            </div>
        </nav>
        <nav class="navbar navbar-light" style="background-color: #3f4348;">
            <div class="container-fluid">
                <nav class="navbar navbar-expand-sm navbar-dark">
                    <a class="navbar-brand" href="#">Home</a>

                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/employee">Employee</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/customer">Customer</a>
<%--                                <div class="btn-group">--%>
<%--                                <button class="btn dropdown-toggle"--%>
<%--                                        type="button" style="color: #9c9c9c"--%>
<%--                                        id="dropdownMenuButton" data-toggle="dropdown">--%>
<%--                                    Customer--%>
<%--                                </button>--%>
<%--                                <div class="dropdown-menu">--%>
<%--                                    <a class="dropdown-item" href="/customer?action=listCustomerType">List Customer Type</a>--%>
<%--                                    <div class="dropdown-divider"></div>--%>
<%--                                    <a class="dropdown-item" href="#">xxxx</a>--%>
<%--                                    <div class="dropdown-divider"></div>--%>
<%--                                    <a class="dropdown-item" href="#">xxxx</a>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/service">Service</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Contract</a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
    <div class="container-fluid">
        <div class="row ">
            <div class="col-sm-2 display-item left-container " style="background-color: white;">
                <p><a href="#">Item One</a></p>
                <p><a href="#">Item Tow</a></p>
                <p><a href="#">Item Three</a></p>
            </div>
            <div class="col-sm-10 content">
                <p style="text-align: center">
            </div>
        </div>
    </div>
    <div class="footer">
        <footer class="page-footer font-small blue footer fixed-bottom" style="background-color: #d1a49b">
            <div class="footer-copyright text-center py-3">© Facebook:
                <a href="https://facebook.com/trungtrong2020"> Võ Trung Trọng </a>
            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
