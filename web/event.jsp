<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 04.06.2017
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>com.oleg.Controller.Event</title>
</head>
<body>

<form name="event" method=post action="Event">

    <td align="left" valign="top">
        <table>

            <table>
                <tr> Enter event name <br>
                    <input type="text" name="eventName" size="20" maxlength="100" placeholder="eventName"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> About event <br>
                    <input type="text" name="text" maxlength="1500" placeholder="about event" style="background: white">
                </tr>
            </table>

            <table> Select event type <select name="type" size="1">
                <option selected value="party"> Party
                <option value="concert"> Concert
                <option value="exhibition"> Exhibition
                <option value="meeting"> Meeting
            </select><br><br>
            </table>

            <table>
                <tr> City <br>
                    <input type="text" name="city" size="30" maxlength="50" placeholder="city"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Street <br>
                    <input type="text" name="street" size="30" maxlength="50" placeholder="street"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Building <br>
                    <input type="text" name="building" size="30" maxlength="50" placeholder="building"
                           style="background: white">
                </tr>
            </table>


            <table>
                <tr> Building index <br>
                    <input type="text" name="buildingIndex" size="30" maxlength="50" placeholder="buildingIndex"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Contact mobile phone (+375xxxхxxxхх) <br>
                    <input type="text" name="mobilePhone" size="30" maxlength="50" placeholder="mobilePhone"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Contact phone (+375xxxхxxxхх) <br>
                    <input type="text" name="phone" size="30" maxlength="50" placeholder="phone"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> com.oleg.Controller.Event start time <br>
                    <input type="time" name="eventStartTime" size="30" maxlength="50" placeholder="start time"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Date <br>
                    <input type="date" name="date" size="30" maxlength="50" placeholder="date"
                           style="background: white">
                </tr>
            </table>

            <input type="submit" value="send">

            <%--</td>--%>
            <%--</tr>--%>

        </table>

</form>
</body>
</html>
