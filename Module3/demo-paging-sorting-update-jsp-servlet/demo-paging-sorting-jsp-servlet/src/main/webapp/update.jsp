<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/29/2020
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Title</title>

</head>
<body>
<div class="wrapper ">
    <div class="main-panel">
        <!-- Navbar -->
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 text-center">
                        <h1>Edit Customer</h1>
                    </div>
                    <form class="col-12" method="post">
                        <div class="form-group col-12">
                            <label class="col-12 float-left">Id:</label>
                            <input type="text" name="id" class="form-control col-12 float-left mt-2"
                                   value="${customer.getId()}" readonly>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="a">Name:</label>
                            <input id="a" type="text" name="name" class="form-control col-12 float-left mt-2"
                                   value="${customer.getName()}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">Id Card:</label>
                            <input type="text" name="idCard" class="form-control col-12 float-left mt-2"
                                   value="${customer.getIdCard()}">
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left">Phone:</label>
                            <input type="text" name="phone" class="form-control col-12 float-left mt-2"
                                   value="${customer.getPhone()}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">Customer Type:</label>
                            <select class="form-control" name="id_customer_type">
                                <c:forEach var="type" items="${customerType}">
                                    <c:choose>
                                        <c:when test="${type.id == customer.getCustomerType().getId()}">
                                            <option value="${type.id}" selected> ${type.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${type.id}">${type.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary float-right">Edit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>
