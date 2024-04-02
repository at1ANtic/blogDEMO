<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<% if (request.getParameter("error") != null) { %>
<p style="color: red;">Invalid adminname or adminpassword!</p>
<% } %>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="adminname">Adminname:</label>
    <input type="text" id="adminname" name="adminname"><br>
    <label for="adminpassword">Adminpassword:</label>
    <input type="password" id="adminpassword" name="adminpassword"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        /* 样式可以根据需要自行修改 */
        .login-container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .login-form {
            display: flex;
            flex-direction: column;
        }

        .login-form label {
            margin-bottom: 10px;
        }

        .login-form input[type="text"],
        .login-form input[type="password"] {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .login-form input[type="submit"] {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .login-form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <% if (request.getParameter("error") != null) { %>
    <p class="error-message">Invalid adminname or adminpassword!</p>
    <% } %>
    <form class="login-form" action="${pageContext.request.contextPath}/login" method="post">
        <label for="adminname">Adminname:</label>
        <input type="text" id="adminname" name="adminname"><br>
        <label for="adminpassword">Adminpassword:</label>
        <input type="password" id="adminpassword" name="adminpassword"><br>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>

