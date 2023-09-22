<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Form Đăng Nhập</title>
  <!-- Sử dụng Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-pzjw8f+ua6IoBfS30XTR5hBTEi6dOoYDx0r6jZc4l5tsYqN7t4dF5p4m0zjc5CKf" crossorigin="anonymous">
  <!-- Tùy chỉnh CSS -->
  <style>
    body {
      background-color: #f8f9fa;
    }

    .login-container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #ffffff;
      box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
      border-radius: 5px;
    }
  </style>
</head>
<body>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="login-container">
        <h2 class="mb-4">Đăng Nhập</h2>
        <form action="control?action=login" method="POST">
<%--          <input type="hidden" name="action" value="login">--%>
          <div class="mb-3">
            <label for="username" class="form-label">Tài khoản</label>
            <input type="text" class="form-control" id="username" name="username" required>
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" id="password" name="password" required>
          </div>
          <button type="submit" class="btn btn-primary">Đăng nhập</button>
        </form>
      </div>
    </div>
  </div>
</div>
<!-- Sử dụng Bootstrap 5 JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYlT" crossorigin="anonymous"></script>
</body>
</html>