<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 09.04.2017
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

    <style>
        #chartdiv {
            width	: 100%;
            height	: 500px;
        }
    </style>
</head>
<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>

<div id="main-content" class="container">
    <div id="chartdiv"></div>
</div>


<!-- Resources -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/amstock.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

<!-- Chart code -->
<script>
    var chartData = generateChartData();

    function generateChartData() {
        var chartData = [];

        <c:forEach items="${Statuses}" var="status">
        chartData.push({
            "date": new Date("${status.date}"),
            "value": ${status.online}
        });
        </c:forEach>

        return chartData;
    }

    var chart = AmCharts.makeChart( "chartdiv", {
        "type": "stock",
        "theme": "light",
        "categoryAxesSettings": {
            "minPeriod": "mm"
        },

        "dataSets": [ {
            "color": "#b0de09",
            "fieldMappings": [ {
                "fromField": "value",
                "toField": "value"
            }],

            "dataProvider": chartData,
            "categoryField": "date"
        } ],

        "panels": [ {
            "showCategoryAxis": false,
            "title": "Value",
            "percentHeight": 70,

            "stockGraphs": [ {
                "id": "g1",
                "valueField": "value",
                "type": "smoothedLine",
                "lineThickness": 0,
                "bullet": "round"
            } ],


            "stockLegend": {
                "valueTextRegular": " ",
                "markerType": "none"
            }
        }],

        "chartScrollbarSettings": {
            "graph": "g1",
            "usePeriod": "10mm",
            "position": "top"
        },

        "chartCursorSettings": {
            "valueBalloonsEnabled": true
        },

//        "periodSelector": {
//            "position": "top",
//            "dateFormat": "YYYY-MM-DD JJ:NN",
//            "inputFieldWidth": 150,
//            "periods": [ {
//                "period": "hh",
//                "count": 1,
//                "label": "1 hour",
//                "selected": true
//            }, {
//                "period": "hh",
//                "count": 2,
//                "label": "2 hours"
//            }, {
//                "period": "hh",
//                "count": 5,
//                "label": "5 hour"
//            }, {
//                "period": "hh",
//                "count": 12,
//                "label": "12 hours"
//            }, {
//                "period": "MAX",
//                "label": "MAX"
//            } ]
//        },

        "panelsSettings": {
            "usePrefixes": true
        },

        "export": {
            "enabled": true,
            "position": "bottom-right"
        }
    } );
</script>
</body>
</html>
