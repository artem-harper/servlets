<%@ page import="org.example.dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.service.TicketService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Список перелетов</h1>
    <ul>
        <b:forEach var="flight" items="${requestScope.flights}">
            <li>
                <a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}">${flight.description}</a>
            </li>
        </b:forEach>
    </ul>
</body>
</html>
