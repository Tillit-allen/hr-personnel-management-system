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
                            ${sessionScope.userInfo.userName}</span>
                    <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu">
                    <li><a onclick=toPage("/ThisUserData")>我的信息</a></li>
                    <li><a onclick=toPage("/ChangePassword")>修改密码</a></li>
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
            <c:choose>
                <c:when test="${sessionScope.userInfo.isAdministrator==3}">
                    <li ><a onclick=toPage("employee/EmployeeList")><span class="fa fa-caret-right"></span> 员工列表</a></li>
                    <li ><a onclick=toPage("employee/addEmployee1")><span class="fa fa-caret-right"></span> 初始化员工信息</a></li>
                    <li ><a onclick=toPage("employee/checkAddEmployee")><span class="fa fa-caret-right"></span> 管理员校验</a></li>
                </c:when>
                <c:otherwise></c:otherwise>
            </c:choose>
            <li ><a onclick=toPage("employee/addEmployee2")><span class="fa fa-caret-right"></span> 员工核准</a></li>
        </ul></li>

        <li data-popover="true" data-content="Items in this group require a <strong><a href='http://portnine.com/bootstrap-themes/aircraft' target='blank'>premium license</a><strong>."
            rel="popover" data-placement="right"><a href="#" data-target=".premium-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet">
        </i> 考勤管理<i class="fa fa-collapse"></i></a></li>
        <li><ul class="premium-menu nav nav-list collapse">
            <li ><a onclick=toPage("attendance/addAttendanceRecord")><span class="fa fa-caret-right"></span> 签到</a></li>
            <li ><a onclick=toPage("attendance/AttendanceRecordList")><span class="fa fa-caret-right"></span> 查询个人签到记录</a></li>
            <c:choose>
                <c:when test="${sessionScope.userInfo.isAdministrator==3}">
                    <li ><a onclick=toPage("attendance/AttendanceRecordList1")><span class="fa fa-caret-right"></span> 管理员查询签到记录</a></li>
                </c:when>
            </c:choose>

        </ul></li>

        <li><a href="#" data-target=".accounts-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-briefcase"></i> 加班申请<i class="fa fa-collapse"></i></a></li>
        <li><ul class="accounts-menu nav nav-list collapse">
            <li ><a onclick=toPage("OvertimeRecords/addApplyOvertime")><span class="fa fa-caret-right"></span> 加班申请</a></li>
            <li ><a onclick=toPage("OvertimeRecords/showApplyOvertime")><span class="fa fa-caret-right"></span> 我的申请</a></li>
            <c:choose>
                <c:when test="${sessionScope.userInfo.isAdministrator==3}">
                    <li><a onclick=toPage("OvertimeRecords/checkAddApplyOvertime")><span class="fa fa-caret-right"></span> 管理员校验</a></li>
                </c:when>
            </c:choose>


        </ul></li>

        <li><a href="#" data-target=".legal-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-legal"></i>请假申请<i class="fa fa-collapse"></i></a></li>
        <li><ul class="legal-menu nav nav-list collapse">
            <li ><a href="${pageContext.request.contextPath}/leave/toLeaveListWithAdmin"><span class="fa fa-caret-right"></span> 请假记录 </a></li>
            <li ><a href="${pageContext.request.contextPath}/leave/toAddLeaveList"><span class="fa fa-caret-right"></span> 申请请假 </a></li>
            <c:choose>
                <c:when test="${sessionScope.userInfo.isAdministrator==3}">
                    <li ><a href="${pageContext.request.contextPath}/leave/toLeaveList"><span class="fa fa-caret-right"></span> 员工请假记录 </a></li>
                </c:when>
            </c:choose>

        </ul></li>

        <li><a href="#" data-target=".accounts-menu1" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-question-circle">
        </i>薪资管理<i class="fa fa-collapse"></i></a></li>
        <li><ul class="accounts-menu1 nav nav-list collapse">
            <li ><a onclick=toUrl("/salary/toSalaryList")><span class="fa fa-caret-right"></span> 个人薪资列表</a></li>
            <c:choose>
                <c:when test="${sessionScope.userInfo.isAdministrator==3}">
                    <li id="adminSalaryMenu"><a onclick=toUrl("/salary/toSalaryListWithAdmin")><span class="fa fa-caret-right"></span> 管理员薪资列表</a></li>
                </c:when>
            </c:choose>

        </ul>

        <li><a href="#" data-target=".accounts-menu2" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-question-circle">
        </i>出差报销<i class="fa fa-collapse"></i></a></li>
        <li><ul class="accounts-menu2 nav nav-list collapse">
            <li ><a onclick=toPage("Reimburse/useradd")><span class="fa fa-caret-right"></span> 出差报销申请</a></li>
            <li ><a onclick=toPage("Reimburse/userlist")><span class="fa fa-caret-right"></span> 个人提交列表</a></li>
            <c:choose>
                <c:when test="${sessionScope.userInfo.isAdministrator==3}">
                    <li ><a onclick=toPage("Reimburse/AdminList")><span class="fa fa-caret-right"></span> 管理员申请审批</a></li>
                </c:when>
            </c:choose>
        </ul></li>
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
