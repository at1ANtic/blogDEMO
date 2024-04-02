<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.pojo.Article" %>
<%@ page import="com.example.mapper.ArticleMapper" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="java.io.InputStream" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文章列表</title>
    <style>
        .article-container {
            width: 60%;
            margin: 0 auto;
            text-align: center;
        }
        .article {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<h1>文章列表</h1>
<h2>Welcome, ${currentUser.username}!</h2>
<div>
    <button onclick="createNewArticle()">创建新文章</button>
</div>

<div class="article-container">
    <%
        try {
            // 加载mybatis的核心配置文件，获取SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取SqlSession对象，用它执行SQL
            SqlSession sqlSession = sqlSessionFactory.openSession();

            // 获取ArticleMapper接口的实例
            ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

            // 执行SQL
            List<Article> articles = articleMapper.selectArticle();

            // 输出查询结果
            for (Article article : articles) {
                out.println("<div class=\"article\">");
                out.println("<p>ID: " + article.getId() + "</p>");
                out.println("<p>标题: " + article.getTitle() + "</p>");
                out.println("<button onclick=\"editArticle(" + article.getId() + ")\">编辑</button>");
                out.println("<button onclick=\"deleteArticle(" + article.getId() + ")\">删除</button>");
                out.println("</div>");
            }

            // 释放 SqlSession
            sqlSession.close();

        } catch (Exception e) {
            // 处理异常
            out.println("发生错误：" + e.getMessage());
        }
    %>
</div>

<script>
    function createNewArticle() {
        // 实现跳转到创建新文章页面的逻辑
        window.location.href = "createArticle";
    }

    function editArticle(articleId) {
        // 实现编辑文章的逻辑，向后端发送请求
    }

    function deleteArticle(articleId) {
        // 实现删除文章的逻辑，向后端发送请求
    }
</script>

</body>
</html>
