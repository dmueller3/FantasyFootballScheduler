<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <c:choose>
        <c:when test="${empty sessionScope.userName}">
            <a href = "logIn" class="loginlogout">Login</a>
        </c:when>
        <c:otherwise>
            <a href="logOut" class="loginlogout">Logout</a><p>   Welcome ${sessionScope.userName}</p>
        </c:otherwise>
    </c:choose>
    <h1><a href="index.jsp">Fantasy Football Scheduler</a></h1>
</div>
