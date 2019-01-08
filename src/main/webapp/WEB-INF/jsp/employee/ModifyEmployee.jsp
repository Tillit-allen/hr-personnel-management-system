<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/1/3
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改信息</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/premium.css">
</head>
<body>
<div id="modify_zone">
    <div class="row" id="init_zone">
        <div class="col-md-4">
            <br>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane active in" id="home">
                    <form id="tab" :model="tableData">
                        <div class="form-group">
                            <label>员工编号</label>
                            <input type="text" placeholder="userId" class="form-control" v-model="tableData.userId"/>
                        </div>
                        <div class="form-group">
                            <label>员工姓名</label>
                            <input type="text" placeholder="userName" class="form-control" v-model="tableData.userName"/>
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="男" v-model="tableData.sex"/>男
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" v-model="tableData.sex"/>女
                        </div>
                        <div class="form-group">
                            <label>直属上司</label>
                            <input type="text" placeholder="bossName" class="form-control" v-model="tableData.bossName"/>
                        </div>

                        <div class="form-group">
                            <label>初始薪资</label>
                            <input type="text" placeholder="basicSalary" class="form-control" v-model="tableData.basicSalary"/>
                        </div>
                        <div class="form-group">
                            <label>婚姻状况</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="marry" value="已婚" checked v-model="tableData.marriage"/>已婚
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="marry" value="未婚" v-model="tableData.marriage"/>未婚
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
                <div class="btn-toolbar list-toolbar">
                    <button class="btn btn-primary" @click="doSubmit"><i class="fa fa-save"></i> 提交</button>
                    <a data-toggle="modal" class="btn btn-danger" @click="doReturn">返回</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/vue.js"></script>
<script>
    new Vue({
        el:"#modify_zone",
        data:{
            tableData:
                {
                    userId:"",
                    userName:"",
                    sex:"",
                    bossName: "",
                    basicSalary: "",
                    marriage:"",
                    birthday:"",
                    homePlace:""
                }
        },
        methods:{
            doSubmit:function(){
                $.ajax({
                    url:"/userInfo/adminModify",
                    data:{
                        userId:this.tableData.userId,
                        userName:this.tableData.userName,
                        sex:this.tableData.sex,
                        bossName:this.tableData.bossName,
                        basicSalary:this.tableData.basicSalary,
                        marriage:this.tableData.marriage,
                        birthday:this.tableData.birthday,
                        homePlace:this.tableData.homePlace,
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        console.log(res);
                        if(res.status == 200){
                            alert("修改成功！");
                        }
                        else{
                            alert("修改失败！");
                        }
                    },
                    error:function () {
                        alert("服务器错误啦！");
                    }
                })
            },
            doReturn:function () {
                window.location.href="/toPage?page=employee/EmployeeList";
            }
        },
        mounted:function () {
            const this_ = this;
            $.ajax({
                url:"/userInfo/getEmployeeDataForModify",
                type:"post",
                dataType:"json",
                success:function (res) {
                        this_.tableData=res.data;
                    console.log(res);
                },
                error:function () {
                    alert("服务器错误！");
                }
            })
        }
    })
</script>
</body>
</html>
