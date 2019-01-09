<%@ page import="com.six.hrpms.pojo.SalaryRecord" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuekeke
  Date: 2019/1/3
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>薪资列表(管理员)</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.useso.com/css?family=Open+Sans:400,700' rel='stylesheet'
          type='<%=request.getContextPath()%>/text/css'>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/stylesheets/premium.css">
    <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js" type="text/javascript"></script>

    <style>
        .content {
            margin-left: 0px;
        }
    </style>
</head>
<body class=" theme-blue" onload="getSalaryList(1,10)">

<!-- Demo page code -->
<script type="text/javascript">
    $(function () {
        var match = document.cookie.match(new RegExp('color=([^;]+)'));
        if (match) var color = match[1];
        if (color) {
            $('body').removeClass(function (index, css) {
                return (css.match(/\btheme-\S+/g) || []).join(' ')
            })
            $('body').addClass('theme-' + color);
        }

        $('[data-popover="true"]').popover({html: true});

    });
</script>
<style type="text/css">

    .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
        color: #fff;
    }
</style>

<script type="text/javascript">
    $(function () {
        var uls = $('.sidebar-nav > ul > *').clone();
        uls.addClass('visible-xs');
        $('#main-menu').append(uls.clone());
    });
</script>

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
    <div class="main-content">
        <!--按钮-->
        <div class="btn-toolbar list-toolbar">
            结算时间段:
            <input type="date" id="start" name="start"/>
            ~
            <input type="date" id="end" name="end">
            用户id:<input type="text" id="userId">
            用户名称:<input type="text" id="userName">
            老板名称:<input type="text" id="bossName">
            <%--<button class="btn btn-primary"><i class="fa fa-plus"></i> 新用户</button>--%>
            <button class="btn btn-default" onclick="getSalaryList(1,10)">查询</button>
            <%--<button class="btn btn-default">导出</button>--%>
            <div class="btn-group">
            </div>
        </div>

        <!--表格-->
        <table class="table">
            <!--表头-->
            <thead>
            <tr>
                <th style="width: 15%;">员工名称</th>
                <th style="width: 15%;">薪资</th>
                <th style="width: 50%;">结算时间段</th>
                <th style="width: 20%;">操作</th>
            </tr>
            </thead>
            <!--内容-->
            <tbody id="salaryListBody">
            </tbody>
        </table>

        <!--页码-->
        <ul class="pagination" id="pageNum">
        </ul>

        <!--删除按钮-->
        <div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h3 id="myModalLabel">Delete Confirmation</h3>
                    </div>
                    <div class="modal-body">
                        <p class="error-text"><i class="fa fa-warning modal-icon"></i>Are you sure you want to delete
                            the user?<br>This cannot be undone.</p>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
                        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function () {
        $('.demo-cancel-click').click(function () {
            return false;
        });
    });

    /**
     * 获取薪资列表
     * @param pageNum 页码
     * @param pageSize 每页显示个数
     */
    function getSalaryList(pageNums, pageSize) {
        var context = "<%=request.getContextPath()%>";
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        if (pageNums == null || pageNums == "" || pageNums < 1) {
            pageNums = 1;
        }
        var start = $("#start").val();
        if (start == null || start == "") {
            start = undefined;
        }
        var end = $("#end").val();
        if (end == null || end == "") {
            end = undefined;
        }
        var userId = $("#userId").val();
        if (userId == null || userId == "") {
            userId = undefined;
        }
        var userName = $("#userName").val();
        if (userName == null || userName == "") {
            userName = undefined;
        }
        var bossName = $("#bossName").val();
        if (bossName == null || bossName == "") {
            bossName = undefined;
        }
        $.ajax({
            type: "POST",
            url: "/salary/getSalaryListWithAdmin",
            dataType: "json",
            data: {
                pageNum: pageNums,
                pageSize: pageSize,
                start: start,
                end: end,
                userId: userId,
                userName: userName,
                bossName: bossName
            },
            success: function (data) {
                //表格内容---------------------------------------------------------------
                var html = "";
                $.each(data.data.list, function (index, item) {
                    html += "<tr  onclick='toInfo(" + item.id + ")'><td>" + item.userId + "</td>" +
                        "<td>" + item.salary + "</td>" +
                        "<td>" + item.startTime + " ~ " + item.endTime + "</td>" +
                        "<td>操作</td></tr>";
                });
                $("#salaryListBody").html(html);

                //页码----------------------------------------------------------------
                var pageNum = "";
                if (pageNums > 1) {
                    //上一页
                    pageNum = "<li><a onclick='getSalaryList(" + (pageNums - 1) + ", 10)'>&laquo;</a></li>";
                }
                for (var i = 1; i <= data.data.navigateLastPage; i++) {
                    if (i == pageNums) {
                        pageNum += "<li><a style='background-color: #e5e5e5;' onclick='getSalaryList(" + i + ", 10)'>" + i + "</a></li>";
                    } else {
                        pageNum += "<li><a onclick='getSalaryList(" + i + ", 10)'>" + i + "</a></li>";
                    }
                }
                if (pageNums < data.data.navigateLastPage) {
                    pageNum += "<li><a onclick='getSalaryList(" + (pageNums + 1) + ", 10)'>&raquo;</a></li>";
                }
                pageNum += "跳转至<input type='number' id='pageNums' min='1' step='1' max='" + data.data.navigateLastPage + "'/> 页" +
                    "<button onclick='skip()'>跳转</button>";
                $("#pageNum").html(pageNum);
            },
            error: function (data) {
                console.log("错啦!!!" + data);
            }
        })
    }

    function toInfo(id) {
        window.location.href = "<%=request.getContextPath()%>/salary/toSalaryInfo?id=" + id;
    }

    function skip() {
        var pageNum = $("#pageNums").val();
        getSalaryList(pageNum, null);
    }
</script>


</body>
</html>
