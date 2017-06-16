<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
</head>
<body>

<form name="user" method="post" action="/addUser">

    <td align="left" valign="top">
        <table>

            <table>
                <tr> Nickname <br>
                    <input type="text" name="nickname" size="30" maxlength="100" placeholder="nickname"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> First Name <br>
                    <input type="text" name="firstName" size="30" maxlength="100" placeholder="First Name" style="background: white">
                </tr>
            </table>

            <table>
                <tr> Second Name <br>
                    <input type="text" name="secondName" size="30" maxlength="100" placeholder="Second Name" style="background: white">
                </tr>
            </table>

            <table>
                <tr> Password <br>
                    <input type="password" name="password" size="30" maxlength="100" placeholder="password"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Email <br>
                    <input type="email" name="email" size="30" maxlength="255" placeholder="email"
                           style="background: white">
                </tr>
            </table>

            <input type="submit" value="Add user">

        </table>

</form>
</body>
</html>
