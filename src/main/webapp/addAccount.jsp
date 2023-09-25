<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09/25/2023
  Time: 01:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Tài Khoản</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            padding: 10px; /* Thêm padding vào form */
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            font-weight: bold;
            color: #333;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="tel"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .btn {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Thêm Tài Khoản</h1>
    <form action="control?action=addAccount" method="post">
        <div class="form-group">
            <label for="AccountID">AccountID</label>
            <input type="text" id="AccountID" name="AccountID" required>
        </div>
        <div class="form-group">
            <label for="Fullname">Fullname</label>
            <input type="text" id="Fullname" name="Fullname" required>
        </div>
        <div class="form-group">
            <label for="Password">Password</label>
            <input type="password" id="Password" name="Password" required>
        </div>
        <div class="form-group">
            <label for="Email">Email</label>
            <input type="email" id="Email" name="Email" required>
        </div>
        <div class="form-group">
            <label for="Phone">Phone</label>
            <input type="tel" id="Phone" name="Phone" required>
        </div>
        <div class="form-group">
            <button type="submit" class="btn">Thêm</button>
        </div>
    </form>
</div>
</body>
</html>
