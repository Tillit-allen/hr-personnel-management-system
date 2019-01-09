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
<div id="list_zone" type="0">
    <input type="text" placeholder="请输入员工姓名"  class="form-control"  v-model="forSearch" />
    <button  @click="doSearch" type="1"><i class="fa fa-save"></i> 搜索</button>

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
                fixed="right"
                label="操作"
                width="100">
            <template slot-scope="scope">
                <el-button @click="doPass(scope.row)" type="text" size="small">通过</el-button>
                <el-button @click="doRefuse(scope.row)" type="text" size="small" >拒绝</el-button>
            </template>
        </el-table-column>
    </el-table>
</div>
<script>
    var context = "<%=request.getContextPath()%>";
    new Vue({
        el:"#list_zone",
        data:{
            tableData:[],
            forSearch:"",
        },
        methods:{
            doPass:function (row) {
                const this_ = this;
                $.ajax({
                    url:"${pageContext.request.contextPath}/checkOverTime_Pass",
                    data:{
                        id:row.id,
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        console.log(res);
                        if(res.status==200){
                            alert("通过成功！");
                            location.reload();
                        }else{
                            alert(res.smg);
                        }
                    },
                    error:function () {
                        alert("服务器错误");
                    }
                })

            },
            doRefuse:function (row) {
                $.ajax({
                    url:"${pageContext.request.contextPath}/checkOverTime_Reful",
                    data:{
                        id:row.id,
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        console.log(res);
                        if(res.status==200){
                            alert("已拒绝");
                            location.reload();
                        }else{
                            alert(res.smg);
                        }
                    },
                    error:function () {
                        alert("服务器错误");
                    }
                })

            },
            doSearch:function () {
                // var type = document.getElementById("searchName").value();
                // alert(this.forSearch);
                window.location="${pageContext.request.contextPath}/selectOvertimeRecords"+this.forSearch;


            },

        },

        mounted:function () {
            const this_ = this;
            $.ajax({
                url:"${pageContext.request.contextPath}/getApplyOvertimeRecords",
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