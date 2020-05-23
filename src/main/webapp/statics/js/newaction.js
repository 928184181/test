$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    //分页级联模糊查询
    var title = "";
    var schoolId = 0;
    $("#search").blur(function () {
        title = $(this).val();
    });
    $("#sel").change(function () {
        schoolId = $(this).val();
    });

    $("#shouye").click(function () {
        var pos = "";
        if(title != ""){
            pos += "&title=" + title;
        }
        if(schoolId != 0){
            pos += "&school=" + schoolId;
        }
        $.post("newactionlistaj.do","pageIndex=1"+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">校区</span><span class=\"spanftr0\">发布人</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">点击量</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href='toactionlook.do?id="+list[i]["id"]+"'>"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["schoolName"]+"</span><span class=\"spanftr\">"+list[i]["userName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><span class=\"spancount\">"+list[i]["clicks"]+"</span></li>";
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
        if(schoolId !=""){
            pos += "&school=" + schoolId;
        }
        $.post("newactionlistaj.do","pageIndex="+pageIndex+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">校区</span><span class=\"spanftr0\">发布人</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">点击量</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href='toactionlook.do?id="+list[i]["id"]+"'>"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["schoolName"]+"</span><span class=\"spanftr\">"+list[i]["userName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><span class=\"spancount\">"+list[i]["clicks"]+"</span></li>";
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
        if(schoolId !=""){
            pos += "&school=" + schoolId;
        }
        $.post("newactionlistaj.do","pageIndex="+pageIndex+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">校区</span><span class=\"spanftr0\">发布人</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">点击量</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href='toactionlook.do?id="+list[i]["id"]+"'>"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["schoolName"]+"</span><span class=\"spanftr\">"+list[i]["userName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><span class=\"spancount\">"+list[i]["clicks"]+"</span></li>";
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
        $.post("newactionlistaj.do","pageIndex="+pageIndex+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">校区</span><span class=\"spanftr0\">发布人</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">点击量</span></li>";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><a class=\"cona\" href='toactionlook.do?id="+list[i]["id"]+"'>"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["schoolName"]+"</span><span class=\"spanftr\">"+list[i]["userName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><span class=\"spancount\">"+list[i]["clicks"]+"</span></li>";
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
        $.post("newactionlistaj.do","pageIndex=1"+pos,function (data) {
            var str = "<li><span class=\"cona0\">名称</span><span class=\"spanftr0\">校区</span><span class=\"spanftr0\">发布人</span><span class=\"spantime0\">发布时间</span><span class=\"spancount0\">点击量</span></li>";
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
                    str +="<li><a class=\"cona\" href='toactionlook.do?id="+list[i]["id"]+"'>"+list[i]["title"]+"</a><span class=\"spanftr\">"+list[i]["schoolName"]+"</span><span class=\"spanftr\">"+list[i]["userName"]+"</span><span class=\"spantime\">"+list[i]["date"]+"</span><span class=\"spancount\">"+list[i]["clicks"]+"</span></li>";
                }
                $(".uul").html(str);
                $("#currentPage").html(1);
                $("#count").html(data["totalPage"]);
                $("#totalCount").html(data["totalCount"]);
            }
        },"JSON");
    })

    $("#publish").click(function(){
        window.location.href="toactionpublish.do";
    });

    $("#mypublish").click(function(){
        var id = $("#userId").val();
        window.location.href="mynewactionpublish.do?userId="+id;
    });
});
