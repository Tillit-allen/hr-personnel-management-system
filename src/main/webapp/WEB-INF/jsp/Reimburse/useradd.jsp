<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2019/1/9
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>出差报销提交</title>
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
        .col-md-4 {
            margin-left: 30%;
        }
        .row {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<div class="row" id="init_zone"  >
    <div class="col-md-4">
        <br>
        <div id="myTabContent" class="tab-content" >
            <div class="tab-pane active in" id="home">
                <form id="tab" method="post" action="${pageContext.request.contextPath}/BusinessRecord/addBRecord">
                    <div class="form-group">
                        <label>路程花费</label>
                        <input type="text" placeholder="费用" class="form-control" name="a" v-model="money"/>
                    </div>
                    <div class="form-group">
                        <label>住宿费用</label>
                        <input type="text" placeholder="费用" class="form-control" name="b" v-model="money"/>
                    </div>
                    <div class="form-group">
                        <label>通信费用</label>
                        <input type="text" placeholder="费用" class="form-control" name="c" v-model="money"/>
                    </div>

                    <div class="form-group">
                        <label>饮食费用</label>
                        <input type="text" placeholder="费用" class="form-control"  name="d" v-model="money"/>
                    </div>

                    <div class="form-group">
                        <label>其他费用</label>
                        <input type="text" placeholder="费用" class="form-control" name="e" v-model="money"/>
                    </div>
                    <div class="form-group">
                        <label>开始时间</label>
                        <input type="text" placeholder="开始" class="form-control" name="startTime" v-model="startTime"/>
                    </div>
                    <div class="form-group">
                        <label>结束时间</label>
                        <input type="text" placeholder="结束" class="form-control" name="endTime" v-model="endTime"/>
                    </div>
                    <div class="form-group">
                        <label>目的地</label>
                        <input type="text" placeholder="目的地" class="form-control"  name="aim" v-model="aim"/>
                    </div>
                    <div class="btn-toolbar list-toolbar">
                        <input class="btn btn-primary" type="submit" value="提交"/>
                        <a data-toggle="modal" class="btn btn-danger" @click="doRes">重置</a>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/vue.js"></script>
<script>
    function  submitForm() {
        var frm = document.getElementById("tab");
        frm.submit();
    }
</script>
</body>
</html>

