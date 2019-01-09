<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2018/12/28
  Time: 19:49
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
<div id="list_zone">
    <button @click="doSearch">查询</button>
    <button @click="doSalary">发工资</button>
    <el-table
            :data="tableData"
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <!-- `checked` 为 true 或 false -->
        <el-table-column
                type="selection"
                label="工资">
        </el-table-column>
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
    <div id="pagebutton">
        <span>第{{pageNum}}页</span>
        <span id="first"><button @click="tofirstPage" id="firstPage">首页</button></span>
        <span id="prev"><button @click="toprevPage" class="el-icon-arrow-left" id="prevPage"></button></span>
        <span id="next"><button @click="tonextPage" class="el-icon-arrow-right" id="nextPage"></button></span>
        <span id="end"><button @click="toendPage" id="endPage">尾页</button></span>
        <span>共{{total}}条数据  共{{lastPage}}页</span>
    </div>
</div>
<script>
    new Vue({
        el:"#list_zone",
        data:{
            tableData:[],
            pageNum:"",
            firstPage: 1,
            lastPage:"",
            total:"",
            multipleSelection: []
        },
        methods:{
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
                // alert(row.userId);
                window.location="/userInfo/toChange?userId="+row.userId
            },
            doSearch:function () {
                window.location="/toPage?page=employee/SearchEmployee";
            },
            handleSelectionChange:function(val) {
                this.multipleSelection = val;
                console.log(this.multipleSelection[0].userId)
            },
            doSalary:function () {
            },
            tochange_:function (row) {
                window.location="${pageContext.request.contextPath}/toChange?id="+row.id ;
            },
            //首页
            tofirstPage:function () {
                var this_ = this;
                $.ajax({
                    url:"/userInfo/getAllEmployee",
                    data:{
                        pageNum :1,
                    },
                    type:"post",
                    dataType:"json",
                    error:function () {
                        alert("error");
                    },
                    success:function (res) {
                        this_.tableData= res.data.list;
                        this_.pageNum = res.data.pageNum;
                    }
                })
            },
            //尾页
            toendPage:function () {
                var this_ = this;
                $.ajax({
                    url:"/userInfo/getAllEmployee",
                    data:{
                        pageNum :this_.lastPage,
                    },
                    type:"post",
                    dataType:"json",
                    error:function () {
                        alert("error");
                    },
                    success:function (res) {
                        this_.tableData= res.data.list;
                        this_.pageNum = res.data.pageNum;
                    }
                })
            },
            tonextPage:function () {
                var this_ = this;
                if(this_.pageNum==this_.lastPage){
                    this_.$message('已经是最后一页了');
                }else{
                    $.ajax({
                        url:"/userInfo/getAllEmployee",
                        data:{
                            pageNum :++this_.pageNum,
                        },
                        type:"post",
                        dataType:"json",
                        error:function () {
                            alert("error");
                        },
                        success:function (res) {
                            this_.tableData= res.data.list;
                            this_.pageNum = res.data.pageNum;
                        }
                    })
                }

            },
            toprevPage:function () {
                var this_ = this;
                if(this_.pageNum==1){
                    this_.$message('已经是第一页了');
                }else{
                    $.ajax({
                        url:"/userInfo/getAllEmployee",
                        data:{
                            pageNum :--this_.pageNum,
                        },
                        type:"post",
                        dataType:"json",
                        error:function () {
                            alert("error");
                        },
                        success:function (res) {
                            this_.tableData= res.data.list;
                            this_.pageNum = res.data.pageNum;
                        }
                    })
                }

            }
        },
        mounted:function () {
            const this_ = this;
            $.ajax({
                url:"${pageContext.request.contextPath}/userInfo/getAllEmployee",
                data:{
                    pageNum:""
                },
                type:"post",
                dataType:"json",
                success:function (res) {
                    this_.tableData = res.data.list;
                    this_.total = res.data.total;
                    this_.lastPage = res.data.pages;
                    this_.pageNum = res.data.pageNum;
                    console.log(res);
                },
                error:function () {

                }
            })
        }
        
    })
</script>
</body>
</html>
