<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>后台管理系统--失物招领审核</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/backlost.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/backlost.js"></script>
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
    <a class="nav" href="${pageContext.request.contextPath}/toAdmin.do">最新活动审核</a><a class="nav" href="${pageContext.request.contextPath}/tobacknews.do">最新资讯审核</a><a class="nav0" href="${pageContext.request.contextPath}/tobacklost.do">失物招领审核</a><a class="nav" href="${pageContext.request.contextPath}/tobackjob.do">兼职信息审核</a><a class="nav" href="${pageContext.request.contextPath}/tobackgoods.do">二手商品审核</a><a class="nav" href="${pageContext.request.contextPath}/tobackusers.do">用户管理</a>
</div>
<div class="middle">
    <div class="middle0">
        <input class="fb" type="button" id="all" value="所有物品"/><input class="fb" id="audit" type="button" value="待审核"/>
    </div>
    <div class="middle1">
        <span class="sp1">所在校区</span>
        <select id="sel">
            <option value="0">--全部--</option>
            <option value="1">北校区</option>
            <option value="2">南校区</option>
            <option value="3">葫芦岛校区</option>
        </select>
        <p class="pcount">共<span id="totalCount">${pageSupport.totalCount}</span>个遗失物品</p>
        <p class="psearch"><input type="text" id="search" placeholder="请输入关键字"  onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"/><input id="imgsearch" type="image" src="${pageContext.request.contextPath }/statics/sysimgs/search.png"/></p>
    </div>
    <div class="middle2">
        <ul class="uul">
            <li><span class="cona0">名称</span><span class="spanftr0">状态</span><span class="spantime0">发布时间</span><span class="spancount0">操作</span></li>
            <c:forEach var="news" items="${pageSupport.list}">
                <li><a class="cona" href="${pageContext.request.contextPath}/backlostlook.do?id=${news.id}&pageIndex=${pageSupport.currentPage}">${news.title}</a><span class="spanftr">${news.statusName}</span><span class="spantime">${news.date}</span><a class="spancount" href="${pageContext.request.contextPath}/backlostlook.do?id=${news.id}&pageIndex=${pageSupport.currentPage}">查看</a><a class="spancount1" href="" onclick="del(${news.id})">删除</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="page">
        <span class="pagecount">共有<span id="count">${pageSupport.totalPage}</span>页</span><a href="javascript:void(0);" id="shouye" class="apage">首页</a><a href="javascript:void(0);" id="sy" class="apage">上一页</a><span class="current">当前第</span><span id="currentPage">${pageSupport.currentPage}</span><span class="current">页</span><a href="javascript:void(0);" id="xy" class="apage1">下一页</a><a href="javascript:void(0);" id="moye" class="apage">末页</a>
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
