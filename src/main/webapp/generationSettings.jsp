<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Generation Settings" />
<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <header>
            <h1>Fantasy Football Scheduler</h1>
        </header>
        <main>
            <form name="settingsForm" action="${pageContext.request.contextPath}/generationSettings" method="POST">
                <h3>Number of Teams</h3>
                <fieldset>
                    <input type="radio" id="fourTeams" value="4" name="numberTeams" checked="checked">
                    <label for="fourTeams">4</label>
                    <input type="radio" id="sixTeams" value="6" name="numberTeams">
                    <label for="sixTeams">6</label>
                    <input type="radio" id="eightTeams" value="8" name="numberTeams">
                    <label for="eightTeams">8</label>
                    <input type="radio" id="tenTeams" value="10" name="numberTeams">
                    <label for="tenTeams">10</label>
                </fieldset>
                <h3>Number of Weeks in Regular Season</h3>
                <fieldset>
                    <input type="radio" id="thirteenWeeks" value="13" name="numberWeeks" checked="checked">
                    <label for="thirteenWeeks">13</label>
                    <input type="radio" id="fourteenWeeks" value="14" name="numberWeeks">
                    <label for="fourteenWeeks">14</label>
                    <input type="radio" id="fifteenWeeks" value="15" name="numberWeeks">
                    <label for="fifteenWeeks">15</label>
                    <input type="radio" id="sixteenWeeks" value="16" name="numberWeeks">
                    <label for="sixteenWeeks">16</label>
                </fieldset>
                <h3>How Often 2 Teams Can Play Each Other</h3>
                <label for="frequencyPlayed">Frequency: </label>
                <input type="text" id="frequencyPlayed" name="frequencyPlayed" value="4" required>
                <br><br>
                <input type="submit" value="Submit">
                <input type="reset" value="Clear fields">
            </form>
        </main>
    </body>
</html>
