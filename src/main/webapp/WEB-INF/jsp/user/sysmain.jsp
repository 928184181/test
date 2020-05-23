<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>辽工大学生综合平台</title>
    <link href="${pageContext.request.contextPath }/statics/css/sysmain.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/statics/js/sysmain.js" type="text/javascript"></script>
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
    <a class="nav0" id="navid" href="${pageContext.request.contextPath }/toSysmain.do">首页</a><a class="nav" href="${pageContext.request.contextPath }/tosecondhand.do">二手商品</a><a class="nav" href="${pageContext.request.contextPath}/tomessage.do">最新资讯</a><a class="nav" href="${pageContext.request.contextPath}/tonewaction.do">最新活动</a><a class="nav" href="${pageContext.request.contextPath }/tonewjob.do">兼职信息</a><a class="nav" href="${pageContext.request.contextPath }/tolostandfound.do">失物招领</a><a class="nav" href="${pageContext.request.contextPath }/topublish.do">我要发贴</a>
</div>
<div class="middle">
    <div class="esgoods">
        <p class="essp">二手商品</p>
        <p class="more"><a class="more" href="${pageContext.request.contextPath }/tosecondhand.do">more>></a></p>
        <hr width=840 size=2 color=brown>
        <c:forEach var="goods" items="${goodsList}">
        <div class="goods" name="${goods.id}">
            <c:if test="${not empty goods.pictureName}">
                <img class="imggoods" src="${pageContext.request.contextPath }/statics/goods/${goods.pictureName}"/>
            </c:if>
            <c:if test="${empty goods.pictureName}">
                <img class="imggoods" src="${pageContext.request.contextPath }/statics/sysimgs/dianzi.png"/>
            </c:if>
            <p class="goodsname">${goods.title}</p>
            <p class="price">￥<span class="price1">${goods.price}</span><span class="price2">元</span></p>
        </div>
        </c:forEach>
    </div>
    <div class="consult">
        <p class="cont">最新资讯</p>
        <div  class="express">
            <ul>
                <div id="express1">
                    <c:forEach var="News" items="${newsList}">
                        <li class="lip"><a class="cona" href="tonewslook.do?id=${News.id}">${News.title}</a></li>
                    </c:forEach>
                </div>
            </ul>
        </div>
    </div>
</div>
<div class="middle1">
    <div class="newaction">
        <p class="zxhd">最新活动</p>
        <p class="more"><a class="more" href="${pageContext.request.contextPath}/tonewaction.do">more>></a></p>
        <hr width=840 size=2 color=brown>
        <c:forEach items="${newActionList}" var="newAction">
        <div class="action" id="${newAction.id}">
            <img class="imgaction" src="${pageContext.request.contextPath}/statics/action/${newAction.pictureName1}"/>
            <p class="actionname">${newAction.title}</p>
            <p class="actiontime">${newAction.date}</p>
            <p class="actionadd">${newAction.userName}</p>
        </div>
        </c:forEach>
    </div>
    <div class="consult1">
        <p class="cont1"><img class="zhao" src="${pageContext.request.contextPath}/statics/sysimgs/zhao.png"/></p>
        <div  class="express">
            <ul>
                <div id="express2">
                    <c:forEach var="job" items="${jobList}">
                        <li class="lip"><a class="cona1" href="joblook.do?id=${job.id}">${job.title}</a></li>
                    </c:forEach>
                </div>
            </ul>
        </div>
    </div>
    <div class="Lostandfound">
        <p class="swzl">失物招领</p>
        <p class="more"><a class="more" href="${pageContext.request.contextPath }/tolostandfound.do">more>></a></p>
        <hr width=840 size=2 color=brown>
        <c:forEach var="lost" items="${lostList}">
        <div class="lostgoods" name="${lost.id}">
            <img class="imglostgoods" src="${pageContext.request.contextPath}/statics/lost/${lost.pictureName}"/>
            <p class="lostgoodsname">${lost.title}</p>
            <p class="lostgoodstime">${lost.schoolName}</p>
            <p class="lostgoodsadd">${lost.address}</p>
        </div>
        </c:forEach>
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
