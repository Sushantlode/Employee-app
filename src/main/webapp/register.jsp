<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 09-03-2024
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<h1>your not register please register</h1>
<form action="insert">
    <table>
        <tr>
            <td>
                ID
            </td>
            <td>
                <input type="text" name="id" id="id" required>
            </td>
        </tr>
        <tr>
            <td>
              username
            </td>
            <td>
                <input type="text" name="username" id="usrname" required>
            </td>
        </tr>
        <tr>
            <td>
                city
            </td>
            <td>
                <input type="text" name="city" id="city" required>
            </td>
        </tr>
        <tr>
            <td>
               password
            </td>
            <td>
                <input type="password" name="password" id="password" required>
            </td>
        </tr>
    </table>
    <input type="submit" value="Register">
</form>

</body>
</html>
