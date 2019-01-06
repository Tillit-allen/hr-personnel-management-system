<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/1/6
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>当前状态</title>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
</head>
<body>
<div class="panel panel-default" style="margin-top: 10px;">
    <p class="panel-heading">员工当天签到情况</p>
    <div class="panel-body">
        <div>
            <span id="status"></span>
        </div>
    </div>
</div>
</body>
<script language="JavaScript">
    function status() {
        var number = ${attendanceRecordList0} ;
        var text;
        if (number == 0){
            text = "您今天还没有签到";
        }else if(number == "1"){
            text = "您今天准时签到";
        }else if (number == "2"){
            text =  "您今天小迟到";
        }else if(number == "3"){
            text = "您今天大迟到";
        }else  if (number == "4"){
            text = "您今天已签退";
        }document.getElementById('status').innerHTML = text;
    }
    status();
</script>
</html>
