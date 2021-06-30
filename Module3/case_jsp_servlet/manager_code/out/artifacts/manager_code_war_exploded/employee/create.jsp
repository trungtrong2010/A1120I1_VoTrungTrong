<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/30/2021
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
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

<div class="container-fluid mt-3 container">
    <h3 class="mb-2 container" id="h3">Create Employee</h3>
    <form method="post" action="/employee?action=create">
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Name</label>
                <input type="text" class="form-control" name="name" placeholder="Nguyễn Văn A">
            </div>
            <div class="form-group col-sm-4">
                <label>Email</label>
                <input type="email" class="form-control" name="email" placeholder="abc123@gmail.com">
            </div>
            <div class="form-group col-sm-4">
                <label>Id-Card</label>
                <input type="text" class="form-control" name="idCard" placeholder="xxxx xxx xxx">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Number Phone</label>
                <input type="text" class="form-control" name="phone" placeholder="0xxx xxx xxx">
            </div>
            <div class="form-group col-sm-5">
                <label>Date-brithday</label>
                <div class="form-group">
                    <div id="filterDate2">
                        <!-- Datepicker as text field -->
                        <div class="input-group date" data-date-format="yyyy/mm/dd">
                            <input type="text" class="form-control" name="birthday" placeholder="yyyy/mm/dd">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-th"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group col-sm-3">
                <label>Username</label>
                <select class="form-control" name="username">
                    <option value="admin">Admin</option>
                    <option value="employee">Employee</option>
                    <option value="manager">Manager</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-9">
            <%--@declare id="inputaddress"--%><label for="inputAddress">Address</label>
            <input type="text" class="form-control" id="myAddress" name="address" placeholder="Da Nang">
            </div>
            <div class="form-group col-sm-3">
                <label>Salary</label>
                <input type="number" class="form-control" name="salary" placeholder="VNđ">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Position</label>
                <select class="form-control" name="positionId">
                    <option value="1">Lễ tân</option>
                    <option value="2">Phục vụ</option>
                    <option value="3">Chuyên viên</option>
                    <option value="4">Giám sát</option>
                    <option value="5">Quản lý</option>
                    <option value="6">Giám đốc</option>
                </select>
            </div>
            <div class="form-group col-sm-4">
                <label>Education Degree</label>
                <select class="form-control" name="educationDegreeId">
                    <option value="1">Trung cấp</option>
                    <option value="2">Cao đẳng</option>
                    <option value="3">Đại học</option>
                    <option value="4">sau Đại học</option>
                </select>
            </div>
            <div class="form-group col-sm-4">
                <label>Divition</label>
                <select class="form-control" name="divitionId">
                    <option value="1">Sale-Marketing</option>
                    <option value="2">Hành chính</option>
                    <option value="3">Phục vụ</option>
                    <option value="4">Quản lý</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-11 button_top">
                <a href="/employee">
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
<%--date--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.min.js"></script>
<script>
    $('.input-group.date').datepicker({format: "yyyy/mm/dd"});
</script>
</body>
</html>

