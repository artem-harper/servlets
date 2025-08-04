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
    <h1>Купленные билеты</h1>
    <ul>
        <b:forEach var="ticket" items="${requestScope.tickets}">
            <li>${fn:toLowerCase(ticket.seatNo)}</li>
        </b:forEach>
    </ul>
</body>
</html>
