<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/26/2021
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
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

<div class="container-fluid mt-3 container">
    <h3 class="mb-2 container" id="h3">Create service</h3>

    <c:if test="${error!=null}">
        <div class="alert alert-danger" role="alert">
            Wrong ${error} format... Please re-fill !!!
        </div>
    </c:if>
    <c:if test="${errorNull!=null}">
        <div class="alert alert-danger" role="alert">${errorNull}</div>
    </c:if>
    <form method="post" action="/service?action=create">
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Name</label>
                <input type="text" class="form-control" name="name" value="${service.getName()}" placeholder="Nguyễn Văn A">
            </div>
            <div class="form-group col-sm-4">
                <label>Area</label>
                <input type="number" class="form-control" name="area" value="${service.getArea()}" placeholder="xxx m2">
            </div>
            <div class="form-group col-sm-4">
                <label>Cost</label>
                <input type="number" class="form-control" name="cost" value="${service.getCost()}" placeholder="VNd">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-3">
                <label>Rent type</label>
                <select class="form-control" name="rentTypeId">
                    <c:choose>
                        <c:when test="${service.getRentType().getId()==1}">
                            <option selected value="1">Hour</option>
                        </c:when>
                        <c:when test="${service.getRentType().getId()==2}">
                            <option selected value="2">Day</option>
                        </c:when>
                        <c:when test="${service.getRentType().getId()==3}">
                            <option selected value="3">Month</option>
                        </c:when>
                    </c:choose>
                    <option value="1">Hour</option>
                    <option value="2">Day</option>
                    <option value="3">Month</option>
                </select>
            </div>
            <div class="form-group col-sm-3">
                <label>Service type</label>
                <select class="form-control" name="serviceTypeId">
                    <c:choose>
                        <c:when test="${service.getServiceType().getId()==1}">
                            <option selected value="1">Villa</option>
                        </c:when>
                        <c:when test="${service.getServiceType().getId()==2}">
                            <option selected value="2">House</option>
                        </c:when>
                        <c:when test="${service.getServiceType().getId()==3}">
                            <option selected value="3">Room</option>
                        </c:when>
                    </c:choose>
                    <option value="1">Villa</option>
                    <option value="2">House</option>
                    <option value="3">Room</option>
                </select>
            </div>
            <div class="form-group col-sm-3">
                <label>Pool area</label>
                <input type="number" class="form-control" name="poolArea" value="${service.getPool_area()}" placeholder="">
            </div>
            <div class="form-group col-sm-3">
                <label>Number of floors</label>
                <input type="number" class="form-control" name="floors" value="${service.getNumber_of_floors()}" placeholder="">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-5">
                <label>Standard room</label>
                <input type="text" class="form-control" value="${service.getStandardRoom()}" name="standard">
            </div>
            <div class="form-group col-sm-5">
                <label>Description other convenience</label>
                <input type="text" class="form-control" value="${service.getDescription_other_convenience()}" name="description">
            </div>
            <div class="form-group col-sm-2">
                <label>Max people</label>
                <input type="number" class="form-control" name="maxPeople" value="${service.getMaxPeople()}" placeholder="">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-11 button_top">
                <a href="/service">
                    <button type="button" class="btn btn-secondary">Back</button>
                </a>
            </div>
            <div class="form-group col-sm-1 button_top form-row">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </div>
        </div>
    </form>
</div>
<%--Form--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
