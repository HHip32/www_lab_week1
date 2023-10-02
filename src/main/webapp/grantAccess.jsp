<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/02/2023
  Time: 02:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GrantAccess</title>
    <style>
        body {
            background-color: #f2f2f2;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            background-color: #fff;
            border: 2px solid #ccc;
            padding: 20px;
            width: 300px;
            margin: 0 auto;
            border-radius: 10px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Grant Access</h1>
<form action="control?action=grantAccess" method="post">
    <label for="accountID">AccountID:</label>
    <input type="text" id="accountID" name="accountID" value="${accountIDForGrantAccess}" readonly><br>

    <label for="role">Role:</label>
    <input type="text" id="role" name="role" required><br>

    <label for="role">IsGrant:</label>
    <input type="text" id="isGrant" name="isGrant" value="1" readonly><br>

    <input type="submit" value="Add">
</form>
</body>
</html>
