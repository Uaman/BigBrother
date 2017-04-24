<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="frame" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body class="other">
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>

<div id="main-content" class="container">
    <div class="col-md-6">
        <h2>Registration page</h2>
        <br/>



    </div>
    <div class="col-md-6">
        <br/>
        <form:form class="form-horizontal" id="user" action="/register" method="post"
                   commandName="user">
            <div class="form-group">
                <div class="input-group">
                    <form:input type="text" class="form-control" placeholder="Введіть login" path="login"/>
                </div><!-- /input-group -->
            </div>
            <div class="form-group">
                <div class="input-group">
                    <form:input type="password" class="form-control" placeholder="Введіть password" path="password"/>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <input type="password" id="confirm_pass" name="confirm_pass" class="form-control" placeholder="Підтвердіть password" />
                </div>
            </div>
            <div class="form-group">
                    <span class="input-group-btn">
                        <button id="btn" class="btn btn-default" type="submit">Sign up</button>
                    </span>
            </div>


        </form:form>


    </div>
</div>

</body>
</html>
