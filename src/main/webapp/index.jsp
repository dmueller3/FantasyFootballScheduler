<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Fantasy Football Scheduler - Home" />
<%@include file="head.jsp"%>
<html>
    <body>
        <header>
            <c:choose>
                <c:when test="${empty userName}">
                    <a href = "logIn">Login</a>
                </c:when>
                <c:otherwise>
                    <a href="#">Logout</a>
                </c:otherwise>
            </c:choose>
            <h1>Fantasy Football Scheduler</h1>
        </header>
        <main>
            <a href="generationSettings.jsp">Generate a Schedule</a>
            <a href="#">Schedule History</a>
            <h3>How to Use the Fantasy Football Scheduler</h3>
            <p>The Fantasy Football Scheduler application allows you to generate randomized schedules for your NFL Fantasy Football leagues. To use this application, start by either logging in, or clicking 'Generate Schedule'. You will then be prompted to enter the number of teams in your league, number of weeks in the regular season, and matchup frequency. Using these inputs, the application will then generate a random schedule for you, and you will either be able to regenerate another schedule, or save the schedule (requires login). For users who have an account, they will be able to view their previous schedule generations.</p>
            <p><i>Created by Derek Mueller - 2024</i></p>
        </main>
    </body>
</html>
