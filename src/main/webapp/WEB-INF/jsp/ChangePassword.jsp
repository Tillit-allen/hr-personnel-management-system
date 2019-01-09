<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/1/5
  Time: 19:17
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
        #change_password{
            width: 40%;
            height: auto;
            margin: 60px auto;
            background-color: #fff;
            padding: 40px;
        }
    </style>
</head>
<body>
<div id="change_password">
    <form id="tab" :model="tableData">
        <div class="form-group">
            <label>原始密码</label>
            <input type="text" placeholder="userName" class="form-control" v-model="tableData.oldPassword"/>
        </div>
        <div class="form-group">
            <label>新密码</label>
            <input type="password" placeholder="userName" class="form-control" v-model="tableData.newPassword"/>
        </div>
        <div class="form-group">
            <label>确认密码</label>
            <input type="password" placeholder="userName" class="form-control" v-model="tableData.newCheckPassword"/>
        </div>

    </form>
    <div class="btn-toolbar list-toolbar">
        <button class="btn btn-primary" @click="doSubmit"><i class="fa fa-save"></i> 提交</button>
        <a data-toggle="modal" class="btn btn-danger" @click="doRes">重置</a>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/vue.js"></script>
<script>
    new Vue({
        el:"#change_password",
        data:{
            tableData:{
                oldPassword:"",
                newPassword:"",
                newCheckPassword:"",
            },

        },
        methods:{
            doSubmit:function(){
                $.ajax({
                    url:"/userInfo/changePassWord",
                    data:{
                        oldPassword:this.tableData.oldPassword,
                        newPassword:this.tableData.newPassword,
                        newCheckPassword:this.tableData.newCheckPassword,
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        if(res.status==200){
                            alert("修改成功！");
                        }else{
                            alert(res.msg);
                        }
                    },
                    error:function () {
                        alert("服务器错误！");
                    }
                })
            },
            doRes:function () {
                location.reload();
            }
        }
    })
</script>
</body>
</html>
