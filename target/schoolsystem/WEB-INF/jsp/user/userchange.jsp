
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>修改信息</title>
    <link href="${pageContext.request.contextPath }/statics/css/userchange.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userchange.js"></script>
</head>
<body>
<div class="header">
    <div id="time"><div class="header0">欢迎你！<span id="user">${user.userName}</span><a href="${pageContext.request.contextPath }/touser.do?id=${user.id}" id="myuser">我的用户</a></div><span id="times">2020年1月1日 11:11 星期一</span></div>
</div>
<div class="header1">
    <img class="imgheader" src="${pageContext.request.contextPath }/statics/sysimgs/header.png"/>
    <p class="title">学生综合平台</p>
</div>
<div class="header2">
    <a class="nav" id="navid" href="${pageContext.request.contextPath }/toSysmain.do">首页</a><a class="nav" href="${pageContext.request.contextPath }/tosecondhand.do">二手商品</a><a class="nav" href="${pageContext.request.contextPath}/tomessage.do">最新资讯</a><a class="nav" href="${pageContext.request.contextPath}/tonewaction.do">最新活动</a><a class="nav" href="${pageContext.request.contextPath }/tonewjob.do">兼职信息</a><a class="nav" href="${pageContext.request.contextPath }/tolostandfound.do">失物招领</a><a class="nav" href="${pageContext.request.contextPath }/topublish.do">我要发贴</a>
</div>
<div class="middle">
    <div class="middle0">
        <input class="fb" type="button" value="返回" onclick="javascript:history.back(-1);"/>
    </div>
    <div class="middle1">
        <form action="${pageContext.request.contextPath }/userchange.do?id=${user.id}" method="post">
            <p><span class="span1">昵称</span><input class="inp" name="userName" value="${users.userName}" type="text" maxlength="20"/></p>
            <p><span class="span1">密码</span><input id="password" class="inp"  value="${users.password}" name="password" type="text"/></p>
            <p><span class="span1">手机</span><input id="phone" class="inp"  value="${users.phone}" name="phone" type="text"/></p>
            <p><span class="span1">QQ</span><input id="qq" class="inp" name="qq"  value="${users.qq}" type="text"/></p>
            <p><span class="span1">微信</span><input id="wx" class="inp" name="weixin"  value="${users.weixin}" type="text" maxlength="20"/></p>
            <select  name="schoolId">
                <option value="1">北校区</option>
                <option value="2">南校区</option>
                <option value="3">葫芦岛校区</option>
            </select>
            <p class="p2"><input class="inp1" value="保存" type="submit"/><input type="reset" value="重置" class="inp1"/></p>
        </form>
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
