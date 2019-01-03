<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/1/2
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<meta charset="utf-8">--%>
    <%--<title>登陆界面</title>--%>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <%--<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <%--<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">--%>
    <style>
        body{
            width: 100%;
            height: 100%;
        }
        #login_zone{
            width: 25%;
            height: auto;
            margin: 100px auto;
        }
    </style>
</head>
<body>
<div id="login_zone">
    <div class="panel panel-default">
        <p class="panel-heading no-collapse">登陆进入 AEAR-HR人力资源管理系统</p>
        <div class="panel-body">
            <form>
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" class="form-control span12" v-model="loginName"/>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-controlspan12 form-control" v-model="passWord"/>
                </div>
                <button class="btn btn-primary pull-right" @click="doLogin" type="button">登陆</button>
            </form>
        </div>
    </div>
</div>
<script src="/js/jquery-3.3.1.js"></script>
<script src="/js/vue.js"></script>
<script>
    new Vue({
        el:"#login_zone",
        data:{
            loginName:"",
            passWord:""
        },
        methods:{
            doLogin:function () {
                // alert(1);
                $.ajax({
                    url:"/login",
                    data:{
                        loginName:this.loginName,
                        password:this.passWord,
                    },
                    // async:false,
                    type:"POST",
                    dataType:"JSON",
                    success:function (res) {
                        console.log(res);
                        //登陆成功跳转到主页面
                        if(res.status==200){
                            window.location = "/toPage?page=main";
                        }else{
                            alert(res.msg);
                        }
                    },
                    error:function (res) {
                       console.log(res);
                    }
                })
            },
        },
    })
</script>
</body>
</html>
