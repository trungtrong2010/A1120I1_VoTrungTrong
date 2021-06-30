<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/28/2021
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

    <style>
        .container {
            margin: auto;
            width: 60%;
        }

        #h3 {
            width: 380px;
            color: goldenrod;
            padding-bottom: 20px;
            border-top-width: 20px;
        }
    </style>
</head>
<body>
<%--<c:if test="${message!=null}">--%>
<%--    <p>${message}</p>--%>
<%--</c:if>--%>
<div class="container-fluid mt-3 container">
    <h2 class="mb-2 container" id="h3">Edit customer</h2>
    <form method="post" action="/customer?action=edit">
        <div class="form-row">
            <div class="form-group col-sm-6">
                <input type="hidden" name="id" value="${customer.id}">
                <label>Name</label>
                <input type="text" class="form-control" name="name" value="${customer.name}">
            </div>
            <div class="form-group col-sm-6">
                <label>Email</label>
                <input type="email" class="form-control" name="email" value="${customer.email}">
            </div>
        </div>
        <div class=" form-row">
            <div class="form-group col-sm-4">
                <label>Number Phone</label>
                <input type="text" class="form-control" name="phone" value="${customer.phone}">
            </div>
            <div class="form-group col-sm-5">
                <label>Date-brithday</label>
                <div class="form-group">
                    <div id="filterDate2">
                        <!-- Datepicker as text field -->
                        <div class="input-group date" data-date-format="yyyy/mm/dd">
                            <input type="text" class="form-control" name="birthday" value="${customer.birthday}">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-th"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group col-sm-3">
                <label>Gender</label>
                <select class="form-control" name="gender">
                    <c:choose>
                        <c:when test="${customer.gender==0}">
                            <option selected value="0">Female...</option>
                        </c:when>
                        <c:when test="${customer.gender==1}">
                            <option selected value="1">Male...</option>
                        </c:when>
                        <c:when test="${customer.gender==2}">
                            <option selected value="2">LGBT...</option>
                        </c:when>
                    </c:choose>
                    <option value="0">Female</option>
                    <option value="1">Male</option>
                    <option value="2">LGBT</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <%--@declare id="inputaddress"--%><label for="inputAddress">Address</label>
            <input type="text" class="form-control" id="myAddress" name="address" value="${customer.address}">
        </div>
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Id-Card</label>
                <input type="text" class="form-control" name="idCard" value="${customer.idCard}">
            </div>
            <div class="form-group col-sm-3">
                <label>Customer Type</label>
                <select class="form-control" name="idType">
                    <c:choose>
                        <c:when test="${customer.getCustomerType().getId()==1}">
                            <option selected value="1">Diamond...</option>
                        </c:when>
                        <c:when test="${customer.getCustomerType().getId()==2}">
                            <option selected value="2">Platinium...</option>
                        </c:when>
                        <c:when test="${customer.getCustomerType().getId()==3}">
                            <option selected value="3">Gold...</option>
                        </c:when>
                        <c:when test="${customer.getCustomerType().getId()==4}">
                            <option selected value="4">Silver...</option>
                        </c:when>
                        <c:when test="${customer.getCustomerType().getId()==5}">
                            <option selected value="5">Menbe...r</option>
                        </c:when>
                    </c:choose>
                    <option value="1">Diamond</option>
                    <option value="2">Platinium</option>
                    <option value="3">Gold</option>
                    <option value="4">Silver</option>
                    <option value="5">Menber</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-11 button_top">
                <a href="/customer">
                    <button type="button" class="btn btn-secondary">Back</button>
                </a>
            </div>
            <div class="form-group col-sm-1 button_top form-row">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </div>
        </div>


    </form>
</div>
<%--Form--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<%--date--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.min.js"></script>
<script>
    $('.input-group.date').datepicker({format: "yyyy/mm/dd"});
</script>
</body>
</html>
