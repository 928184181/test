<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的用户</title>
    <link href="${pageContext.request.contextPath }/statics/css/user.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/user.js"></script>
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
    <div class="my">
        <a class="a0" href="touserchange.do?id=${user.id}">修改信息</a>
    </div>
    <input id="userId" type="hidden" value="${user.id}"/>
    <div class="order">
        <p class="p1">我的订单<input class="but" type="button" id="buy" value="买入订单"/><input class="but" id="seller" type="button" value="卖出订单"/></p>
        <c:if test="${not empty pageSupportBuyOrder.list}">
        <div class="middle1">
            <ul class="uul">
                <li><span class="span2">商品名称</span><span class="span2">订单号</span><span class="span0">价格</span><span class="span0">数量</span><span class="span0">交易时间</span><span class="span0">卖家名称</span><span class="span0">卖家电话</span><span class="span0"></li>
                <c:forEach var="BuyOrder" items="${pageSupportBuyOrder.list}">
                <li><span class="span3">${BuyOrder.goodsName}</span><span class="span3">${BuyOrder.orderNum}</span><span class="span1">${BuyOrder.price}</span><span class="span1">${BuyOrder.count}</span><span class="span1">${BuyOrder.date}</span><span class="span1">${BuyOrder.sellerName}</span><span class="span1">${BuyOrder.sellerPhone}</span></li>
                </c:forEach>
            </ul>
            <div class="page">
                <span class="pagecount">共有<span id="count">${pageSupportBuyOrder.totalPage}</span>页</span><a href="javascript:void(0);" id="shouye" class="apage">首页</a><a href="javascript:void(0);" id="sy" class="apage">上一页</a><span class="current">当前第</span><span id="currentPage">${pageSupportBuyOrder.currentPage}</span><span class="current">页</span><a href="javascript:void(0);" id="xy" class="apage1">下一页</a><a href="javascript:void(0);" id="moye" class="apage">末页</a>
            </div>
        </div>
        </c:if>
        <c:if test="${empty pageSupportBuyOrder.list}">
        <div class="middle2">
            该订单无结果！
        </div>
        </c:if>
    </div>
    <div class="goods">
        <p class="p1">我的商品</p>
        <c:if test="${not empty pageSupportMyGoods.list}">
        <div class="middle1">
            <ul class="uul1">
                <li><span class="span4">商品名称</span><span class="span5">状态</span><span class="span5">上架时间</span><span class="span4">操作</span></li>
                <c:forEach items="${pageSupportMyGoods.list}" var="goods">
                <li><span class="span41">${goods.title}</span><span class="span51">${goods.statusName}</span><span class="span51">${goods.date}</span><a class="a2" href="${pageContext.request.contextPath}/tousergoods.do?id=${goods.id}">查看</a><a class="a3" href="" onclick="del(${goods.id})">删除</a></li>
                </c:forEach>
            </ul>
            <div class="page">
                <span class="pagecount">共有<span id="count1">${pageSupportMyGoods.totalPage}</span>页</span><a href="javascript:void(0);" id="shouye1" class="apage">首页</a><a href="javascript:void(0);" id="sy1" class="apage">上一页</a><span class="current">当前第</span><span id="currentPage1">${pageSupportMyGoods.currentPage}</span><span class="current">页</span><a href="javascript:void(0);" id="xy1" class="apage1">下一页</a><a href="javascript:void(0);" id="moye1" class="apage">末页</a>
            </div>
        </div>
        </c:if>
        <c:if test="${empty pageSupportMyGoods.list}">
        <div class="middle3">
            暂无商品！
        </div>
        </c:if>
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