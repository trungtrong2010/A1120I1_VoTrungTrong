<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/5/2021
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List</title>
</head>
<body>
<div class="content_table">
    <h3 style="color: darkred; padding-bottom: 20px">List employee</h3>
    <table id="tableEmployee" class="table table-hover table-bordered" style="width: 100%">
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
                <input placeholder=""
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
</body>
</html>
