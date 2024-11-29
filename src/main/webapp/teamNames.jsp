<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Enter Team Names" />
<c:import url="head.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <body>
    <header>
        <c:import url="header.jsp" />
    </header>
      <main>
        <h3>Enter Team Names</h3>
          <form action="${pageContext.request.contextPath}/enterNames" method="POST">
              <label for="team1">Team 1</label>
              <select id="team1" name="team1">
                  <!-- used Ravi K Thapliyal's response to use sessionScope to get the team names
                  https://stackoverflow.com/questions/17419727/how-to-use-session-in-jsp-pages-to-get-information -->
                  <c:forEach var="team" items="${sessionScope.teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
              <label for="team2">Team 2</label>
              <select id="team2" name="team2">
                  <c:forEach var="team" items="${teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
              <label for="team3">Team 3</label>
              <select id="team3" name="team3">
                  <c:forEach var="team" items="${teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
              <label for="team4">Team 4</label>
              <select id="team4" name="team4">
                  <c:forEach var="team" items="${teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
                <c:choose>
                    <c:when test="${sessionScope.numberOfTeams} == 6">
                        <label for="team5">Team 5</label>
                        <select id="team5" name="team5">
                            <c:forEach var="team" items="${teams}">
                                <option>${team.teamName}</option>
                            </c:forEach>
                        </select>
                        <label for="team6">Team 6</label>
                        <select id="team6" name="team6">
                            <c:forEach var="team" items="${teams}">
                                <option>${team.teamName}</option>
                            </c:forEach>
                        </select>
                    </c:when>
                </c:choose>
              <br><br>
              <input type="submit" value="Submit">
          </form>

          <p>Don't see a team name? </p><a href="addTeam.jsp">Add a team</a>
      </main>
  </body>
</html>
