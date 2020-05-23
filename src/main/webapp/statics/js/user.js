$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    var flag = "buy";
    $("#buy").click(function () {
        flag = "buy";
        var userId = $("#userId").val();
        $.post("buyorderaj.do","pageIndex=1&userId="+userId+"&flag="+flag,function (data) {
            var str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">卖家名称</span><span class=\"span0\">卖家电话</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span3\">"+list[i]["goodsName"]+"</span><span class=\"span3\">"+list[i]["orderNum"]+"</span><span class=\"span1\">"+list[i]["price"]+"</span><span class=\"span1\">"+list[i]["count"]+"</span><span class=\"span1\">"+list[i]["date"]+"</span><span class=\"span1\">"+list[i]["sellerName"]+"</span><span class=\"span1\">"+list[i]["sellerPhone"]+"</span></li>";
            }
            $(".uul").html(str);
            $("#count").html(data["totalPage"]);
            $("#currentPage").html(1);
        },"JSON");
    });
    $("#seller").click(function () {
        flag = "seller";
        var userId = $("#userId").val();
        $.post("buyorderaj.do","pageIndex=1&userId="+userId+"&flag="+flag,function (data) {
            var str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">卖家名称</span><span class=\"span0\">卖家电话</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span3\">"+list[i]["goodsName"]+"</span><span class=\"span3\">"+list[i]["orderNum"]+"</span><span class=\"span1\">"+list[i]["price"]+"</span><span class=\"span1\">"+list[i]["count"]+"</span><span class=\"span1\">"+list[i]["date"]+"</span><span class=\"span1\">"+list[i]["sellerName"]+"</span><span class=\"span1\">"+list[i]["sellerPhone"]+"</span></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(1);
            $("#count").html(data["totalPage"]);
        },"JSON");
    })

    $("#shouye").click(function () {
        var userId = $("#userId").val();
        var str="";
        if(flag == "buy"){
            str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">卖家名称</span><span class=\"span0\">卖家电话</span></li>";
        }else {
            str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">买家名称</span><span class=\"span0\">买家电话</span></li>";
        }
        $.post("buyorderaj.do","pageIndex=1&userId="+userId+"&flag="+flag,function (data) {
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span3\">"+list[i]["goodsName"]+"</span><span class=\"span3\">"+list[i]["orderNum"]+"</span><span class=\"span1\">"+list[i]["price"]+"</span><span class=\"span1\">"+list[i]["count"]+"</span><span class=\"span1\">"+list[i]["date"]+"</span><span class=\"span1\">"+list[i]["sellerName"]+"</span><span class=\"span1\">"+list[i]["sellerPhone"]+"</span></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(1);
        },"JSON");
    });
    $("#moye").click(function () {
        var pageIndex = $("#count").text();
        var pageCount = $("#count").text();
        var userId = $("#userId").val();
        var str="";
        if(flag == "buy"){
            str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">卖家名称</span><span class=\"span0\">卖家电话</span></li>";
        }else {
            str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">买家名称</span><span class=\"span0\">买家电话</span></li>";
        }
        $.post("buyorderaj.do","pageIndex="+pageIndex+"&userId="+userId+"&flag="+flag,function (data) {
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span3\">"+list[i]["goodsName"]+"</span><span class=\"span3\">"+list[i]["orderNum"]+"</span><span class=\"span1\">"+list[i]["price"]+"</span><span class=\"span1\">"+list[i]["count"]+"</span><span class=\"span1\">"+list[i]["date"]+"</span><span class=\"span1\">"+list[i]["sellerName"]+"</span><span class=\"span1\">"+list[i]["sellerPhone"]+"</span></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageCount);
        },"JSON");
    });
    $("#sy").click(function () {
        var pageIndex = $("#currentPage").text();
        var userId = $("#userId").val();
        var str="";
        if(flag == "buy"){
            str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">卖家名称</span><span class=\"span0\">卖家电话</span></li>";
        }else {
            str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">买家名称</span><span class=\"span0\">买家电话</span></li>";
        }
        pageIndex--;
        if(pageIndex < 1){
            pageIndex = 1;
        }
        $.post("buyorderaj.do","pageIndex="+pageIndex+"&userId="+userId+"&flag="+flag,function (data) {
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span3\">"+list[i]["goodsName"]+"</span><span class=\"span3\">"+list[i]["orderNum"]+"</span><span class=\"span1\">"+list[i]["price"]+"</span><span class=\"span1\">"+list[i]["count"]+"</span><span class=\"span1\">"+list[i]["date"]+"</span><span class=\"span1\">"+list[i]["sellerName"]+"</span><span class=\"span1\">"+list[i]["sellerPhone"]+"</span></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageIndex);
        },"JSON");
    });
    $("#xy").click(function () {
        var pageIndex = $("#currentPage").text();
        var totalCount = $("#count").text();
        var userId = $("#userId").val();
        var str="";
        if(flag == "buy"){
            str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">卖家名称</span><span class=\"span0\">卖家电话</span></li>";
        }else {
            str = "<li><span class=\"span2\">商品名称</span><span class=\"span2\">订单号</span><span class=\"span0\">价格</span><span class=\"span0\">数量</span><span class=\"span0\">交易时间</span><span class=\"span0\">买家名称</span><span class=\"span0\">买家电话</span></li>";
        }
        pageIndex++;
        if(pageIndex > totalCount){
            pageIndex = totalCount;
        }
        $.post("buyorderaj.do","pageIndex="+pageIndex+"&userId="+userId+"&flag="+flag,function (data) {
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span3\">"+list[i]["goodsName"]+"</span><span class=\"span3\">"+list[i]["orderNum"]+"</span><span class=\"span1\">"+list[i]["price"]+"</span><span class=\"span1\">"+list[i]["count"]+"</span><span class=\"span1\">"+list[i]["date"]+"</span><span class=\"span1\">"+list[i]["sellerName"]+"</span><span class=\"span1\">"+list[i]["sellerPhone"]+"</span></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageIndex);
        },"JSON");
    });


    $("#shouye1").click(function () {
        var userId = $("#userId").val();
        $.post("usergoodsaj.do","pageIndex=1&userId="+userId,function (data) {
            var str = "<li><span class=\"span4\">商品名称</span><span class=\"span5\">状态</span><span class=\"span5\">上架时间</span><span class=\"span4\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span41\">"+list[i]["title"]+"</span><span class=\"span51\">"+list[i]["statusName"]+"</span><span class=\"span51\">"+list[i]["date"]+"</span><a class=\"a2\" href=\"tousergoods.do?id="+list[i]["id"]+"\">查看</a><a class=\"a3\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul1").html(str);
            $("#currentPage1").html(1);
        },"JSON");
    });
    $("#moye1").click(function () {
        var pageIndex = $("#count1").text();
        var pageCount = $("#count1").text();
        var userId = $("#userId").val();
        $.post("usergoodsaj.do","pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"span4\">商品名称</span><span class=\"span5\">状态</span><span class=\"span5\">上架时间</span><span class=\"span4\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span41\">"+list[i]["title"]+"</span><span class=\"span51\">"+list[i]["statusName"]+"</span><span class=\"span51\">"+list[i]["date"]+"</span><a class=\"a2\" href=\"tousergoods.do?id="+list[i]["id"]+"\">查看</a><a class=\"a3\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul1").html(str);
            $("#currentPage1").html(pageCount);
        },"JSON");
    });
    $("#sy1").click(function () {
        var pageIndex = $("#currentPage1").text();
        var userId = $("#userId").val();
        pageIndex--;
        if(pageIndex < 1){
            pageIndex = 1;
        }
        $.post("usergoodsaj.do","pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"span4\">商品名称</span><span class=\"span5\">状态</span><span class=\"span5\">上架时间</span><span class=\"span4\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span41\">"+list[i]["title"]+"</span><span class=\"span51\">"+list[i]["statusName"]+"</span><span class=\"span51\">"+list[i]["date"]+"</span><a class=\"a2\" href=\"tousergoods.do?id="+list[i]["id"]+"\">查看</a><a class=\"a3\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul1").html(str);
            $("#currentPage1").html(pageIndex);
        },"JSON");
    });
    $("#xy1").click(function () {
        var pageIndex = $("#currentPage1").text();
        var totalCount = $("#count1").text();
        var userId = $("#userId").val();
        pageIndex++;
        if(pageIndex > totalCount){
            pageIndex = totalCount;
        }
        $.post("usergoodsaj.do","pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"span4\">商品名称</span><span class=\"span5\">状态</span><span class=\"span5\">上架时间</span><span class=\"span4\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span41\">"+list[i]["title"]+"</span><span class=\"span51\">"+list[i]["statusName"]+"</span><span class=\"span51\">"+list[i]["date"]+"</span><a class=\"a2\" href=\"tousergoods.do?id="+list[i]["id"]+"\">查看</a><a class=\"a3\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul1").html(str);
            $("#currentPage1").html(pageIndex);
        },"JSON");
    });
});
function del(id) {
    if(confirm("确定要删除该物品吗？")){
        var pageIndex = $("#currentPage1").text();
        var userId = $("#userId").val();
        $.post("usergoodsdel.do","id="+id+"&pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"span4\">商品名称</span><span class=\"span5\">状态</span><span class=\"span5\">上架时间</span><span class=\"span4\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><span class=\"span41\">"+list[i]["title"]+"</span><span class=\"span51\">"+list[i]["statusName"]+"</span><span class=\"span51\">"+list[i]["date"]+"</span><a class=\"a2\" href=\"tousergoods.do?id="+list[i]["id"]+"\">查看</a><a class=\"a3\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul1").html(str);
        },"JSON");
    }
}