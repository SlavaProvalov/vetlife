<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Clients here</title>
</head>
<body>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Middle name</th>
        <th>City</th>
        <th>Street</th>
        <th>House number</th>
        <th>Apartment number</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Description</th>
        <th>Date of Registration</th>

    </tr>

    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.firstName}</td>
            <td>${client.lastName}</td>
            <td>${client.middleName}</td>
            <td>${client.city}</td>
            <td>${client.street}</td>
            <td>${client.houseNumber}</td>
            <td>${client.apartmentNumber}</td>
            <td>${client.phone}</td>
            <td>${client.email}</td>
            <td>${client.description}</td>
            <td>${client.dateOfRegistration}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
