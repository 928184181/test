<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>最新活动详情</title>
    <link href="${pageContext.request.contextPath}/statics/css/newslook.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/newslook.js"></script>
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
    <a class="nav" id="navid" href="${pageContext.request.contextPath }/toSysmain.do">首页</a><a class="nav" href="${pageContext.request.contextPath }/tosecondhand.do">二手商品</a><a class="nav0" href="${pageContext.request.contextPath}/tomessage.do">最新资讯</a><a class="nav" href="${pageContext.request.contextPath}/tonewaction.do">最新活动</a><a class="nav" href="${pageContext.request.contextPath }/tonewjob.do">兼职信息</a><a class="nav" href="${pageContext.request.contextPath }/tolostandfound.do">失物招领</a><a class="nav" href="${pageContext.request.contextPath }/topublish.do">我要发贴</a>
</div>
<div class="middle">
    <div class="middle0">
        <input class="fb" onclick="javascript:history.back(-1);" type="button" value="返回"/>
    </div>
    <div class="middle1">
        <p><span class="span1">标题</span><input class="inp" type="text" value="${newsLook.title}" readonly/></p>
        <p><span class="span1">内容</span></p>
        <textarea class="text" readonly>${newsLook.content}</textarea>
        <p><span class="span1">发布时间</span><input class="inp2" type="text" value="${newsLook.date}"  readonly/><span class="span3">点击量</span><input class="inp2" type="text" value="${newsLook.clicks}"  readonly/></p>
        <p><span class="span1">发布人</span><input class="inp2" type="text" value="${newsLook.userName}"  readonly/></p>
        <div class="middle2">
            <c:if test="${ not empty newsLook.pictureName1}">
                <img class="imgs" src="${pageContext.request.contextPath}/statics/news/${newsLook.pictureName1}"/>
            </c:if>
            <c:if test="${ not empty newsLook.pictureName2}">
                <img class="imgs" src="${pageContext.request.contextPath}/statics/news/${newsLook.pictureName2}"/>
            </c:if>
            <c:if test="${ not empty newsLook.pictureName3}">
                <img class="imgs" src="${pageContext.request.contextPath}/statics/news/${newsLook.pictureName3}"/>
            </c:if>
            <c:if test="${ not empty newsLook.pictureName4}">
                <img class="imgs" src="${pageContext.request.contextPath}/statics/news/${newsLook.pictureName4}"/>
            </c:if>
        </div>
        <p class="plq">评论区</p>
        <div class="middle4">
            <textarea class="text2"></textarea><input type="button" class="but" value="发布评论"/>
            <input type="hidden" id="newsId" value="${newsLook.id}"/>
            <input type="hidden" id="userId" value="${user.id}"/>
        </div>
        <c:if test="${not empty pageSupport.list}">
        <div class="middle3">
            <ul class="uul">
                <c:forEach var="comment" items="${pageSupport.list}">
                    <li><div class="lidiv"><p class="name">${comment.userName}</p><p class="name1">${comment.date}</p></div><textarea class="text1" readonly>${comment.content}</textarea></li>
                </c:forEach>
            </ul>
        </div>
        <div class="page">
            <span class="pagecount">共有<span id="count">${pageSupport.totalPage}</span>页</span><a href="javascript:void(0);" id="shouye" class="apage">首页</a><a href="javascript:void(0);" id="sy" class="apage">上一页</a><span class="current">当前第</span><span id="currentPage">${pageSupport.currentPage}</span><span class="current">页</span><a href="javascript:void(0);" id="xy" class="apage1">下一页</a><a href="javascript:void(0);" id="moye" class="apage">末页</a>
        </div>
        </c:if>
        <c:if test="${empty pageSupport.list}">
        <div class="pageno">
            <p class="pno">还没有任何评论，快来抢个沙发吧！</p>
        </div>
        </c:if>
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