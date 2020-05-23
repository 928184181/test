$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    //分页级联模糊查询
    var title = "";
    var schoolId = 0;
    var status = 0;
    $("#search").blur(function () {
        title = $(this).val();
    });
    $("#sel").change(function () {
        schoolId = $(this).val();
    });
    $("#all").click(function () {
        status = 0;
        var pos = "";
        if(title != ""){
            pos += "&title=" + title;
        }
        if(schoolId != 0){
            pos += "&school=" + schoolId;
        }
        if(status != 0){
            pos += "&status=" + status;
        }
        $.post("actionadminaj.do","pageIndex=1"+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            if(list.length == 0){
                $(".pageno").show();
                $(".middle2").hide();
                $(".page").hide();
                $("#totalCount").html(data["totalCount"]);
            }else {
                $(".middle2").show();
                $(".page").show();
                $(".pageno").hide();
                for(var i = 0; i<list.length;i++){
                    str +="<li><a class=\"cona\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex=1\">"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spancount\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex=1\">查看</a><a class=\"spancount1\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
                }
                $(".uul").html(str);
                $("#currentPage").html(1);
                $("#count").html(data["totalPage"]);
                $("#totalCount").html(data["totalCount"]);
            }
        },"JSON");

    });
    $("#audit").click(function () {
        status = 3;
        var pos = "";
        if(title != ""){
            pos += "&title=" + title;
        }
        if(schoolId != 0){
            pos += "&school=" + schoolId;
        }
        if(status != 0){
            pos += "&status=" + status;
        }
        $.post("actionadminaj.do","pageIndex=1"+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            if(list.length == 0){
                $(".pageno").show();
                $(".middle2").hide();
                $(".page").hide();
                $("#totalCount").html(data["totalCount"]);
            }else {
                $(".middle2").show();
                $(".page").show();
                $(".pageno").hide();
                for(var i = 0; i<list.length;i++){
                    str +="<li><a class=\"cona\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex=1\">"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spancount\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex=1\">查看</a><a class=\"spancount1\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
                }
                $(".uul").html(str);
                $("#currentPage").html(1);
                $("#count").html(data["totalPage"]);
                $("#totalCount").html(data["totalCount"]);
            }
        },"JSON");
    });

    $("#shouye").click(function () {
        var pos = "";
        if(title != ""){
            pos += "&title=" + title;
        }
        if(schoolId != 0){
            pos += "&school=" + schoolId;
        }
        if(status != 0){
            pos += "&status=" + status;
        }
        $.post("actionadminaj.do","pageIndex=1"+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex=1\">"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spancount\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex=1\">查看</a><a class=\"spancount1\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(1);
        },"JSON");
    });
    $("#moye").click(function () {
        var pageIndex = $("#count").text();
        var pageCount = $("#count").text();
        var pos = "";
        if(title != ""){
            pos += "&title=" + title;
        }
        if(schoolId !=0){
            pos += "&school=" + schoolId;
        }
        if(status != 0){
            pos += "&status=" + status;
        }
        $.post("actionadminaj.do","pageIndex="+pageIndex+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex="+pageIndex+"\">"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spancount\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex="+pageIndex+"\">查看</a><a class=\"spancount1\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageCount);
        },"JSON");
    });
    $("#sy").click(function () {
        var pageIndex = $("#currentPage").text();
        pageIndex--;
        if(pageIndex < 1){
            pageIndex = 1;
        }
        var pos = "";
        if(title != ""){
            pos += "&title=" + title;
        }
        if(schoolId !=0){
            pos += "&school=" + schoolId;
        }
        if(status != 0){
            pos += "&status=" + status;
        }
        $.post("actionadminaj.do","pageIndex="+pageIndex+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex="+pageIndex+"\">"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spancount\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex="+pageIndex+"\">查看</a><a class=\"spancount1\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageIndex);
        },"JSON");
    });
    $("#xy").click(function () {
        var pageIndex = $("#currentPage").text();
        var totalCount = $("#count").text();
        pageIndex++;
        if(pageIndex > totalCount){
            pageIndex = totalCount;
        }
        var pos = "";
        if(title != ""){
            pos += "&title=" + title;
        }
        if(schoolId !=""){
            pos += "&school=" + schoolId;
        }
        if(status != 0){
            pos += "&status=" + status;
        }
        $.post("actionadminaj.do","pageIndex="+pageIndex+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex="+pageIndex+"\">"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spancount\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex="+pageIndex+"\">查看</a><a class=\"spancount1\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageIndex);
        },"JSON");
    });
    $("#imgsearch").click(function(){
        var pos = "";
        if(title != ""){
            pos += "&title=" + title;
        }
        if(schoolId !=""){
            pos += "&school=" + schoolId;
        }
        if(status != 0){
            pos += "&status=" + status;
        }
        $.post("actionadminaj.do","pageIndex=1"+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            if(list.length == 0){
                $(".pageno").show();
                $(".middle2").hide();
                $(".page").hide();
            }else {
                $(".middle2").show();
                $(".page").show();
                $(".pageno").hide();
                for(var i = 0; i<list.length;i++){
                    str +="<li><a class=\"cona\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex=1\">"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spancount\" href=\"adminactionlook.do?id="+list[i]["id"]+"&pageIndex=1\">查看</a><a class=\"spancount1\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
                }
                $(".uul").html(str);
                $("#currentPage").html(1);
                $("#count").html(data["totalPage"]);
                $("#totalCount").html(data["totalCount"]);
            }
        },"JSON");
    });

});
function del(id) {
    if(confirm("确定要删除该最新活动吗？")){
        var pageIndex = $("#currentPage").text();
        $.post("actionadmindel.do","id="+id+"&pageIndex="+pageIndex,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">状态</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">操作</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href=\"adminactionlook.do?id="+list[i]["id"]+"\">"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["statusName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><a class=\"spancount\" href=\"adminactionlook.do?id="+list[i]["id"]+"\">查看</a><a class=\"spancount1\" href=\"\" onclick=del("+list[i]["id"]+")>删除</a></li>";
            }
            $(".uul").html(str);
        },"JSON");
    }
}