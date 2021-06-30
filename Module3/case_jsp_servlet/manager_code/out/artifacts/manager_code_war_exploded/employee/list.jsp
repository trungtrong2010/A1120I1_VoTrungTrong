<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/30/2021
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Employee</title>
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

        .form_search {
            margin-left: 500px;
            margin-right: 500px;
        }
    </style>
</head>
<body>
<div class="button_top">
    <a href="/homePage">
        <button type="button" class="btn btn-secondary">Back to Home Page</button>
    </a>
    <a href="/employee?action=create">
        <button type="button" class="btn btn-success" style="color: yellow">Create Employee</button>
    </a>
    <%--<button type="button" class="btn btn-danger">Danger</button>--%>
    <%--<button type="button" class="btn btn-warning">Warning</button>--%>
    <%--<button type="button" class="btn btn-info">Info</button>--%>
    <%--<button type="button" class="btn btn-light">Light</button>--%>
    <%--<button type="button" class="btn btn-dark">Dark</button>--%>
</div>
<form class="d-flex form_search" method="post" action="/employee?action=findEmployeeById">
    <input class="form-control me-2" type="text" placeholder="Search Name" name="name" value="${findName}"
           aria-label="Search">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
<div class="content_table">
    <h3 style="color: darkred; padding-bottom: 20px">List employee</h3>
    <table id="tableCustomer" class="table table-hover table-bordered" style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Divition</th>
            <th>Birthday</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th></th>
            <th></th>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="employee">
            <tr>
                <td>${employee.getId()}</td>
                <td>${employee.getName()}</td>
                <td>${employee.getDivition().getName()}</td>
                <td>${employee.getBirthday()}</td>
                <td>${employee.getPhone()}</td>
                <td>${employee.getEmail()}</td>
                <td>${employee.getAddress()}</td>
                <td>
                    <a class="btn btn-primary" id="show" href="" data-toggle="modal"
                       data-target="#modelShow"
                       onclick="Value('${employee.getId()}','${employee.getName()}','${employee.getBirthday()}',
                               '${employee.getIdCard()}','${employee.getSalary()}','${employee.getPhone()}','${employee.getEmail()}',
                               '${employee.getAddress()}','${employee.getPosition().getName()}',
                               '${employee.getEducationDegree().getName()}','${employee.getDivition().getName()}',
                               '${employee.getUser().getUsername()}','${employee.getUser().getPassword()}')">Show</a>
                </td>
                <td>
                    <a href="/employee?action=edit&id=${employee.getId()}">
                        <button class="btn btn-warning">Edit</button>
                    </a>
                </td>
                <td>
                    <a class="btn btn-danger" href="#" role="button" data-toggle="modal"
                       data-target="#modelDelete"
                       onClick="onDelete('${employee.getId()}');nameDelete('${employee.getName()}')">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        <div>
                    <c:if test="${listEmployeeFindByName!=null}">
                        <c:forEach items="${listEmployeeFindByName}" var="employee">
                            <tr>
                                <td>${employee.getId()}</td>
                                <td>${employee.getName()}</td>
                                <td>${employee.getDivition().getName()}</td>
                                <td>${employee.getBirthday()}</td>
                                <td>${employee.getPhone()}</td>
                                <td>${employee.getEmail()}</td>
                                <td>${employee.getAddress()}</td>
                                <td>
                                    <a class="btn btn-primary" id="show" href="" data-toggle="modal"
                                       data-target="#modelShow"
                                       onclick="Value('${employee.getId()}','${employee.getName()}','${employee.getBirthday()}',
                                               '${employee.getIdCard()}','${employee.getSalary()}','${employee.getPhone()}','${employee.getEmail()}',
                                               '${employee.getAddress()}','${employee.getPosition().getName()}',
                                               '${employee.getEducationDegree().getName()}','${employee.getDivition().getName()}',
                                               '${employee.getUser().getUsername()}','${employee.getUser().getPassword()}')">Show</a>
                                </td>
                                <td>
                                    <a href="/employee?action=edit&id=${employee.getId()}">
                                        <button class="btn btn-warning">Edit</button>
                                    </a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" href="#" role="button" data-toggle="modal"
                                       data-target="#modelDelete"
                                       onClick="onDelete('${employee.getId()}');nameDelete('${employee.getName()}')">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
        </div>
        </tbody>
    </table>
</div>

<div class="modal fade" id="modelShow" tabindex="-1" role="dialog"
     aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Information Employee</h5>
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
                        <th><label for="">Date:</label></th>
                        <td><span id="birthdayShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Id card:</label></th>
                        <td><span id="idCardShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Salary:</label></th>
                        <td><span id="salaryShow"></span></td>
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
                    <tr>
                        <th><label for="">Position:</label></th>
                        <td><span id="namePositionShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Education Degree:</label></th>
                        <td><span id="nameEducationDegreeShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Divition:</label></th>
                        <td><span id="nameDivitionShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Username:</label></th>
                        <td><span id="usernameShow"></span></td>
                    </tr>
                    <tr>
                        <th><label for="">Password:</label></th>
                        <td><span id="passwordShow"></span></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal Delete-->
<div class="modal fade" id="modelDelete" tabindex="-1" role="dialog"
     aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xác nhận xóa khách hàng</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/employee">
                <input type="hidden" name="id" id="idEmployee">
                <input type="hidden" name="action" value="delete">
                <div class="modal-body">
                    <p id="body"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">
                        Cancel
                    </button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
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

<script src="../lib/js/jquery-3.5.1.min.js"></script>
<script src="../lib/js/bootstrap.js"></script>
<script src="../lib/datatables/js/jquery.dataTables.js"></script>
<script src="../lib/datatables/js/dataTables.bootstrap4.js"></script>
<script>
    // show list customer
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            'pageLength': 3
        })
    });

    //show Infomation Customer
    function Value(id, name, birthday, idCard, salary, phone, email, address, namePosition,
                   nameEducationDegree, nameDivition, username, password) {
        document.getElementById("idShow").innerHTML = id;
        document.getElementById("nameShow").innerHTML = name;
        document.getElementById("birthdayShow").innerHTML = birthday;
        document.getElementById("salaryShow").innerHTML = salary;
        document.getElementById("idCardShow").innerHTML = idCard;
        document.getElementById("phoneShow").innerHTML = phone;
        document.getElementById("emailShow").innerHTML = email;
        document.getElementById("addressShow").innerHTML = address;
        document.getElementById("namePositionShow").innerHTML = namePosition;
        document.getElementById("nameEducationDegreeShow").innerHTML = nameEducationDegree;
        document.getElementById("nameDivitionShow").innerHTML = nameDivition;
        document.getElementById("usernameShow").innerHTML = username;
        document.getElementById("passwordShow").innerHTML = password;
    }

    function onDelete(idDelete) {
        document.getElementById("idEmployee").value = idDelete;
    }

    function nameDelete(nameDelete) {
        document.getElementById("body").innerText = "Bạn có muốn xóa: " + nameDelete + " ?";
    }

    // message Create/edit/delete
    window.setTimeout(function () {
        $(".alert").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 4000);
</script>
</body>
</html>
