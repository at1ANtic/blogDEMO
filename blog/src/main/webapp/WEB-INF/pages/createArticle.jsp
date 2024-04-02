<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.service.ArticleService" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Article</title>
</head>
<body>

<h1>Create New Article</h1>

<form method="post" action="createArticle.jsp">
    <label for="title">Title:</label><br>
    <input type="text" id="title" name="title"><br><br>

    <label for="content">Content:</label><br>
    <textarea id="content" name="content" rows="10" cols="50"></textarea><br><br>

    <input type="submit" value="Create Article">
</form>

<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        ArticleService articleService = new ArticleService();
        int result = articleService.newArticle(title, content);

        if (result > 0) {
            out.println("<p>文章创建成功！</p>");
        } else {
            out.println("<p>文章创建失败。</p>");
        }
    }
%>

</body>
</html>
