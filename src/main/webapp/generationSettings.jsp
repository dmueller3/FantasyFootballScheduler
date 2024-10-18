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
            <form name="settingsForm" action="enterNames">
                <h3>Number of Teams</h3>
                <fieldset>
                    <input type="radio" id="fourTeams" value="fourTeams" name="numberTeams">
                    <label for="fourTeams">4</label>
                    <input type="radio" id="sixTeams" value="sixTeams" name="numberTeams">
                    <label for="sixTeams">6</label>
                    <input type="radio" id="eightTeams" value=eightTeams" name="numberTeams">
                    <label for="eightTeams">8</label>
                    <input type="radio" id="tenTeams" value="tenTeams" name="numberTeams">
                    <label for="tenTeams">10</label>
                </fieldset>
                <h3>Number of Weeks in Regular Season</h3>
                <fieldset>
                    <input type="radio" id="thirteenWeeks" value="thirteenWeeks" name="numberWeeks">
                    <label for="thirteenWeeks">13</label>
                    <input type="radio" id="fourteenWeeks" value="fourteenWeeks" name="numberWeeks">
                    <label for="fourteenWeeks">14</label>
                    <input type="radio" id="fifteenWeeks" value=fifteenWeeks" name="numberWeeks">
                    <label for="fifteenWeeks">15</label>
                    <input type="radio" id="sixteenWeeks" value="sixteenWeeks" name="numberWeeks">
                    <label for="sixteenWeeks">16</label>
                </fieldset>
                <h3>How Often 2 Teams Can Play Each Other</h3>
                <label for="frequencyPlayed">Frequency: </label>
                <input type="text" id="frequencyPlayed" name="frequencyPlayed">
                <br><br>
                <input type="submit" value="Submit form">
                <input type="reset" value="Clear fields">
            </form>
        </main>
    </body>
</html>
