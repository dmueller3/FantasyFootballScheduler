<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Enter Team Names" />
<c:import url="head.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <body>
      <main>
          <header>
              <c:import url="header.jsp" />
          </header>
        <h3>Enter Team Names</h3>
          <form action="enterNames" method="POST">
              <!-- used Ravi K Thapliyal's response to use sessionScope to get the team names
                  https://stackoverflow.com/questions/17419727/how-to-use-session-in-jsp-pages-to-get-information -->
              <label for="team1">Team 1</label>
              <select id="team1" name="team1">
                  <c:forEach var="team" items="${sessionScope.teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
              <br><br>
              <label for="team2">Team 2</label>
              <select id="team2" name="team2">
                  <c:forEach var="team" items="${teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
              <br><br>
              <label for="team3">Team 3</label>
              <select id="team3" name="team3">
                  <c:forEach var="team" items="${teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
              <br><br>
              <label for="team4">Team 4</label>
              <select id="team4" name="team4">
                  <c:forEach var="team" items="${teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
              <br><br>
              <label for="team5">Team 5</label>
              <select id="team5" name="team5">
                  <c:forEach var="team" items="${teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
              <br><br>
              <label for="team6">Team 6</label>
              <select id="team6" name="team6">
                  <c:forEach var="team" items="${teams}">
                      <option>${team.teamName}</option>
                  </c:forEach>
              </select>
              <br><br>
              <c:choose>
                  <c:when test="${sessionScope.numberOfTeams >= 8}">
                      <label for="team7">Team 7</label>
                      <select id="team7" name="team7">
                          <c:forEach var="team" items="${teams}">
                              <option>${team.teamName}</option>
                          </c:forEach>
                      </select>
                      <br><br>
                      <label for="team8">Team 8</label>
                      <select id="team8" name="team8">
                          <c:forEach var="team" items="${teams}">
                              <option>${team.teamName}</option>
                          </c:forEach>
                      </select>
                      <br><br>
                  </c:when>
              </c:choose>
              <c:choose>
                  <c:when test="${sessionScope.numberOfTeams >= 10}">
                      <label for="team9">Team 9</label>
                      <select id="team9" name="team9">
                          <c:forEach var="team" items="${teams}">
                              <option>${team.teamName}</option>
                          </c:forEach>
                      </select>
                      <br><br>
                      <label for="team10">Team 10</label>
                      <select id="team10" name="team10">
                          <c:forEach var="team" items="${teams}">
                              <option>${team.teamName}</option>
                          </c:forEach>
                      </select>
                      <br><br>
                  </c:when>
              </c:choose>
              <c:choose>
                  <c:when test="${sessionScope.numberOfTeams >= 12}">
                      <label for="team11">Team 11</label>
                      <select id="team11" name="team11">
                          <c:forEach var="team" items="${teams}">
                              <option>${team.teamName}</option>
                          </c:forEach>
                      </select>
                      <br><br>
                      <label for="team12">Team 12</label>
                      <select id="team12" name="team12">
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
