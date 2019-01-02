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
<div class="row">
    <div class="col-md-4">
        <br>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane active in" id="home">
                <form id="tab">
                    <div class="form-group">
                        <label>员工姓名</label>
                        <input type="text" placeholder="userName" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>性别</label>
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="男" checked/>男
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" />女
                    </div>
                    <div class="form-group">
                        <label>登陆账号</label>
                        <input type="text" placeholder="userName" class="form-control"disabled/>
                    </div>
                    <div class="form-group">
                        <label>初始密码</label>
                        <input type="text"  class="form-control" disabled/>
                    </div>

                    <div class="form-group">
                        <label>直属上司</label>
                        <input type="text" placeholder="bossName" class="form-control" disabled/>
                    </div>

                    <div class="form-group">
                        <label>初始薪资</label>
                        <input type="text" placeholder="basicSalary" class="form-control"disabled/>
                    </div>
                    <div class="form-group">
                        <label>婚姻状况</label>
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="已婚" checked/>已婚
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="未婚" />未婚
                    </div>
                    <div class="form-group">
                        <label>出生年月</label>
                        <input type="date" value="2019-01-01" style="width: 200px;height: 30px"/>
                    </div>
                    <div class="form-group">
                        <label>家庭住址</label>
                        <input type="text" placeholder="homeAddress" class="form-control">
                    </div>
                </form>
            </div>

            <div class="tab-pane fade" id="profile">

                <form id="tab2">
                    <div class="form-group">
                        <label>New Password</label>
                        <input type="password" class="form-control">
                    </div>
                    <div>
                        <button class="btn btn-primary">Update</button>
                    </div>
                </form>
            </div>
        </div>

        <div class="btn-toolbar list-toolbar">
            <button class="btn btn-primary"><i class="fa fa-save"></i> 提交</button>
            <a href="#myModal" data-toggle="modal" class="btn btn-danger">重置</a>
        </div>
    </div>
</div>
</body>
</html>
