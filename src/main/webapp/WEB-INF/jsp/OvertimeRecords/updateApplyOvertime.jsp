<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>加班申请</title>
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
            margin-left: 30px;
        }

        .row {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<div class="row" id="init_zone">
    <div class="col-md-4">
        <br>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane active in" id="home">
                <form id="tab">

                    <div class="form-group">
                        <label>申请编号</label>
                        <input type="text" placeholder="申请编号" class="form-control" v-model="id"/>
                    </div>
                    <div class="form-group">
                        <label>员工编号</label>
                        <input type="text" placeholder="员工编号" class="form-control" v-model="user_id"/>
                    </div>


                    <div class="form-group">
                        <label>开始时间</label>
                        <input type="date" placeholder="开始时间" class="form-control" v-model="start_time"/>
                    </div>

                    <div class="form-group">
                        <label>结束时间</label>
                        <input type="date" placeholder="结束时间" class="form-control" v-model="end_time"/>
                    </div>

                    <div class="form-group">
                        <label>地点</label>
                        <input type="text" placeholder="地点" class="form-control" v-model="place"/>
                    </div>

                    <div class="form-group">
                        <label>审核状态</label>
                        <input type="text" placeholder="审核状态" class="form-control" v-model="audit_status" disabled/>
                    </div>
                </form>
            </div>
            <div class="btn-toolbar list-toolbar">

                <button class="btn btn-primary" @click="doUpdate" type="button"><i class="fa fa-save"></i> 反提交</button>
                <button class="btn btn-primary" @click="doRes" type="button"><i class="fa fa-save"></i> 返回</button>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/vue.js"></script>
<script>
    var context = "<%=request.getContextPath()%>";
    new Vue({
        el: "#init_zone",
        data: {
            id:"",
            user_id: "",
            start_time: "",
            end_time: "",
            place: "",
            audit_status: 0,
        },
        methods: {
            doRes: function () {
                window.location.href=context+"/toPage?page=OvertimeRecords/showApplyOvertime";
            },
            doUpdate: function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/updateOvertimeRecords",
                    data: {
                        id: this.id,
                        userId: this.user_id,
                        startTime:this.start_time,
                        endTime:this.end_time,
                        place:this.place,
                        auditStatus:this.audit_status,
                    },
                    type:"post",
                    dataType: "json",
                    success: function () {
                        window.location.href=context+"/toPage?page=OvertimeRecords/showApplyOvertime";
                    },
                    error:function () {
                        alert("成功");
                    }
                })
            },

          },
        mounted: function () {
            const this_ = this;
            $.ajax({
                url: "${pageContext.request.contextPath}/toSerachOvertime",
                type: "post",
                dataType: "json",
                success: function (res) {
                    this_.user_id = res.data.userId;
                    this_.start_time = res.data.startTime;
                    this_.end_time = res.data.endTime;
                    this_.place = res.data.place;
                    this_.id = res.data.id;
                    console.log(res);
                },
                error: function () {
                    alert("服务器发生错误");
                }
            })
        },



    })
</script>

</body>
</html>