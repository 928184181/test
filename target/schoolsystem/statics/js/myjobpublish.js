$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    $(".fb").click(function(){
        window.location.href="tonewjob.do";
    })
    $("#shouye").click(function () {
        var userId = $("#userId").val();
        $.post("myjobpublishaj.do","pageIndex=1&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(1);
        },"JSON");
    });
    $("#moye").click(function () {
        var pageIndex = $("#count").text();
        var pageCount = $("#count").text();
        var userId = $("#userId").val();
        $.post("myjobpublishaj.do","pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" onclick=del("+list[i]["id"]+")>删除</a></li>";
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
        $.post("myjobpublishaj.do","pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" onclick=del("+list[i]["id"]+")>删除</a></li>";
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
        $.post("myjobpublishaj.do","pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageIndex);
        },"JSON");
    });

});
function del(id) {
    if(confirm("确定要删除该兼职信息吗？")){
        var pageIndex = $("#currentPage").text();
        var userId = $("#userId").val();
        $.post("myjobdel.do","id="+id+"&pageIndex="+pageIndex+"&userId="+userId,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spantime0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spantime\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spanlook\" href=\"tomyjoblook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spandel\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
        },"JSON");
    }
}