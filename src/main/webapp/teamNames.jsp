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
          <form action="${pageContext.request.contextPath}/enterNames" method="POST">
                <c:choose>
                    <c:when test="${numberOfTeams} = 6">

                    </c:when>
                </c:choose>
          </form>

          <p>Don't see a team name? </p><a href="">Add a team</a>
      </main>
  </body>
</html>
