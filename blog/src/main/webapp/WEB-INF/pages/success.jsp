<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>congratulations！</h1>

<c:forEach items="${}" var="movie">
    ${movie.id}-
    ${movie.name}-
    ${movie.director}-
    ${movie.director}<br>

</c:forEach>

</body>
</html>