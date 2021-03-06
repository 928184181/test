<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>失物招领</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/lostandfound.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/lostandfound.js"></script>
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
    <a class="nav" id="navid" href="${pageContext.request.contextPath }/toSysmain.do">首页</a><a class="nav" href="${pageContext.request.contextPath }/tosecondhand.do">二手商品</a><a class="nav" href="${pageContext.request.contextPath}/tomessage.do">最新资讯</a><a class="nav" href="${pageContext.request.contextPath}/tonewaction.do">最新活动</a><a class="nav" href="${pageContext.request.contextPath }/tonewjob.do">兼职信息</a><a class="nav0" href="${pageContext.request.contextPath }/tolostandfound.do">失物招领</a><a class="nav" href="${pageContext.request.contextPath }/topublish.do">我要发贴</a>
</div>
<div class="middle">
    <input type="hidden" id="userId" value="${user.id}"/>
    <div class="middle0">
        <input class="fb" id="publish" type="button" value="失物发布"/><input class="fb" id="mypublish" type="button" value="我的发布"/>
    </div>
    <div class="middle1">
        <span class="sp1">所在校区</span>
        <select id="sel">
            <option value="0">--请选择--</option>
            <option value="1">北校区</option>
            <option value="2">南校区</option>
            <option value="3">葫芦岛校区</option>
        </select>
        <p class="pcount">共<span id="totalCount">${pageSupportLost.totalCount}</span>个遗失物品</p>
        <p class="psearch"><input type="text" id="search" placeholder="请输入关键字"  onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"/><input id="imgsearch" type="image" src="${pageContext.request.contextPath }/statics/sysimgs/search.png"/></p>
    </div>
    <div class="middle2">
        <c:forEach items="${pageSupportLost.list}" var="lost">
        <div class="goods" name="${lost.id}">
            <img src="${pageContext.request.contextPath }/statics/lost/${lost.pictureName}" class="imggoods"/>
            <p class="p2">
                ${lost.title}
            </p>
            <p class="p1">
                <span class="sp3">${lost.schoolName}</span>
            </p>
            <p class="p1">
                <span class="sp3">${lost.address}</span>
            </p>
        </div>
        </c:forEach>
    </div>
    <div class="page">
        <span class="pagecount">共有<span id="count">${pageSupportLost.totalPage}</span>页</span><a href="javascript:void(0);" id="shouye" class="apage">首页</a><a href="javascript:void(0);" id="sy" class="apage">上一页</a><span class="current">当前第</span><span id="currentPage">${pageSupportLost.currentPage}</span><span class="current">页</span><a href="javascript:void(0);" id="xy" class="apage1">下一页</a><a href="javascript:void(0);" id="moye" class="apage">末页</a>
    </div>
</div>
<div class="pageno">
    <p class="pno">抱歉！该条件无结果！</p>
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
