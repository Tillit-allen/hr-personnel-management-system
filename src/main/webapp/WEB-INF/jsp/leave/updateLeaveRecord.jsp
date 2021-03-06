<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2018/12/29
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改请假信息</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link href='http://fonts.useso.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>--%>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
    <style>
        .col-md-4 {
            margin-left: 30px;
        }

        .row {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<div class="row" id="init_zone">
    <div class="col-md-4">
        <br>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane active in" id="home">
                <form id="tab" action="/leave/updateLeaveRecord">
                    <input type="hidden" value="${LeaveRecordInfo.id}" name="id">
                    <input type="hidden" value="${LeaveRecordInfo.auditStatus}" name="auditStatus">
                    <div class="form-group">
                       <tr> <label>员工编号</label>
                        <input disabled value="${LeaveRecordInfo.userId}" type="text" name="userId" placeholder="userId" class="form-control"/></tr>
                        <tr>
                            <li><label>请假类型</label>
                            <select name="type" placeholder="type">
                                <option value="病假" <c:if test="${type=='病假'}"></c:if>>病假</option>
                                <option value="事假" <c:if test="${type=='事假'}"></c:if>>事假</option>
                            </select>
                            </li>
                            <li>
                                <label>请假开始时间</label>
                                <td><f:formatDate value="${LeaveRecordInfo.startTime}"
                                                  type="date" dateStyle="long"/></td>
                                <input value="${LeaveRecordInfo.startTime}" type="date" name="startTime" placeholder="startTime" class="form-control">
                            </li>
                            <li>
                                <label>请假结束时间</label>
                                <td><f:formatDate value="${LeaveRecordInfo.endTime}"
                                                  type="date" dateStyle="long"/></td>
                                <input value="${LeaveRecordInfo.endTime}" type="date" name="endTime" placeholder="endTime" class="form-control">
                            </li>
                            <li>
                                <label>详细原因</label>
                                <div class=><textarea style="width:300px;height:150px;font-size:20px; line-height:30px;" name="reason" placeholder="reason">${LeaveRecordInfo.reason}
                                </textarea>
                                </div>
                            </li>
                        </tr>

                    </div>

                </form>
            </div>
            <c:choose>

                <c:when test="${LeaveRecordInfo.auditStatus=='审核通过'}">
                    <div class="btn-toolbar list-toolbar">
                        <button disabled class="btn btn-primary" onclick="$('#tab').submit()"><i class="fa fa-save"></i> 提交</button>
                        <a data-toggle="modal" class="btn btn-danger" @click="doRes">重置2</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="btn-toolbar list-toolbar">
                        <button class="btn btn-primary" onclick="$('#tab').submit()"><i class="fa fa-save"></i> 提交</button>
                        <a data-toggle="modal" class="btn btn-danger" @click="doRes">重置1</a>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/vue.js"></script>
<script>


    new Vue({
        el: "#init_zone",
        data: {
            id: "",
            userId: "",
            type: "",
            startTime: "",
            endTime: "",
            reason: "",
            auditStatus: "",
        },
        methods: {
            doSubmit: function () {
                $.ajax({

                    data: {
                        userId: this.userId,
                        type: this.type,
                        startTime:this.startTime,
                        endTime:this.endTime,
                        reason:this.reason,
                        auditStatus:this.auditStatus
                        },
                    type:"post",
                    dataType: "json",
                    success: function (res) {
                        if(res.status==200){
                            alert("初始化完成!");
                        }else{
                            alert("初始化失败!");
                        }
                    console.log(res);
                },
                error:function () {
                    alert("服务器错误！");
                }
            })
            },
            doRes: function () {
                location.reload();
            },
        },
    })
</script>
</body>
</html>
