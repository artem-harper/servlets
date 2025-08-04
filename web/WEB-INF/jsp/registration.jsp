<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 02.08.2025
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
    <label for="name">Name:
        <input type="text" name="name" id="name">
    </label><br>
    <label for="birthday">Birthday:
        <input type="date" name="birthday" id="birthday">
    </label><br>
    <label for="email">Email:
        <input type="email" name="email" id="email">
    </label><br>
    <label for="password">Password:
        <input type="password" name="password" id="password">
    </label><br>
    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">
                    ${role}
            </option>
        </c:forEach>
    </select><br>

    <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value="${gender}"> ${gender}
    </c:forEach>

    <br>
    <button type="submit">
        Send
    </button>
    <div>
        <c:if test="${not empty requestScope.errors}">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span>
            </c:forEach>
        </c:if>
    </div>
</form>
</body>
</html>
