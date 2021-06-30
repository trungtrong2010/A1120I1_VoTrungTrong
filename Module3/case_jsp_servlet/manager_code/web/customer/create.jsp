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
    <h3 class="mb-2 container" id="h3">Create customer</h3>
    <form method="post" action="/customer?action=create">
        <div class="form-row">
            <div class="form-group col-sm-6">
                <label>Name</label>
                <input type="text" class="form-control" name="name" placeholder="Nguyễn Văn A">
            </div>
            <div class="form-group col-sm-6">
                <label>Email</label>
                <input type="email" class="form-control" name="email" placeholder="abc123@gmail.com">
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
                <label>Gender</label>
                <select class="form-control" name="gender">
                    <option value="0">Female</option>
                    <option value="1">Male</option>
                    <option value="2">LGBT</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <%--@declare id="inputaddress"--%><label for="inputAddress">Address</label>
            <input type="text" class="form-control" id="myAddress" name="address" placeholder="Da Nang">
        </div>
        <div class="form-row">
            <div class="form-group col-sm-4">
                <label>Id-Card</label>
                <input type="text" class="form-control" name="idCard" placeholder="xxxx xxx xxx">
            </div>
            <div class="form-group col-sm-3">
                <label>Customer Type</label>
                <select class="form-control" name="idType">
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
