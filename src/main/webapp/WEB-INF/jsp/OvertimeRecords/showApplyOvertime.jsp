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
<div id="list_zone">
    <%--<input type="text" name="title">--%>

    <%--<button @click="doSalary">搜索</button>--%>
    <el-table
            :data="tableData"
            style="width: 100%">
        <el-table-column
                prop="id"
                label="申请编号"
                width="100rpx">
        </el-table-column>
        <el-table-column
                prop="userId"
                label="员工编号"
                width="100rpx">
        </el-table-column>

        <el-table-column
                prop="startTime"
                label="开始时间"
                width="100rpx">
        </el-table-column>
        <el-table-column
                prop="endTime"
                label="结束时间"
                width="100rpx">
        </el-table-column>
        <el-table-column
                prop="place"
                label="加班地点"
                width="100rpx">
        </el-table-column>
        <el-table-column
                prop="auditStatus"
                label="审核状态"
                width="100rpx">
        </el-table-column>
        <el-table-column
                fixed="right"
                label="操作"
                width="100rpx">
            <template slot-scope="scope">
                <el-button type="text" size="small" @click="doDel(scope.row)">删除</el-button>
                <el-button type="text" size="small" @click="doEdit(scope.row)">编辑</el-button>
            </template>
        </el-table-column>
    </el-table>

</div>
<script>
    var context = "<%=request.getContextPath()%>";
    new Vue({

        el:"#list_zone",
        data:{

            tableData:[]
        },

        //删除方法
        methods:{
            doDel:function (row) {
                if(confirm("是否确定删除本条记录")){

                    $.ajax({
                        url:"${pageContext.request.contextPath}/deleteOvertimeRecords",
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
                            alert("服务器出错");
                        }
                    })
                }

            },
            doEdit:function (row) {
                const this1 = this;
                $.ajax({
                    url:"${pageContext.request.contextPath}/getApplyOvertimeRecords1",
                    data:{
                        userId:row.userId
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res1) {
                        this1.tableData = res1.data;
                        window.location.href=context+"/toPage?page=OvertimeRecords/addApplyOvertime";
                        console.log(res1);
                    },
                    error:function () {

                    }
                })
            },
            doSearch:function () {

            }
        },
        mounted:function () {
            const this_ = this;
            $.ajax({
                url:"${pageContext.request.contextPath}/getApplyOvertime",
                data:{

                },
                type:"post",
                dataType:"json",
                success:function (res) {
                    this_.tableData = res.data;
                    console.log(res);
                },
                error:function () {
                    alert("服务器出错");
                }
            })
        }

    })
</script>
</body>
</html>