<%--
  Created by IntelliJ IDEA.
  User: vinu_g
  Date: 10/24/2019
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        .split {
            height: 100%;
            width: 50%;
            position: fixed;
            z-index: 1;
            top: 0;
            overflow-x: hidden;
            padding-top: 20px;
        }

        /* Control the left side */
        .left {
            left: 0;
            background-color: #111;
        }

        /* Control the right side */
        .right {
            right: 0;
            background-color: white;
        }

        /* If you want the content centered horizontally and vertically */
        .centered {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }

        /* Style the image inside the centered container, if needed */
        .centered img {
            width: 150px;
            border-radius: 50%;
        }


        .demoForm {
            width: 575px;
            margin: auto;
        }

        .borderStyle {
            background-color:white;

            /*border-color: #FABC60;*/
            padding-top: 2%;
            padding-left: 2%;
            padding-right: 2%;
            padding-bottom: 2%;
            border-radius: 20px;

        }
    </style>
</head>
<body>

<%--    <div class="container">--%>

        <div class="split left">
            <div class="centered">
                <img src="<s:url value="/img_avatar2.jpg"/>" alt="Avatar">
            </div>
        </div>

        <div class="split right">
<%--            <div class="text-center">--%>
                <form class="demoForm borderStyle" action="login" modelAttribute="user" method="post">
                    <br><br>
                    <h2 class="text-center display-2">Sign In</h2>
                    <div class="form-group">
                        <label>Username : </label>
                        <input class="form-control" type="text" name="username" placeholder="Username"/>
                    </div>

                    <div class="form-group">
                        <label>Password : </label>
                        <input class="form-control" type="password" name="password" placeholder="********"/>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-warning btn-lg btn-block">Sign in</button>
                    </div>
                </form>
                <br>
                <form class="demoForm borderStyle" action="directToRegister" method="post">
                    <div class="form-group">
                        <button type="submit" class="btn btn-warning btn-lg btn-block">Sign up</button>
                    </div>
                </form>
<%--            </div>--%>
        </div>

<%--            <div class="col-sm-6">--%>

<%--                <br><br><br>--%>

<%--                <br><br><br> <br>--%>
<%--                <form action="login" modelAttribute="user" method="post">--%>

<%--                    <h2 class="text-center display-2">Sign In</h2>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Username : </label>--%>
<%--                        <input class="form-control" type="text" name="username" placeholder="Username"/>--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label>Password : </label>--%>
<%--                        <input class="form-control" type="password" name="password" placeholder="********"/>--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <button type="submit" class="btn btn-warning btn-lg btn-block">Sign in</button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--                <br><br>--%>
<%--                <form action="directToRegister" method="post">--%>
<%--                    <div class="form-group">--%>
<%--                        <button type="submit" class="btn btn-warning btn-lg btn-block">Sign up</button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

</body>
</html>
