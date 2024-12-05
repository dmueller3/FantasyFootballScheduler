<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <c:choose>
        <c:when test="${empty userName}">
            <a href = "logIn" class="loginlogout">Login</a>
        </c:when>
        <c:otherwise>
            <a href="#" class="loginlogout">Logout</a><p>   Welcome ${userName}</p>
        </c:otherwise>
    </c:choose>
    <h1><a href="index.jsp">Fantasy Football Scheduler</a></h1>
</div>
