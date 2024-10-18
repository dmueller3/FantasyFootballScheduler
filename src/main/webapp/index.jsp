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
            <p>To use this application...</p>
        </main>
    </body>
</html>
