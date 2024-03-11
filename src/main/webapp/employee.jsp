<%@ page import="java.util.List" %>
<%@ page import="com.jetbrains.employeeapp.employee" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 07-03-2024
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Data</title>
</head>
<body>
<%! List<employee> list=null;%>
<%
    list = (List<employee>) request.getAttribute("list");
%>

<table border="black">
    <caption>Employee Details</caption>
    <th>Id</th>
    <th>Name</th>
    <th>City</th>
    <%
    for (employee e:list)
    {
    %>
    <tr>
        <td><%=e.getId()%></td>
        <td><%=e.getName()%></td>
        <td><%=e.getCity()%></td>
    </tr>
    <% }%>

</table>
<a href="index.html"><button>home</button></a>
</body>
</html>
