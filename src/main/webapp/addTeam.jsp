<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Add a Team" />
<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<header>
    <c:import url="header.jsp" />
</header>
<main>
    <h3>Add a Team</h3>
    <form action="addTeamServlet" method="POST">
        <label for="teamName">Team Name</label>
        <input type="text" id="teamName" name="teamName" required/><br>
        <br>
        <label for="teamOwner">Team Owner</label>
        <input type="text" id="teamOwner" name="teamOwner" required/><br>
        <br>
        <input type="submit" value="Add Team" />
    </form>
</main>
</body>
</html>