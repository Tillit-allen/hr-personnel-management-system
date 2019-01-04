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
    <title>初始化员工信息</title>
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
                <form id="tab">
                    <div class="form-group">
                        <label>员工编号</label>
                        <input type="text" placeholder="userId" class="form-control" v-model="userId"/>
                    </div>
                    <div class="form-group">
                        <label>员工姓名</label>
                        <input type="text" placeholder="userName" class="form-control" v-model="userName"/>
                    </div>
                    <div class="form-group">
                        <label>性别</label>
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="男" checked v-model="sex"/>男
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" v-model="sex"/>女
                    </div>
                    <div class="form-group">
                        <label>登陆账号</label>
                        <input type="text" placeholder="userName" class="form-control" v-model="loginName"/>
                    </div>
                    <div class="form-group">
                        <label>初始密码</label>
                        <input type="text" class="form-control" disabled v-model="passWord"/>
                    </div>

                    <div class="form-group">
                        <label>直属上司</label>
                        <input type="text" placeholder="bossName" class="form-control" v-model="bossName"/>
                    </div>

                    <div class="form-group">
                        <label>初始薪资</label>
                        <input type="text" placeholder="basicSalary" class="form-control" v-model="basicSalary"/>
                    </div>
                </form>
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
        el: "#init_zone",
        data: {
            userId: "",
            userName: "",
            loginName: "",
            passWord: "123456",
            sex: "",
            bossName: "",
            basicSalary: "",
        },
        methods: {
            doSubmit: function () {
                $.ajax({
                    url: "/userInfo/addEmployee",
                    data: {
                        id: this.userId,
                        name: this.userName,
                        sex:this.sex,
                        loginName:this.loginName,
                        password:this.passWord,
                        boss:this.bossName,
                        basemoney:this.basicSalary
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
