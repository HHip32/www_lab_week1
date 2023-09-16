<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09/16/2023
  Time: 09:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://xmlns.jcp.org/jsp/jstl/core" %>--%>


<html>
<head>
    <title>Quản lý tài khoản</title>
    <style>
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

        .edit-input {
            width: 100%;
            border: none;
        }

        .button-container {
            text-align: right;
            margin-right: 20px;
        }

        .button-container button {
            padding: 10px 20px;
            margin-left: 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            background-color: #007BFF;
            color: #fff;
        }

        .button-container button.logout-button .add-button {
            float: right;
        }

        /* .button-container button.add-button {
            float: right;
        } */
    </style>
</head>

<body>
<h1>Quản lý người dùng</h1>
<table>
    <thead>
    <tr>
        <th>Account ID</th>
        <th>Full Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="acc" items="${accounts}">
        <tr>
            <td>${acc.accountId}</td>
            <td>${acc.fullName}</td>
            <td>${acc.password}</td>
            <td>${acc.email}</td>
            <td>${acc.phone}</td>
            <td>${acc.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="button-container">
    <button onclick="" class="add-button">Thêm quyền</button>
    <button onclick="">Xóa quyền</button>
    <button onclick="">Chỉnh sửa</button>
    <button onclick="" class="logout-button">Thoát</button>
</div>

</body>
</html>
