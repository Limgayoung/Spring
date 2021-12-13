<%--
  Created by IntelliJ IDEA.
  User: lim
  Date: 2021-06-21
  Time: 오후 10:59
  To change this template use File | Settings | File Templates.
--%>
<%--jsp는 이 줄이 꼭 있어야 함--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/jsp/members/save.jsp" method="post">
        username: <input type="text" name="username" />
        age: <input type="text" name="age" />
        <button type="submit">전송</button>
    </form>
</body>
</html>
