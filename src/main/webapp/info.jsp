<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09/14/2023
  Time: 02:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management</title>
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
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #f2f2f2;
            color: #fff;
            text-align: center;
            padding: 10px;
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

        button {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #555;
        }

        .logout-button {
            display: block;
            margin-top: 20px;
            text-align: center;
        }
        .logout-link {
            text-decoration: none;
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
        }

        .logout-link:hover {
            background-color: #555;
        }
    </style>
</head>
<div class="navbar">
    <a href="info.jsp">Trang Chủ</a>
<%--    <a href="control?action=listRole">Role</a>--%>
    <a href="control?action=listRoleOfUser">Role</a>
</div>
<body>
<header>
    <h1>Thông tin tài khoản</h1>
</header>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Fullname</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
        <th>Role</th>
    </tr>
    </thead>

    <tbody>
    <!-- Thêm dữ liệu cho bảng ở đây -->
    <tr>
        <td>${accountLogin.accountId}</td>
        <td>${accountLogin.fullName}</td>
        <td>${accountLogin.password}</td>
        <td>${accountLogin.email}</td>
        <td>${accountLogin.phone}</td>
        <td>${accountLogin.status}</td>
        <td>${grantAccess.roleId.roleId}</td>
    </tr>
    </tbody>
</table>
<div class="logout-button" >
    <a  class="logout-link" href="control?action=logout">Thoát</a>
</div>
</body>
</html>
