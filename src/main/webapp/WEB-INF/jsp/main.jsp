<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2018/12/28
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/premium.css">
    <%--<link href='http://fonts.useso.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <style type="text/css">
        body{width:100%;height:100%;}
        .navbar{
            width:100%;
            height:10%;
            margin-bottom:0px;
        }
        .sidebar-nav{
            width:14%;
        }
        #title{
            margin-left:200px;
            margin-top:100px;
            text-align: center;
        }

    </style>
</head>
<body>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->

<!--<![endif]-->

<div class="navbar navbar-default" role="navigation" style="height: 50px">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href=""><span class="navbar-brand"><span class="fa fa-paper-plane"></span> Aircraft</span></a></div><div class="navbar-collapse collapse" style="height: 1px;">
    <ul id="main-menu" class="nav navbar-nav navbar-right">
<c:choose>
    <c:when test="${sessionScope.user==null}"><a href="toPage?page=loginRegister/Login">请先登录</a></c:when>
    <c:otherwise>
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;">
                            ${sessionScope.user.loginName}</span>
                    <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">我的信息</a></li>
                    <li><a href="#">修改密码</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">管理员模块</li>
                        <%--<li><a href="#">Security</a></li>--%>
                        <%--<li><a tabindex="-1" href="#">Payments</a></li>--%>
                    <li class="divider"></li>
                    <li><a tabindex="-1" href="/logout">登出</a></li>
                </ul>
            </li>
        </c:otherwise>
    </c:choose>
    </ul>
</div>
<div class="sidebar-nav" style="margin-left: -20px">
    <ul>
        <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 人员信息<i class="fa fa-collapse"></i></a></li>
        <li><ul class="dashboard-menu nav nav-list collapse in">
            <!--<li><a onclick=toPage("index.html")><span class="fa fa-caret-right"></span> 首页</a></li>-->
            <li ><a onclick=toPage("employee/EmployeeList")><span class="fa fa-caret-right"></span> 员工列表</a></li>
            <li ><a onclick=toPage("employee/addEmployee1")><span class="fa fa-caret-right"></span> 初始化员工信息</a></li>
            <li ><a onclick=toPage("employee/addEmployee2")><span class="fa fa-caret-right"></span> 员工核准</a></li>
            <li ><a onclick=toPage("employee/checkAddEmployee")><span class="fa fa-caret-right"></span> 管理员校验</a></li>
        </ul></li>

        <li data-popover="true" data-content="Items in this group require a <strong><a href='http://portnine.com/bootstrap-themes/aircraft' target='blank'>premium license</a><strong>." rel="popover" data-placement="right"><a href="#" data-target=".premium-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i> 考勤管理<i class="fa fa-collapse"></i></a></li>
        <li><ul class="premium-menu nav nav-list collapse">
            <li class="visible-xs visible-sm"><a href="#">- Premium features require a license -</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Enhanced Profile</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Blog</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Blog Page</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Pricing Tables</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Upgrade Account</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Widgets</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Activity Timeline</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Enhanced Users List</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Enhanced Media</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Invoice</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Advanced Tools</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Additional Color Themes</a></li>
        </ul></li>

        <li><a href="#" data-target=".accounts-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-briefcase"></i> 加班申请<span class="label label-info">+3</span></a></li>
        <li><ul class="accounts-menu nav nav-list collapse">
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Sign In</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Sign Up</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Reset Password</a></li>
        </ul></li>

        <li><a href="#" data-target=".legal-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-legal"></i>请假申请<i class="fa fa-collapse"></i></a></li>
        <li><ul class="legal-menu nav nav-list collapse">
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Privacy Policy</a></li>
            <li ><a onclick=toPage("")><span class="fa fa-caret-right"></span> Terms and Conditions</a></li>
        </ul></li>

        <li><a onclick=toPage("") class="nav-header"><i class="fa fa-fw fa-question-circle"></i>薪资管理</a></li>
        <!--<li><a href="faq.html" class="nav-header"><i class="fa fa-fw fa-comment"></i> Faq</a></li>-->
        <li><a onclick=toPage("") class="nav-header" target="blank"><i class="fa fa-fw fa-heart"></i> 出差报销</a></li>
    </ul>
</div></div>
<c:choose>
    <c:when test="${sessionScope.user==null}">
        <div id="title">
            <h2 >傻逼玩意登陆去滚滚滚滚</h2>
            <br/>
            <span style="color:#aaaaaa">右上角点击登陆</span>
        </div>
    </c:when>
    <c:otherwise>
        <iframe src="${pageContext.request.contextPath}/welcome.jsp" style="width:86%;height:500px;float: right;border:none;" id="zone"></iframe>
    </c:otherwise>
</c:choose>

<script>
    //iframe跳转页面
    function toPage(page) {
        $("#zone").attr("src","${pageContext.request.contextPath}/toPage?page="+page);
    }
</script>
</body>
</html>
