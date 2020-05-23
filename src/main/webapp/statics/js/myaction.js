$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    $("#shouye").click(function () {
        var userId = $("#userId").val();
        $.post("mynewactionpublishaj.do","pageIndex=1&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" href='' onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(1);
        },"JSON");
    });
    $("#moye").click(function () {
        var pageIndex = $("#count").text();
        var pageCount = $("#count").text();
        var userId = $("#userId").val();
        $.post("mynewactionpublishaj.do","pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" href='' onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageCount);
        },"JSON");
    });
    $("#sy").click(function () {
        var pageIndex = $("#currentPage").text();
        var userId = $("#userId").val();
        pageIndex--;
        if(pageIndex < 1){
            pageIndex = 1;
        }
        $.post("mynewactionpublishaj.do","pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" href='' onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageIndex);
        },"JSON");
    });
    $("#xy").click(function () {
        var pageIndex = $("#currentPage").text();
        var totalCount = $("#count").text();
        var userId = $("#userId").val();
        pageIndex++;
        if(pageIndex > totalCount){
            pageIndex = totalCount;
        }
        $.post("mynewactionpublishaj.do","pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" href='' onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageIndex);
        },"JSON");
    });

    $(".fb").click(function(){
        window.location.href="tonewaction.do";
    })
});
function del(id) {
    if(confirm("确定要删除该帖子吗？")){
        var pageIndex = $("#currentPage").text();
        var userId = $("#userId").val();
        $.post("mynewsactiondel.do","id="+id+"&pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"mynewactionlook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" href='' onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
        },"JSON");
    }
}