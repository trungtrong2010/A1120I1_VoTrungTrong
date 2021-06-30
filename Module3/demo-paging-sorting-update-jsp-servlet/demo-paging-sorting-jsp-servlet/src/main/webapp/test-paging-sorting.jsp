<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--    DataTables 1.10.21 support bootstrap <= 4.1.3--%>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">

                <thead>
                <tr style="height: 50px" class="text-center">
                    <th>id</th>
                    <th>Id Customer Type</th>
                    <th>Customer Type Name</th>
                    <th>Customer Name</th>
                    <th>Id Card</th>
                    <th>Phone</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${requestScope['customerList']}" varStatus="count">
                    <tr>
                        <td>${customer.getId()}</td>
                        <td>${customer.getCustomerType().getId()}</td>
                        <td>${customer.getCustomerType().getName()}</td>
                        <td>${customer.getName()}</td>
                        <td>${customer.getIdCard()}</td>
                        <td>${customer.getPhone()}</td>
                        <td class="text-center">
                            <a href="/?action=edit&id=${customer.getId()}"
                               role="button" class="btn btn-large btn-warning">Sua</a>
                            <!-- Button trigger modal -->
                            <a href="#myModal_${customer.getId()}" role="button" class="btn btn-large btn-danger"
                               data-toggle="modal">Xoa</a>
                        </td>
                    </tr>
                    <!-- Modal -->
                    <div id="myModal_${customer.getId()}" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                </div>

                                <div class="modal-body">
                                    <p>Ban co mun xoa ${customer.getId()} nay</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Dong</button>
                                    <a href="/?action=delete&id=${customer.getId()}"
                                       role="button" class="btn btn-danger" title="Xoa">Xoa</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        });
    });
</script>
</body>
</html>
