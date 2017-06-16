<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 16.06.2017
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>

</head>
<body>

<form action="${pageContext.servletContext.contextPath}/login" method="post">

    <p> login <input type="text" name="login"></p>
    <p> password <input type="password" name="password"></p>

    <p><input type="submit" value="login"></p>


</form>

</body>
</html>
