<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/26/2021
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Customers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="../lib/datatables/css/dataTables.bootstrap4.css">
    <style>
        .button_top {
            text-align: center;
            padding-top: 50px;
            padding-bottom: 50px;
        }

        .content_table {
            text-align: center;
        }
    </style>

</head>
<body>
<div class="button_top">
    <button type="button" class="btn btn-secondary"><a href="homePage" style="color: white">Back to Home Page</a>
    </button>
    <button type="button" class="btn btn-success"><a href="customer?action=create" style="color: yellow">Create
        customer</a></button>
    <%--<button type="button" class="btn btn-danger">Danger</button>--%>
    <%--<button type="button" class="btn btn-warning">Warning</button>--%>
    <%--<button type="button" class="btn btn-info">Info</button>--%>
    <%--<button type="button" class="btn btn-light">Light</button>--%>
    <%--<button type="button" class="btn btn-dark">Dark</button>--%>
</div>
<div class="content_table">
    <h3 style="color: darkred; padding-bottom: 20px">List customers</h3>
    <table id="tableCustomer" class="table table-hover table-bordered" style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Address</th>
            <th></th>
            <th></th>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCustomer}" var="customer">
            <tr>
                <td>${customer.getId()}</td>
                <td>${customer.getName()}</td>
                <td>${customer.getCustomerType().getName()}</td>
                <td>${customer.getBirthday()}</td>
                <td>
                    <c:choose>
                        <c:when test="${customer.getGender()==0}">Female</c:when>
                        <c:when test="${customer.getGender()==1}">Male</c:when>
                        <c:when test="${customer.getGender()==2}">LGBT</c:when>
                    </c:choose>
                </td>
                <td>${customer.getEmail()}</td>
                <td>${customer.getAddress()}</td>
                <td><a class="btn btn-primary" id="show" href="" data-toggle="modal"
                       data-target="#modelShow"
                       onclick="Value('${customer.getId()}','${customer.getName()}','${customer.getCustomerType().getName()}','${customer.getBirthday()}','${customer.getGender()}','${customer.getIdCard()}','${customer.getPhone()}','${customer.getEmail()}','${customer.getAddress()}')">Show</a>
                </td>
                    <%--                <td>Show</td>--%>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="modal fade" id="modelShow" tabindex="-1" role="dialog"
     aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Information Customer</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-hover">
                    <%--@declare id=""--%>
                    <tr>
                        <th><label for="">ID:</label></th>
                        <td><span id="idShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Name:</label></th>
                        <td><span id="nameShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Type:</label></th>
                        <td><span id="typeNameShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Date:</label></th>
                        <td><span id="birthdayShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Gender:</label></th>
                        <td><span id="genderShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Id card:</label></th>
                        <td><span id="idCardShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Number phone:</label></th>
                        <td><span id="phoneShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Email:</label></th>
                        <td><span id="emailShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Address:</label></th>
                        <td><span id="addressShow"></span></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script src="../lib/js/jquery-3.5.1.min.js"></script>
<script src="../lib/js/bootstrap.js"></script>
<script src="../lib/datatables/js/jquery.dataTables.js"></script>
<script src="../lib/datatables/js/dataTables.bootstrap4.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            'pageLength': 5
        })
    });

    function Value(id, name, typeName, birthday, gender, idCard, phone, email, address) {
        document.getElementById("idShow").innerHTML = id;
        document.getElementById("nameShow").innerHTML = name;
        document.getElementById("typeNameShow").innerHTML = typeName;
        document.getElementById("birthdayShow").innerHTML = birthday;
        document.getElementById("genderShow").innerHTML = gender;
        document.getElementById("idCardShow").innerHTML = idCard;
        document.getElementById("phoneShow").innerHTML = phone;
        document.getElementById("emailShow").innerHTML = email;
        document.getElementById("addressShow").innerHTML = address;
    }
</script>
</body>
</html>
