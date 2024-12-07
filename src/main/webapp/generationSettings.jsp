<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Generation Settings" />
<c:import url="head.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <header>
            <c:import url="header.jsp" />
        </header>
        <main>
            <form name="settingsForm" action="generationSettings" method="POST">
                <h3>Number of Teams</h3>
                <fieldset>
                    <input type="radio" user_id="sixTeams" value="6" name="numberTeams" checked="checked">
                    <label for="sixTeams">6</label>
                    <input type="radio" user_id="eightTeams" value="8" name="numberTeams">
                    <label for="eightTeams">8</label>
                    <input type="radio" user_id="tenTeams" value="10" name="numberTeams">
                    <label for="tenTeams">10</label>
                    <input type="radio" user_id="twelveTeams" value="12" name="numberTeams">
                    <label for="twelveTeams">12</label>
                </fieldset>
                <h3>Number of Weeks in Regular Season</h3>
                <fieldset>
                    <input type="radio" user_id="thirteenWeeks" value="13" name="numberWeeks" checked="checked">
                    <label for="thirteenWeeks">13</label>
                    <input type="radio" user_id="fourteenWeeks" value="14" name="numberWeeks">
                    <label for="fourteenWeeks">14</label>
                    <input type="radio" user_id="fifteenWeeks" value="15" name="numberWeeks">
                    <label for="fifteenWeeks">15</label>
                    <input type="radio" user_id="sixteenWeeks" value="16" name="numberWeeks">
                    <label for="sixteenWeeks">16</label>
                </fieldset>
                <h3>Weeks before a matchup can be repeated (must be LESS THAN number of teams)</h3>
                <label for="frequencyPlayed">Frequency: </label>
                <input type="text" user_id="frequencyPlayed" name="frequencyPlayed" required>
                <br><br>
                <input type="submit" value="Submit">
            </form>
        </main>
    </body>
</html>
