<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Schedule Results" />
<c:import url="head.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<header>
  <c:import url="header.jsp" />
</header>
<main>
  <h3>Schedule Generation Results</h3>
  <table style="border: 1px black">
    <c:forEach items="matchups" var="matchup">
      <tr>
        <td></td>
      </tr>
    </c:forEach>
  </table>
</main>
</body>
</html>

