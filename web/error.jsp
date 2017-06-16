<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <script>
        function errorLogin() {

            {alert('Invalid login or password');}

        }
    </script>
</head>

<body onload="errorLogin()">

<form action="${pageContext.servletContext.contextPath}/login" method="post">

    <p> login <input type="text" name="login"></p>
    <p> password <input type="password" name="password"></p>

    <p><input type="submit" value="login"></p>

</form>

</body>
</html>
