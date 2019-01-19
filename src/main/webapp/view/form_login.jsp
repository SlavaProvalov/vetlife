<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>

    <spring:message code="label.login.title" var="title"/>
    <title>${title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>

<body>

<div>

    <div id="loginbox" style="margin-top: 50px;"
         class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

        <div class="panel panel-info">
            <spring:message code="label.language" var="lang"/>
            <spring:message code="label.dropdown.english" var="en"/>
            <spring:message code="label.dropdown.russian" var="ru"/>
            <div class="panel-heading">
               <span> <div class="panel-title"><spring:message code="message.info.signIn"/></div>
                   <div class="dropdown">
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                            ${lang}
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item"
                               href="<%=request.getContextPath()%>?locale=ru">${ru}</a>
                            <a class="dropdown-item"
                               href="<%=request.getContextPath()%>?locale=en">${en}</a>
                        </div>
                    </div>
                </span>
            </div>

            <div style="padding-top: 30px" class="panel-body">

                <!-- Login Form -->
                <form action="${pageContext.request.contextPath}/authenticateTheUser"
                      method="POST" class="form-horizontal">

                    <!-- Place for messages: error, alert etc ... -->
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>

                                <!-- Check for login error -->

                                <c:if test="${param.error != null}">

                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        <spring:message code="message.error.wrongLoginOrPassword"/>
                                    </div>

                                </c:if>

                                <!-- Check for logout -->

                                <c:if test="${param.logout != null}">

                                    <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                        <spring:message code="message.error.loggedOut"/>
                                    </div>

                                </c:if>

                            </div>
                        </div>
                    </div>
                    <spring:message code="message.info.login" var="username"/>
                    <!-- User name -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                        <input type="text" name="username" placeholder="${username}" class="form-control">
                    </div>

                    <spring:message code="message.info.password" var="password"/>
                    <!-- Password -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

                        <input type="password" name="password" placeholder="${password}" class="form-control">
                    </div>

                    <spring:message code="label.login.submit" var="submit"/>
                    <!-- Login/Submit Button -->
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-6 controls">
                            <button type="submit" class="btn btn-success">${submit}</button>
                        </div>
                    </div>

                    <!-- I'm manually adding tokens ... Bro! -->

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>

                </form>

            </div>

        </div>
        <spring:message code="message.info.signUp" var="signUp"/>
        <div>
            <a href="${pageContext.request.contextPath}/register/registrationForm" class="btn btn-primary" role="button"
               aria-pressed="true">${signUp}</a>
        </div>

    </div>

</div>

</body>

</html>
