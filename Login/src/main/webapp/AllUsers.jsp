<%@ page import="com.spring.model.User" %>
<%@ page import="com.spring.dao.UserDAO" %>
<%@ page import="com.spring.daoImp.UserDAOImp" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: vinu_g
  Date: 10/28/2019
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="display-1">All Available Users</h1>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#User ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">UserName</th>
                <th scope="col">Update User</th>
                <th scope="col">Delete User</th>
            </tr>
            </thead>
            <tbody>
            <%
                UserDAO userDao=new UserDAOImp();
                ArrayList<User> allUsers = userDao.retrieveUsers();
                int x =0;
                while(x<allUsers.size()){
                    User t = allUsers.get(x);
            %>
            <tr>
                <td><%=t.getUserId()%></td>
                <td><%=t.getFirstName()%></td>
                <td><%=t.getLastName()%></td>
                <td><%=t.getUsername()%></td>
                <td width="350px">
                    <form action="updateUser" modelAttribute="user" method="post">

                        <div class="input-group">
                            <input type="text" name="userId" value="<%=t.getUserId()%>" hidden>
                            <input type="text" name="firstName" value="<%=t.getFirstName()%>" hidden>
                            <input type="text" name="lastName" value="<%=t.getLastName()%>" hidden>
                            <input type="text" name="username" value="<%=t.getUsername()%>" hidden>
                                <input type="submit" class="btn"
                                               style=" text-align: center; font-weight: bold; color: #581845; background-color: white; width: 100px;" value="Update">
                        </div>

                    </form>

                </td>

                <td width="350px">
                    <form action="deleteUser" method="post">

                        <div class="input-group">
                            <input type="text" name="username" value="<%=t.getUsername()%>" hidden>

                            <input type="submit" class="btn"
                                   style="text-align: center; font-weight: bold; color: #FFBD08; background-color: white; width: 100px;"
                                   value="Delete">
                        </div>

                    </form>

                </td>
            </tr>
            <%
                    x++;
                }
            %>
            </tbody>
        </table>


    </div>


</body>
</html>
