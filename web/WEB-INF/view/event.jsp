<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EVENT</title>
</head>
<body>
<form name="eventEntity" method="post" action="/addEvent">

    <td align="left" valign="top">
        <table>

            <table>
                <tr> Enter eventEntity name <br>
                    <input type="text" name="eventName" size="30" maxlength="100" placeholder="eventName"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> About eventEntity <br>
                    <input type="text" name="text" size="30" maxlength="1500" placeholder="about eventEntity" style="background: white">
                </tr>
            </table>

            <table> Select eventEntity type <select name="type" size="1">
                <option selected value="party"> Party
                <option value="concert"> Concert
                <option value="exhibition"> Exhibition
                <option value="meeting"> Meeting
            </select><br><br>
            </table>

            <table>
                <tr> City <br>
                    <input type="text" name="city" size="30" maxlength="100" placeholder="city"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Street <br>
                    <input type="text" name="street" size="30" maxlength="100" placeholder="street"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Building <br>
                    <input type="text" name="building" size="30" maxlength="20" placeholder="building"
                           style="background: white">
                </tr>
            </table>


            <table>
                <tr> Building index <br>
                    <input type="text" name="buildingIndex" size="30" maxlength="20" placeholder="buildingIndex"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Contact mobile phone (+375xxxхxxxхх) <br>
                    <input type="text" name="mobilePhone" size="30" maxlength="20" placeholder="mobilePhone"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Contact phone (+375xxxхxxxхх) <br>
                    <input type="text" name="phone" size="30" maxlength="20" placeholder="phone"
                           style="background: white">
                </tr>
            </table>

            <table>
                <tr> Start time <br>
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

            <input type="submit" value="Add eventEntity">

        </table>

</form>
</body>
</html>
