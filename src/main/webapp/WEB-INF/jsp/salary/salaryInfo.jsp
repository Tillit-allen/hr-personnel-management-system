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
    <title>薪资列表</title>
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
<body class=" theme-blue">

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

    <!--第一行-->
    <div class="header">
        <ul class="breadcrumb">
            <h1><li class="active">薪资详情</li></h1>
        </ul>
    </div>
    <div class="main-content">

        <!--表格-->
        <table class="table" border="1">
            <tr>
                <td style="text-align: center;width: 10em;">用户名</td>
                <td>${salaryRecordInfo.userId}</td>
                <td style="text-align: center;width: 10em;">薪资</td>
                <td>${salaryRecordInfo.salary}</td>
            </tr>
            <tr>
                <td style="text-align: center;width: 10em;">薪资计算开始时间</td>
                <td>${salaryRecordInfo.startTime.toLocaleString()}</td>
                <td style="text-align: center;width: 10em;">薪资计算结束时间</td>
                <td>${salaryRecordInfo.endTime.toLocaleString()}</td>
            </tr>
            <tr>
                <td style="text-align: center;width: 10em;">工作时长(分钟)</td>
                <td>${salaryRecordInfo.workTime}</td>
                <td style="text-align: center;width: 10em;">加班天数</td>
                <td>${salaryRecordInfo.overtimeTime}</td>
            </tr>
            <tr>
                <td style="text-align: center;width: 10em;">出差总天数</td>
                <td>${salaryRecordInfo.businessTime}</td>
                <td style="text-align: center;width: 10em;">出差总经费</td>
                <td>${salaryRecordInfo.businessMoney}</td>
            </tr>
            <tr>
                <td>病假总天数</td>
                <td colspan="3">${salaryRecordInfo.leaveTime}</td>
            </tr>
            <tr>
                <td style="text-align: center;width: 10em;">迟到次数</td>
                <td>${salaryRecordInfo.lateTime}</td>
                <td style="text-align: center;width: 10em;">早退次数</td>
                <td>${salaryRecordInfo.leaveEarlyTime}</td>
            </tr>
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
</script>


</body>
</html>
