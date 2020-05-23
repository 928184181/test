<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>管理员账号</title>
    <link href="${pageContext.request.contextPath }/statics/css/backadmin.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/backadmin.js"></script>
</head>
<body>
<div class="header">
    <div id="time"><div class="header0">欢迎你！<span id="user">${admin.userName}</span><a href="${pageContext.request.contextPath }/toadminchange.do?id=${admin.id}" id="myuser">我的用户</a></div><span id="times">2020年1月1日 11:11 星期一</span></div>
</div>
<div class="header1">
    <img class="imgheader" src="${pageContext.request.contextPath }/statics/sysimgs/header.png"/>
    <p class="title">学生综合平台后台管理</p>
</div>
<div class="header2">
    <a class="nav" href="${pageContext.request.contextPath}/toAdmin.do">最新活动审核</a><a class="nav" href="${pageContext.request.contextPath}/tobacknews.do">最新资讯审核</a><a class="nav" href="${pageContext.request.contextPath}/tobacklost.do">失物招领审核</a><a class="nav" href="${pageContext.request.contextPath}/tobackjob.do">兼职信息审核</a><a class="nav" href="${pageContext.request.contextPath}/tobackgoods.do">二手商品审核</a><a class="nav" href="${pageContext.request.contextPath}/tobackusers.do">用户管理</a>
</div>
<div class="middle">
    <div class="middle0">
        <input class="fb" onclick="javascript:history.back(-1);" type="button" value="返回"/>
    </div>
    <div class="middle1">
        <input type="hidden" id="adminId" value="${adminlook.id}"/>
        <p><span class="span2">账号</span><input class="inp" type="text" value="${adminlook.userCode}" readonly/></p>
        <p><span class="span2">用户名</span><input class="inp" id="userName" value="${adminlook.userName}" type="text"/></p>
        <p><span class="span2">密码</span><input class="inp" id="password" value="${adminlook.password}" type="text"/></p>
    </div>
    <div class="audit">
        <input class="fbau" id="pass" type="button" value="保存"/>
    </div>
</div>
<div class="footer">
    <div class="bottom">
        <img class="imgbottom" src="${pageContext.request.contextPath }/statics/sysimgs/bottom.png"/>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    function fn(){
        var time = new Date();
        var str= "";
        var year = time.getFullYear();
        var mon = time.getMonth()+1;
        var day = time.getDate();
        var h = time.getHours();
        var m = time.getMinutes();
        var s = time.getSeconds();
        var week = time.getDay();
        switch (week){
            case 0:week="日";
                break;
            case 1:week="一";
                break;
            case 2:week="二";
                break;
            case 3:week="三";
                break;
            case 4:week="四";
                break;
            case 5:week="五";
                break;
            case 6:week="六";
                break;
        }
        str = year +"年"+totwo(mon)+"月"+totwo(day)+"日"+"&nbsp;"+totwo(h)+":"+totwo(m)+":"+totwo(s)+"&nbsp;"+"星期"+week;
        $("#times").html(str)
    }
    fn();
    setInterval(fn,1000);
    function totwo(n){
        if(n<=9){
            return n = "0"+n;
        }
        else{
            return n =""+n;
        }
    }
</script>
