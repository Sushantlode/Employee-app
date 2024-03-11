<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 10-03-2024
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<h1>Login Successful</h1>
<form action="index.html">
    <h1>Welcome, <%= session.getAttribute("username") %></h1>
    <table border="black">
        <thead>
        <tr>
            <th>
                <h3><%= session.getAttribute("username") %> Details</h3>
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <h3>id:</h3>
            </td>
            <td>
                <h3><%= session.getAttribute("id") %></h3>
            </td>
        </tr>
        <tr>
            <td>
                <h3>username</h3>
            </td>
            <td>
                <h3><%= session.getAttribute("username") %></h3>
            </td>
        </tr>
        <tr>
            <td>
                <h3>city</h3>
            </td>
            <td>
                <h3><%= session.getAttribute("city") %></h3>
            </td>
        </tr>
        <tr>
            <td>
                <h3>password</h3>
            </td>
            <td>
                <h3><%= session.getAttribute("password") %></h3>
            </td>
        </tr>

        </tbody>
    </table>
    <button type="submit">sign out</button>
    <input type='button' value='Go back!' onclick='history.back()'>

</form>
<a href="profilehome.jsp"><button>home</button></a>
</body>
</html>