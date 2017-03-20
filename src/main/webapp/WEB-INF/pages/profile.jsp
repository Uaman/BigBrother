<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
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

        <div class="media">
            <div class="media-left">
                <a href="#">
                    <img class="media-object" src="<c:url value="/resources/img/avatar.png"/>" alt="..." >
                </a>
            </div>
            <div class="media-body">
                <h4 class="media-heading">John Doe</h4>
                <p>На спостереженні з 20.02.2017</p>
                <a href="#">Деталі</a>
            </div>
        </div>

        <div class="media">
            <div class="media-left">
                <a href="#">
                    <img class="media-object" src="<c:url value="/resources/img/avatar.png"/>" alt="..." >
                </a>
            </div>
            <div class="media-body">
                <h4 class="media-heading">John Doe</h4>
                <p>На спостереженні з 20.02.2017</p>
                <a href="#">Деталі</a>
            </div>
        </div>

        <div class="media">
            <div class="media-left">
                <a href="#">
                    <img class="media-object" src="<c:url value="/resources/img/avatar.png"/>" alt="..." >
                </a>
            </div>
            <div class="media-body">
                <h4 class="media-heading">John Doe</h4>
                <p>На спостереженні з 20.02.2017</p>
                <a href="#">Деталі</a>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <h2>Додати нову людину</h2>
        <br/>

        <div class="input-group">
            <input type="text" class="form-control" placeholder="Введіть нікнейм...">
            <span class="input-group-btn">
        <button class="btn btn-default" type="button">Додати</button>
      </span>
        </div><!-- /input-group -->
    </div>
</div>

</body>
</html>
