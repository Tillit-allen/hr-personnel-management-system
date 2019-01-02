<%--
  Created by IntelliJ IDEA.
  User: lihang
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
                fixed="right"
                label="操作"
                width="100">
            <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
                <el-button type="text" size="small">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
</div>

</body>
</html>
