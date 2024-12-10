<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Saved Schedule" />
<c:import url="head.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<main>
  <header>
    <c:import url="header.jsp" />
  </header>
  <h2>Previous Schedule Generation</h2>
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
</main>
</body>
</html>

