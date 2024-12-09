<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Schedule Results" />
<c:import url="head.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<main>
  <header>
    <c:import url="header.jsp" />
  </header>
  <h2>Schedule Generation Results</h2>
  <table>
    <c:forEach var="week" items="${schedule}" varStatus="weekNumber">
      <tr>
        <td>Week ${weekNumber.index + 1}</td>
        <c:forEach var="matchup" items="${week}">
          <td>${matchup}</td>
        </c:forEach>
      </tr>
    </c:forEach>
  </table>
  <div id="generationOptionsButtons">
    <!-- Regenerate the schedule with the same settings and teams -->
    <form action="enterNames">
      <input type="submit" value="Regenerate Schedule">
    </form>
    <c:choose>
      <c:when test="${not empty userName}">
        <form action="addSchedule">
          <input type="submit" value="Save Schedule">
        </form>
      </c:when>
    </c:choose>
  </div>
</main>
</body>
</html>

