<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/1/4
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>
<body>
<div id="search_zone">
    <div>
        <label for="search_num">输入工号搜索：</label>
        <input type="text" name="search" id="search_num" v-model="userId_"/>
        <button type="button" @click="doSearch_num">搜索</button>
    </div>
    <div>
        <label for="search_name">输入姓名搜索：</label>
        <input type="text" name="search" id="search_name" v-model="userName_"/>
        <button type="button" @click="doSearch_name">搜索</button>
    </div>
    <div>
        <el-table
                :data="tableData"
                style="width: 100%">
            <el-table-column
                    prop="userId"
                    label="员工编号"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="userName"
                    label="姓名"
                    width="80">
            </el-table-column>
            <el-table-column
                    prop="sex"
                    label="性别"
                    width="80">
            </el-table-column>
            <el-table-column
                    prop="marriage"
                    label="婚配状况"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="bossName"
                    label="直属上司"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="basicSalary"
                    label="基础工资"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="birthday"
                    label="出生年月"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="homePlace"
                    label="地址">
            </el-table-column>
            <el-table-column
                    prop="isAdministrator"
                    label="用户等级"
                    width="100">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="doEdit(scope.row)" type="text" size="small">编辑</el-button>
                    <el-button type="text" size="small" @click="doDel(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</div>
<script>
    new Vue({
        el:"#search_zone",
        data:{
            userId_:"",
            userName_:"",
            tableData:[]
        },
        methods:{
            doSearch_num:function () {
                const this_ = this;
                $.ajax({
                    url:"/userInfo/adminSearch",
                    data:{
                        userId:this.userId_,
                        flag:1
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        console.log(res);
                        this_.tableData = res.data;
                    },
                    error:function () {
                        alert("服务器错误");
                    }
                })
            },
            doSearch_name:function () {
                const this_ = this;
                $.ajax({
                    url:"/userInfo/adminSearch",
                    data:{
                        userName:this.userName_,
                        flag:2
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        console.log(res);
                        this_.tableData = res.data;
                    },
                    error:function () {
                        alert("服务器错误");
                    }
                })
            },
            doDel:function (row) {
                if(confirm("是否确定删除本记录(注：此处删除系统数据库也会删除对应信息)")){
                    $.ajax({
                        url:"/userInfo/adminDelete",
                        data:{
                            userId:row.userId
                        },
                        type:"post",
                        dataType: "json",
                        success:function (res) {
                            if(res.status==200){
                                alert("删除成功！");
                                location.reload();
                            }
                        },
                        error:function () {
                            alert("服务器错误呀");
                        }
                    })
                }
            },
            doEdit:function (row) {
                window.location="/userInfo/toChange?userId="+row.userId
            },
        }
    })
</script>
</body>
</html>
