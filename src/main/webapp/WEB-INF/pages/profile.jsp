<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <h2>Список спостереження</h2>
        <br/>

        <c:forEach var="spiedUser" items="${SpiedUsers}">
            <div class="media">
                <!--div class="media-left">
                    <a href="#">
                        <img class="media-object" src="<c:url value="/resources/img/avatar.png"/>" alt="..." >
                    </a>
                </div-->
                <div class="media-body">
                    <a href="https://vk.com/id${spiedUser.vkUser.vkId}" target="_blank"><h4 class="media-heading">${spiedUser.vkUser.firstName} ${spiedUser.vkUser.lastName}</h4></a>
                    <!--p>На спостереженні з </p-->
                    <a href="/profile/${User.userId}/vkuser/${spiedUser.vkUser.vkId}">Деталі</a>
                </div>
            </div>
        </c:forEach>

    </div>
    <div class="col-md-6">
        <h2>Додати нову людину</h2>
        <br/>
    <form:form class="form-horizontal" id="newVkUser" action="/addToSpyList" method="post"
           commandName="newVkUser">
        <div class="form-group">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Введіть нікнейм id" value="${newVkUser.vkId}">
            </div><!-- /input-group -->
        </div>
        <div class="form-group">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Введіть нікнейм firstname" value="${newVkUser.firstName}">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Введіть нікнейм lastname" value="${newVkUser.lastname}">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <input type="text" id="period" class="form-control" placeholder="period" value="${period}">
                </div>
            </div>
        <div class="form-group">
                    <span class="input-group-btn">
                        <button id="btn" class="btn btn-default" type="submit">Додати</button>
                    </span>
        </div>


    </form:form>


    </div>
</div>

</body>
</html>
