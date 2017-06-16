<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EVENT</title>
</head>
<body>
<form name="event" method="post" action="/addEvent">

    <td align="left" valign="top">
        <table>

            <table>
                <tr> Enter event name <br>
                    <input type="text" name="eventName" size="100" maxlength="100" placeholder="eventName"
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
                    <input type="text" name="city" size="100" maxlength="100" placeholder="city"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Street <br>
                    <input type="text" name="street" size="100" maxlength="100" placeholder="street"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Building <br>
                    <input type="text" name="building" size="50" maxlength="20" placeholder="building"
                           style="background: white">
                </tr>
            </table>


            <table>
                <tr> Building index <br>
                    <input type="text" name="buildingIndex" size="50" maxlength="20" placeholder="buildingIndex"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Contact mobile phone (+375xxxхxxxхх) <br>
                    <input type="text" name="mobilePhone" size="50" maxlength="20" placeholder="mobilePhone"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Contact phone (+375xxxхxxxхх) <br>
                    <input type="text" name="phone" size="50" maxlength="20" placeholder="phone"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Start time <br>
                    <input type="time" name="eventStartTime" size="50" maxlength="50" placeholder="start time"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Date <br>
                    <input type="date" name="date" size="50" maxlength="50" placeholder="date"
                           style="background: white">
                </tr>
            </table>

            <input type="submit" value="Add event">

        </table>

</form>
</body>
</html>
