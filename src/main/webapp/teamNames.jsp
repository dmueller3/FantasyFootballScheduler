<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Enter Team Names" />
<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <body>
      <header>
        <h1>Fantasy Football Scheduler</h1>
      </header>
      <main>
        <h3>Enter Team Names</h3>
        <label for="team1">Team 1</label>
        <select id="team1" name="team1">
          <c:forEach var="team" items="${teams}">
            <option>${team.teamName}</option>
          </c:forEach>
        </select>
          <p>Don't see a team name? </p><a href="">Add a team</a>
      </main>
  </body>
</html>
