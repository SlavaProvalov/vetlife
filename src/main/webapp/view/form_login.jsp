<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/css/add-customer-style.css">

    <style>
        .error{
            color: red;
            font-style: italic;
        }
    </style>

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Log In</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>

    <sform:form action="login" modelAttribute="user" method="POST">
        <table>
            <tbody>
            <tr>
                <td>
                    <label>Login:</label>
                </td>
                <td>
                    <sform:input path="login"/>
                    <sform:errors path="login" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td>
                    <sform:input path="password"/>
                    <sform:errors path="password" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Log In" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </sform:form>
</div>
</body>
</html>
