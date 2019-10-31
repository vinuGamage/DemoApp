<%--
  Created by IntelliJ IDEA.
  User: vinu_g
  Date: 10/28/2019
  Time: 8:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">
        <br><br><br>
        <h2 class="display-2">Register Now!!</h2>
        <br><br>
        <form action="processRegister" modelAttribute="user" method="post">
            <div class="form-group">
                <label>First Name : </label>
                <input class="form-control" type="text" name="firstName" placeholder="First Name"/>
            </div>

            <div class="form-group">
                <label>Last Name : </label>
                <input class="form-control" type="text" name="lastName" placeholder="Last Name"/>
            </div>

            <div class="form-group">
                <label>Username : </label>
                <input class="form-control" type="text" name="username" placeholder="Username"/>
            </div>

            <div class="form-group">
                <label>Password : </label>
                <input class="form-control" type="password" name="password" placeholder="********"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-warning btn-lg btn-block">Sign up</button>
            </div>
        </form>
    </div>

</body>
</html>
