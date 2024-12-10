<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Saved Schedules" />
<c:import url="head.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<main>
  <header>
    <c:import url="header.jsp" />
  </header>
  <h2>Schedule Generation Results</h2>
  <c:choose>
    <c:when test="${empty scheduleDetails}">
      <h3>No saved schedules for the logged in user :(</h3>
    </c:when>
    <c:otherwise>
      <ul>
        <c:forEach var="schedule" items="${scheduleDetails}">
          <li>${schedule}</li>
        </c:forEach>
      </ul>
    </c:otherwise>
  </c:choose>
</main>
</body>
</html>

