$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });
    $(".goods").mouseover(function(){
        $(this).css("box-shadow","0px 0px 5px 5px #d8d8d8");
    }).mouseout(function(){
        $(this).css("box-shadow","none");
    });
    $(".imggoods").mouseover(function(){
        $(this).css("transform","scale(1.1,1.1)");
    }).mouseout(function(){
        $(this).css("transform","scale(1,1)");
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
        $.post("tolostaj.do","pageIndex=1"+pos,function (data) {
            var str = "";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<div class=\"goods\" onclick=find("+list[i]["id"]+")>\n" +
                    "    <img src=\"statics/lost/"+list[i]["pictureName"]+"\" class=\"imggoods\"/>\n" +
                    "    <p class=\"p2\">"+list[i]["title"]+"</p>\n" +
                    "    <p class=\"p1\"><span class=\"sp3\">"+list[i]["schoolName"]+"</span>\n" +
                    "    </p><p class=\"p1\"><span class=\"sp3\">"+list[i]["address"]+"</span></p></div>";
            }
            $(".middle2").html(str);
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
        $.post("tolostaj.do","pageIndex="+pageIndex+pos,function (data) {
            var str = "";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<div class=\"goods\" onclick=find("+list[i]["id"]+")>\n" +
                    "    <img src=\"statics/lost/"+list[i]["pictureName"]+"\" class=\"imggoods\"/>\n" +
                    "    <p class=\"p2\">"+list[i]["title"]+"</p>\n" +
                    "    <p class=\"p1\"><span class=\"sp3\">"+list[i]["schoolName"]+"</span>\n" +
                    "    </p><p class=\"p1\"><span class=\"sp3\">"+list[i]["address"]+"</span></p></div>";
            }
            $(".middle2").html(str);
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
        $.post("tolostaj.do","pageIndex="+pageIndex+pos,function (data) {
            var str = "";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<div class=\"goods\" onclick=find("+list[i]["id"]+")>\n" +
                    "    <img src=\"statics/lost/"+list[i]["pictureName"]+"\" class=\"imggoods\"/>\n" +
                    "    <p class=\"p2\">"+list[i]["title"]+"</p>\n" +
                    "    <p class=\"p1\"><span class=\"sp3\">"+list[i]["schoolName"]+"</span>\n" +
                    "    </p><p class=\"p1\"><span class=\"sp3\">"+list[i]["address"]+"</span></p></div>";
            }
            $(".middle2").html(str);
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
        $.post("tolostaj.do","pageIndex="+pageIndex+pos,function (data) {
            var str = "";
            var list = data["list"];
            for(var i = 0; i<list.length;i++){
                str +="<div class=\"goods\" onclick=find("+list[i]["id"]+")>\n" +
                    "    <img src=\"statics/lost/"+list[i]["pictureName"]+"\" class=\"imggoods\"/>\n" +
                    "    <p class=\"p2\">"+list[i]["title"]+"</p>\n" +
                    "    <p class=\"p1\"><span class=\"sp3\">"+list[i]["schoolName"]+"</span>\n" +
                    "    </p><p class=\"p1\"><span class=\"sp3\">"+list[i]["address"]+"</span></p></div>";
            }
            $(".middle2").html(str);
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
        $.post("tolostaj.do","pageIndex=1"+pos,function (data) {
            var str = "";
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
                    str +="<div class=\"goods\" onclick=find("+list[i]["id"]+")>\n" +
                        "    <img src=\"statics/lost/"+list[i]["pictureName"]+"\" class=\"imggoods\"/>\n" +
                        "    <p class=\"p2\">"+list[i]["title"]+"</p>\n" +
                        "    <p class=\"p1\"><span class=\"sp3\">"+list[i]["schoolName"]+"</span>\n" +
                        "    </p><p class=\"p1\"><span class=\"sp3\">"+list[i]["address"]+"</span></p></div>";
                }
                $(".middle2").html(str);
                $("#currentPage").html(1);
                $("#count").html(data["totalPage"]);
                $("#totalCount").html(data["totalCount"]);
            }
        },"JSON");
    })

    $(".goods").click(function(){
        var id = $(this).attr("name");
        window.location.href="lostdetails.do?id="+id;
    });

    $("#publish").click(function(){
        window.location.href="tolostpublish.do";
    });

    $("#mypublish").click(function(){
        var userId = $("#userId").val();
        window.location.href="mylost.do?userId="+userId;
    });

});
function find(id) {
    window.location.href="lostdetails.do?id="+id;
}



