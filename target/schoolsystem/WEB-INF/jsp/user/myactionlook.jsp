<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>查看最新活动</title>
    <link href="${pageContext.request.contextPath}/statics/css/myactionlook.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/myactionlook.js"></script>
</head>
<body>
<div class="header">
    <div id="time"><div class="header0">欢迎你！<span id="user">${user.userName}</span><a href="${pageContext.request.contextPath }/touser.do?id=${user.id}" id="myuser">我的用户</a></div><span id="times">2020年1月1日 11:11 星期一</span></div>
</div>
<div class="header1">
    <img class="imgheader" src="${pageContext.request.contextPath}/statics/sysimgs/header.png"/>
    <p class="title">学生综合平台</p>
</div>
<div class="header2">
    <a class="nav" id="navid" href="${pageContext.request.contextPath }/toSysmain.do">首页</a><a class="nav" href="${pageContext.request.contextPath }/tosecondhand.do">二手商品</a><a class="nav" href="${pageContext.request.contextPath}/tomessage.do">最新资讯</a><a class="nav0" href="${pageContext.request.contextPath}/tonewaction.do">最新活动</a><a class="nav" href="${pageContext.request.contextPath }/tonewjob.do">兼职信息</a><a class="nav" href="${pageContext.request.contextPath }/tolostandfound.do">失物招领</a><a class="nav" href="${pageContext.request.contextPath }/topublish.do">我要发贴</a>
</div>
<div class="middle">
    <div class="middle0">
        <input class="fb" onclick="javascript:history.back(-1);" type="button" value="返回"/>
    </div>
    <div class="middle1">
        <p><span class="span1">标题</span><input class="inp" type="text" value="${myActionlook.title}" readonly/></p>
        <p><span class="span1">内容</span></p>
        <textarea class="text" readonly>${myActionlook.content}</textarea>
        <p><span class="span1">发布时间</span><input class="inp2" type="text" value="${myActionlook.date}" readonly/><span class="span3">点击量</span><input class="inp2" type="text" value="${myActionlook.clicks}" readonly/></p>
        <div class="middle2">
            <c:if test="${not empty myActionlook.pictureName1}">
            <img class="imgs" src="${pageContext.request.contextPath}/statics/action/${myActionlook.pictureName1}"/>
            </c:if>
            <c:if test="${not empty myActionlook.pictureName2}">
                <img class="imgs" src="${pageContext.request.contextPath}/statics/action/${myActionlook.pictureName2}"/>
            </c:if>
            <c:if test="${not empty myActionlook.pictureName3}">
                <img class="imgs" src="${pageContext.request.contextPath}/statics/action/${myActionlook.pictureName3}"/>
            </c:if>
            <c:if test="${not empty myActionlook.pictureName4}">
                <img class="imgs" src="${pageContext.request.contextPath}/statics/action/${myActionlook.pictureName4}"/>
            </c:if>
        </div>
    </div>
</div>
<div class="footer">
    <div class="bottom">
        <img class="imgbottom" src="${pageContext.request.contextPath}/statics/sysimgs/bottom.png"/>
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