<%@ page import="vn.edu.iuh.fit.models.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09/16/2023
  Time: 09:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>


<html>
<head>
    <title>Quản lý tài khoản</title>
    <style>
        .navbar {
            background-color: #007BFF; /* Màu nền của thanh navbar */
            overflow: hidden;
        }

        .navbar a {
            float: left;
            display: block;
            color: white; /* Màu chữ của liên kết */
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #0056b3; /* Màu nền khi di chuột qua liên kết */
        }
        body {
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #fff;
            border: 1px solid #ddd;
            margin-bottom: 20px;
        }

        th,
        td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .button-container {
            text-align: right;
            margin-right: 20px;
        }

        .button-container button, .button-container .logout-button {
            padding: 10px 20px;
            margin-left: 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            background-color: #007BFF;
            color: #fff;
            text-decoration: none; /* Thêm điều này để loại bỏ gạch chân trên liên kết */
            display: inline-block; /* Thêm điều này để liên kết hiển thị như một nút */
        }

        .button-container button:hover, .button-container .logout-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<div class="navbar">
    <a href="dashboard.jsp">Trang Chủ</a>
    <a href="control?action=listRole">Role</a>
</div>
<body>
<h1>Chào admin ${accountLogin.fullName}</h1>
<h3>Quản lý người dùng</h3>
<table>
    <thead>
    <tr>
        <th>Account ID</th>
        <th>Full Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <%
//        Account acc = (Account) request.getAttribute("accountLogin");
        List<Account> listAccount = (List<Account>) session.getAttribute("accounts");
    %>
    <%
        for(Account acc1 : listAccount){
    %>
    <tr>
        <td><%=acc1.getAccountId()%></td>
        <td><%=acc1.getFullName()%></td>
        <td><%=acc1.getPassword()%></td>
        <td><%=acc1.getEmail()%></td>
        <td><%=acc1.getPhone()%></td>
        <td><%=acc1.getStatus()%></td>
        <td><a href="control?action=delete&id=<%=acc1.getAccountId()%>">delete</a></td>
        <td><a href="control?action=update&id=<%=acc1.getAccountId()%>">update</a></td>
        <td><a href="control?action=grant&id=<%=acc1.getAccountId()%>">access</a></td>
    </tr>
    <%}%>

    </tbody>
</table>

<div class="button-container">
    <a class="logout-button" href="addAccount.jsp">Add Account</a>
    <a class="logout-button" href="control?action=logout">Logout</a>
</div>

</body>
</html>
