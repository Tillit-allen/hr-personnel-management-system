<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2018/12/29
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>员工反校验</title>
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
        .col-md-4{
            margin-left: 30px;
        }
        .row{
            width:100%;
            height:auto;
        }
    </style>
</head>
<body>
<div id="reCheck_zone">
    <div class="row">
        <div class="col-md-4">
            <br>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane active in" id="home">
                    <form id="tab" :model="tableData">
                        <div class="form-group">
                            <label>员工姓名</label>
                            <input type="text" placeholder="userName" class="form-control" v-model="tableData.userName"/>
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="男" checked v-model="tableData.sex"/>男
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" v-model="tableData.sex"/>女
                        </div>
                        <div class="form-group">
                            <label>登陆账号</label>
                            <input type="text" placeholder="userName" class="form-control"disabled v-model="tableData.loginName"/>
                        </div>
                        <div class="form-group">
                            <label>初始密码</label>
                            <input type="text"  class="form-control" disabled v-model="tableData.passWord"/>
                        </div>

                        <div class="form-group">
                            <label>直属上司</label>
                            <input type="text" placeholder="bossName" class="form-control" disabled v-model="tableData.bossName"/>
                        </div>

                        <div class="form-group">
                            <label>初始薪资</label>
                            <input type="text" placeholder="basicSalary" class="form-control"disabled v-model="tableData.basicSalary"/>
                        </div>
                        <div class="form-group">
                            <label>婚姻状况</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="已婚" checked v-model="tableData.marriage"/>已婚
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="未婚" v-model="tableData.marriage"/>未婚
                        </div>
                        <div class="form-group">
                            <label>出生年月</label>
                            <input type="date" value="2019-01-01" style="width: 200px;height: 30px" v-model="tableData.birthday"/>
                        </div>
                        <div class="form-group">
                            <label>家庭住址</label>
                            <input type="text" placeholder="homeAddress" class="form-control" v-model="tableData.homePlace"/>
                        </div>
                    </form>
                </div>
            </div>
            <div class="btn-toolbar list-toolbar">
                <button class="btn btn-primary" @click="doSubmit"><i class="fa fa-save"></i> 提交</button>
                <a data-toggle="modal" class="btn btn-danger" @click="doRes">重置</a>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/vue.js"></script>
<script>
    new Vue({
        el:"#reCheck_zone",
        data:{
            tableData:{
                userName:"",
                sex:"",
                loginName:"",
                passWord:"",
                bossName: "",
                basicSalary: "",
                marriage:"",
                birthday:"",
                homePlace:""
            }
        },
        methods:{
            doSubmit:function(){

            },
            doRes:function () {

            }
        },
        mounted:function () {
            $.ajax({
                url:"/userInfo/getEmployeeData_",
                data:{
                    userId:"0",
                },
                type:"post",
                dataType:"json",
                success:function (res) {
                    console.log(res);
                },
                error:function () {
                    alert("用户权限出现问题，请退出登录！");
                }
            })
        }
    })
</script>
</body>
</html>
