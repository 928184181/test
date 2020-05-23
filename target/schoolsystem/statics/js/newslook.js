$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    $(".but").click(function () {
        var content = $(".text2").val();
        var userId = $("#userId").val();
        var newsId = $("#newsId").val();
        var flag = confirm("你确定要发布评论吗？");
        if(flag == true){
            $.post("comment.do","content="+content+"&userId="+userId+"&newsId="+newsId,function (date) {
                if(date === "success"){
                    alert("评论成功！");
                    window.location.href="tonewslook.do?id="+newsId;
                }
            },"text");
        }
    });

    $("#shouye").click(function () {
        var newsId = $("#newsId").val();
        $.post("commentaj.do","pageIndex=1&newsId="+newsId,function (data) {
            var str = "";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><div class=\"lidiv\"><p class=\"name\">"+list[i]["userName"]+"</p><p class=\"name1\">"+list[i]["date"]+"</p></div><textarea class=\"text1\" readonly>"+list[i]["content"]+"</textarea></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(1);
        },"JSON");
    });
    $("#moye").click(function () {
        var pageIndex = $("#count").text();
        var pageCount = $("#count").text();
        var newsId = $("#newsId").val();
        $.post("commentaj.do","pageIndex="+pageIndex+"&newsId="+newsId,function (data) {
            var str = "";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><div class=\"lidiv\"><p class=\"name\">"+list[i]["userName"]+"</p><p class=\"name1\">"+list[i]["date"]+"</p></div><textarea class=\"text1\" readonly>"+list[i]["content"]+"</textarea></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageCount);
        },"JSON");
    });
    $("#sy").click(function () {
        var newsId = $("#newsId").val();
        var pageIndex = $("#currentPage").text();
        pageIndex--;
        if(pageIndex < 1){
            pageIndex = 1;
        }
        $.post("commentaj.do","pageIndex="+pageIndex+"&newsId="+newsId,function (data) {
            var str = "";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><div class=\"lidiv\"><p class=\"name\">"+list[i]["userName"]+"</p><p class=\"name1\">"+list[i]["date"]+"</p></div><textarea class=\"text1\" readonly>"+list[i]["content"]+"</textarea></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageIndex);
        },"JSON");
    });
    $("#xy").click(function () {
        var newsId = $("#newsId").val();
        var pageIndex = $("#currentPage").text();
        var totalCount = $("#count").text();
        pageIndex++;
        if(pageIndex > totalCount){
            pageIndex = totalCount;
        }
        $.post("commentaj.do","pageIndex="+pageIndex+"&newsId="+newsId,function (data) {
            var str = "";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<li><div class=\"lidiv\"><p class=\"name\">"+list[i]["userName"]+"</p><p class=\"name1\">"+list[i]["date"]+"</p></div><textarea class=\"text1\" readonly>"+list[i]["content"]+"</textarea></li>";
            }
            $(".uul").html(str);
            $("#currentPage").html(pageIndex);
        },"JSON");
    });
});