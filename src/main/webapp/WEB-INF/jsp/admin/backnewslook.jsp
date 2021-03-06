<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>最新资讯查看</title>
    <link href="${pageContext.request.contextPath }/statics/css/backnewslook.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/backnewslook.js"></script>
</head>
<body>
<div class="header">
    <div id="time"><div class="header0">欢迎你！<span id="user">${admin.userName}</span><a href="${pageContext.request.contextPath }/toadminchange.do?id=${admin.id}" id="myuser">我的用户</a></div><span id="times">2020年1月1日 11:11 星期一</span></div>
</div>
<div class="header1">
    <img class="imgheader" src="${pageContext.request.contextPath }/statics/sysimgs/header.png"/>
    <p class="title">学生综合平台后台管理</p>
</div>
<input type="hidden" id="newsId" value="${backnews.id}"/>
<div class="header2">
    <a class="nav" href="${pageContext.request.contextPath}/toAdmin.do">最新活动审核</a><a class="nav0" href="${pageContext.request.contextPath}/tobacknews.do">最新资讯审核</a><a class="nav" href="${pageContext.request.contextPath}/tobacklost.do">失物招领审核</a><a class="nav" href="${pageContext.request.contextPath}/tobackjob.do">兼职信息审核</a><a class="nav" href="${pageContext.request.contextPath}/tobackgoods.do">二手商品审核</a><a class="nav" href="${pageContext.request.contextPath}/tobackusers.do">用户管理</a>
</div>
<div class="middle">
    <div class="middle0">
        <input type="hidden" id="pageIndex" value="${pageIndex}"/>
        <input class="fb" type="button" value="返回"/>
    </div>
    <div class="middle1">
        <p><span class="span1">标题</span><input class="inp" type="text" value="${backnews.title}" readonly/></p>
        <p><span class="span1">内容</span></p>
        <textarea class="text" readonly>${backnews.content}</textarea>
        <div class="middle2">
            <c:if test="${not empty backnews.pictureName1}">
            <img class="imgs" src="${pageContext.request.contextPath }/statics/news/${backnews.pictureName1}">
            </c:if>
            <c:if test="${not empty backnews.pictureName2}">
                <img class="imgs" src="${pageContext.request.contextPath }/statics/news/${backnews.pictureName2}">
            </c:if>
            <c:if test="${not empty backnews.pictureName3}">
                <img class="imgs" src="${pageContext.request.contextPath }/statics/news/${backnews.pictureName3}">
            </c:if>
            <c:if test="${not empty backnews.pictureName4}">
                <img class="imgs" src="${pageContext.request.contextPath }/statics/news/${backnews.pictureName4}">
            </c:if>
        </div>
        <p><span class="span1">发布时间</span><input class="inp2" type="text" value="${backnews.date}" readonly/><span class="span3">发布人</span><input class="inp2" type="text" value="${backnews.userName}" readonly/></p>
        <p><span class="span2">发布人电话</span><input class="inp2" type="text" value="${backnews.phone}" readonly/></p>
        <p><span class="span2">发布人QQ</span><input class="inp2" type="text" value="${backnews.qq}" readonly/></p>
        <p><span class="span2">发布人微信</span><input class="inp2" type="text" value="${backnews.weixin}" readonly/></p>
    </div>
    <div class="audit">
        <input class="fbau" id="pass" type="button" value="通过"/><input class="fbau" id="nopass" type="button" value="不通过"/>
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