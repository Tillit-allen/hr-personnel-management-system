<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/1/3
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>签到信息</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <style>
        .content {
            margin-left: 0px;
        }
    </style>
</head>
<body class=" theme-blue" onload="getAttendanceRecordList(1,10,null)">


<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">


<!--[if lt IE 7 ]>
<body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]>
<body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]>
<body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]>
<body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->

<!--<![endif]-->
<div class="content">
    <div class="panel panel-default">
        <p class="panel-heading">历史签到信息</p>
        <div class="panel-body">
            <div class="main-content">
                <div class="search-well" style="float: left">
                        查询日期:
                        <input type="date" id="datetime" name="datetime">
                        <button class="btn btn-default" onclick="getAttendanceRecordList(1,10,1)"><i
                                class="fa fa-search"></i>查询
                        </button>
                </div>
                <!--表格-->
                <table class="table">
                    <!--表头-->
                    <thead>
                    <tr>
                        <th>签到编号</th>
                        <th>用户编号</th>
                        <th>签到/签退时间</th>
                        <th>签到/签退状态</th>
                    </tr>
                    </thead>
                    <!--内容-->
                    <tbody id="attendanceRecordList">
                    <%--<c:forEach items="${attendanceRecordList1}" var="attendanceRecord">--%>
                    <%--<tr>--%>
                    <%--<td>${attendanceRecord.userId}</td>--%>
                    <%--<td>${attendanceRecord.id}</td>--%>
                    <%--<td>${attendanceRecord.time}</td>--%>
                    <%--<td>${attendanceRecord.status}</td>--%>
                    <%--</tr>--%>
                    <%--</c:forEach>--%>
                    </tbody>
                </table>

                <!--页码-->
                <ul class="pagination" id="pageNumList">
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
<script>

    function getAttendanceRecordList(pageNums, pageSize, dateTime) {

        var url = "/getAttendanceRecordList";
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        if (pageNums == null || pageNums < 1) {
            pageNums = 1;
        }
        if (dateTime != null) {
            dateTime = $("#datetime").val();
            url = "/getAttendanceRecordListWithAdmin";
        } else {
            dateTime = undefined;
        }

        $.ajax({
            url: url,
            type: "POST",
            data: {
                pageNum: pageNums,
                pageSize: pageSize,
                datetime: dateTime
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
                //表格内容---------------------------------------------------------------
                var html = "";
                $.each(data.data.list, function (index, item) {
                    html += "<tr><td>" + item.id + "</td>" +
                        "<td>" + item.userId + "</td>" +
                        "<td>" + item.time + "</td>" +
                        "<td>" + item.status + "</td></tr>";
                });
                $("#attendanceRecordList").html(html);

                //页码----------------------------------------------------------------
                var pageNum = "";
                if (pageNums > 1) {
                    //上一页
                    pageNum = "<li><a onclick='getAttendanceRecordList(" + (pageNums - 1) + ", 10)'>&laquo;</a></li>";
                }
                for (var i = 1; i <= data.data.navigateLastPage; i++) {
                    if (i == pageNums) {
                        pageNum += "<li><a style='background-color: #e5e5e5;' onclick='getAttendanceRecordList(" + i + ", 10)'>" + i + "</a></li>";
                    } else {
                        pageNum += "<li><a onclick='getAttendanceRecordList(" + i + ", 10)'>" + i + "</a></li>";
                    }
                }
                if (pageNums < data.data.navigateLastPage) {
                    pageNum += "<li><a onclick='getAttendanceRecordList(" + (pageNums + 1) + ", 10)'>&raquo;</a></li>";
                }
                pageNum += "跳转至<input type='number' id='pageNums' min='1' step='1' max='" + data.data.navigateLastPage + "'/> 页" +
                    "<button onclick='skip()'>跳转</button>";
                $("#pageNumList").html(pageNum);

            },
            error: function (msg) {
                console.log(msg);
            }
        })
    }

    function skip() {
        var pageNum = $("#pageNums").val();
        getAttendanceRecordList(pageNum, 10, null);
    }

</script>
</html>