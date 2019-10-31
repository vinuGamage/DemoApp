<%--
  Created by IntelliJ IDEA.
  User: vinu_g
  Date: 10/28/2019
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="display-1">Update Users</h1>
        <br><br>
        <form action="processUpdate" modelAttribute="user" method="post">
            <div class="form-group">
                <label>User Id : </label>
                <input class="form-control" type="text" value="${userId}" readonly/>
            </div>

            <div class="form-group">
                <label>Username : </label>
                <input class="form-control" name="username" type="text" value="${username}" readonly/>
            </div>

            <div class="form-group">
                <label>First Name : </label>
                <input class="form-control" name="firstName" type="text" value="${firstName}" />
            </div>

            <div class="form-group">
                <label>Last Name : </label>
                <input class="form-control" name="lastName" type="text" value="${lastName}" />
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-warning btn-lg btn-block">Update User</button>
            </div>
        </form>

    </div>
</body>
</html>
