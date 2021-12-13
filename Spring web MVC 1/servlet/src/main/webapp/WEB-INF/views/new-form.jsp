<%--
  Created by IntelliJ IDEA.
  User: lim
  Date: 2021-06-23
  Time: 오후 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<%--    보통은 절대경로로 하는게 더 좋을 것임--%>
    <form action="save" method="post">
        username: <input type="text" name="username" />
        age: <input type="text" name="age" />
        <button type="submit">전송</button>
    </form>
</body>
</html>
