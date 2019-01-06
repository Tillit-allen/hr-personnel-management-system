<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/1/6
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>签到结果</title>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
</head>
<body>
<div class="panel panel-default" style="margin-top: 10px;">
    <p class="panel-heading">签到结果反馈</p>
    <div class="panel-body">
        <div>
            <span id="time"></span>
        </div>
    </div>
</div>
</body>
<script language="JavaScript">

    function result() {
        var number = <%=request.getAttribute("number")%>;
        var time = <%=request.getAttribute("time")%>
        var text=null;
        if (number == 0){
            if (time == 1){
                text = "准时签到成功！";
            } else if (time == 2){
                text = "您的签到结果为：小迟到。";
            } else if (time == 3){
                text = "您的签到结果为：大迟到。";
            }else {
                text = "出现错误！";
            }
        }else if(number == 1){

            if (time == 1){
                text = "未到签退时间";
            }else if(time == 3){
                text = "签退成功";
            }else {
                text = "出现错误";
            }
        }else if (number == 2){
                text = "当天已经签退！";
        } else {
            text = "出现了错误";
        }document.getElementById('time').innerHTML = text;
    }
    result();

</script>
</html>
