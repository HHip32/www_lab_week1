<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09/22/2023
  Time: 05:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vn.edu.iuh.fit.models.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Role của accounts</title>
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
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 20px auto;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .table-container {
            display: flex;
            flex-direction: column; /* Hiển thị bảng và dòng chữ theo chiều dọc */
            margin-top: 20px;
        }

        .table {
            background-color: #fff;
            border-collapse: collapse;
            margin-top: 10px; /* Thêm khoảng cách giữa bảng và dòng chữ */
        }

        .table th,
        .table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        .table th {
            background-color: #007BFF;
            color: white;
        }

        .table tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<div class="navbar">
    <a href="control?action=informationOfUser">Trang Chủ</a>
    <a href="roleUser.jsp">Role</a>
</div>
<body>
<div class="container">
    <div class="table-container">
        <table class="table">
            <thead>
            <tr>
                <th>Role ID</th>
                <th>Role Name</th>
                <th>Description</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <td>${role.roleId}</td>
            <td>${role.roleName}</td>
            <td>${role.description}</td>
            <td>${role.status}</td>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
