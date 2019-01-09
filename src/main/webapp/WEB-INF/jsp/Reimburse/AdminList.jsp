<%--
Created by IntelliJ IDEA.
User: Msi
Date: 2018/12/29
Time: 13:56
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>
<body>
<div id="check_zone">
    <el-table
            :data="tableData"
            style="width: 100%">
        <el-table-column
                prop="id"
                label="ID"
                width="120">
        </el-table-column>
        <el-table-column
                prop="userId"
                label="员工ID"
                width="120">
        </el-table-column>
        <el-table-column
                prop="startTime"
                label="出差时间"
                width="200">
        </el-table-column>
        <el-table-column
                prop="endTime"
                label="回归时间"
                width="200">
        </el-table-column>
        <el-table-column
                prop="money"
                label="出差总花销"
                width="180">
        </el-table-column>
        <el-table-column
                prop="aim"
                label="目的地"
                width="auto">
        </el-table-column>

        <el-table-column
                fixed="right"
                label="操作"
                width="100">
            <template slot-scope="scope">
                <el-button @click="doPass(scope.row)" type="text" size="small">通过</el-button>
                <el-button type="text" size="small" @click="doRefuse(scope.row)">拒绝</el-button>
            </template>
        </el-table-column>
    </el-table>
</div>
<script>
    new Vue({
        el:"#check_zone",
        data:{
            tableData:[],
        },
        methods:{
            doPass:function (row) {
                if(confirm("是否审批提交?")){
                    this.doDo("true",row);
                }
            },
            doRefuse:function (row) {
                if(confirm("是否拒绝此提交?")) {
                    this.doDo("gun", row);
                }
            },
            doDo:function (flag,row) {
                $.ajax({
                    url:"/BusinessRecord/adminCheck",
                    data:{
                        flag:flag,
                        id:row.id,
                        userId:row.userId
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        console.log(res);
                        alert("完成");
                    },
                    error:function () {
                        alert("服务器错误！");
                    }
                })
            },
        },
        mounted:function () {
            const this_ = this;
            $.ajax({
                url:"/BusinessRecord/getData",
                data:{
                },
                type:"get",
                dataType:"json",
                success:function (res) {
                    this_.tableData = res.data;
                    console.log(res);
                },
                error:function () {
                    alert("服务器错误");
                }
            })
        }
    })
</script>
</body>
</html>
