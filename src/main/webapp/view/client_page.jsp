<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Client page</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/css/add-customer-style.css">

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Welcome ${client.firstName} ${client.lastName}</h2>
    </div>
</div>

<%--<div id="selector">--%>
    <%--Выбери кота: <sform:select path="dog">--%>
    <%--<sform:options items="${dogs}"/>--%>
<%--</sform:select>--%>
    <%--Выбери собаку: <sform:select path="cat">--%>
    <%--<sform:options items="${cats}"/>--%>
<%--</sform:select>--%>
<%--</div>--%>

<div id="container">
    <div id="content">

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
                <td></td>
                <td></td>

            </tr>
        </table>
    </div>
</div>


</body>
</html>
