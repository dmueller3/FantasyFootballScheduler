<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Add a Team" />
<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<header>
    <h1>Fantasy Football Scheduler</h1>
</header>
<main>
    <h3>The following team was added</h3>

    <h4>Team Name</h4>
    <p>${teamName}</p>
    <h4>Team Owner</h4>
    <p>${teamOwner}</p>

    <form action="addTeam.jsp">
        <input type="submit" value="Add another team">
    </form>

    <a href="index.jsp">Back to the homepage</a>
</main>
</body>
</html>