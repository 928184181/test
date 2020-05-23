<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>商品详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/goodsdetails.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/goodsdetails.js"></script>
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
    <a class="nav" id="navid" href="${pageContext.request.contextPath }/toSysmain.do">首页</a><a class="nav0" href="${pageContext.request.contextPath }/tosecondhand.do">二手商品</a><a class="nav" href="${pageContext.request.contextPath}/tomessage.do">最新资讯</a><a class="nav" href="${pageContext.request.contextPath}/tonewaction.do">最新活动</a><a class="nav" href="${pageContext.request.contextPath }/tonewjob.do">兼职信息</a><a class="nav" href="${pageContext.request.contextPath }/tolostandfound.do">失物招领</a><a class="nav" href="${pageContext.request.contextPath }/topublish.do">我要发贴</a>
</div>
<div class="middle">
    <c:if test="${empty goods.pictureName}">
        <img class="goods" src="${pageContext.request.contextPath }/statics/sysimgs/dianzi.png"/>
    </c:if>
<c:if test="${not empty goods.pictureName}">
    <img class="goods" src="${pageContext.request.contextPath }/statics/goods/${goods.pictureName}"/>
</c:if>
    <div class="middle1">
        <input type="hidden" id="goodsId" value="${goods.id}"/>
        <input type="hidden" id="userId" value="${user.id}"/>
        <p><span class="sp1">名称</span><span class="sp2">${goods.title}</span></p>
        <p><span class="sp1">单价</span><span class="sp3">￥</span><span class="sp3" id="price">${goods.price}</span>元</p>
        <p><span class="sp1">描述</span></p>
        <p><textarea readonly>${goods.content}</textarea></p>
        <div class="j_nums">
            <input type="text" id="count" readonly value="1"class="n_ipt"/>
            <input type="button" value="+" class="n_btn_1"/>
            <input type="button" value="-" class="n_btn_2"/>
        </div>
        <p class="p1"><span class="sp3">￥</span><span class="sp3" id="prices">${goods.price}</span></p>
        <p><span class="sp1">卖家</span><span class="sp4">${goods.userName}</span></p>
        <p><span class="sp1">手机</span><span class="sp4">${goods.phone}</span></p>
        <p><span class="sp1">QQ</span><span class="sp4">${goods.qq}</span></p>
        <p><span class="sp1">微信</span><span class="sp4">${goods.weixin}</span></p>
        <input class="buy" type="button" value="立即购买"/>
        <input class="back" type="button" onclick="javascript:history.back(-1);" value="返回"/>
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
