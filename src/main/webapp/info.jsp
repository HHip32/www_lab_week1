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
    <title>Thông tin tài khoản</title>
</head>
<body>
<h1 style="text-align: center;">Thông tin tài khoản</h1>
<p>Id: ${account.accountId}</p>
<p>Fullname: ${account.fullName}</p>
<p>Password: ${account.password}</p>
<p>Email: ${account.email}</p>
<p>Phone: ${account.phone}</p>
<p>Status: ${account.status}</p>
<p>Role: ${grantAccess.roleId.roleId}</p>
</body>
</html>
