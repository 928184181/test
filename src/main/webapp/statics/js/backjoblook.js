$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });
    $("#pass").click(function () {
        var id = $("#jobId").val();
        var pageIndex = $("#pageIndex").val();
        window.location.href="backjobpass.do?id="+id+"&pageIndex="+pageIndex;
    });
    $("#nopass").click(function () {
        var id = $("#jobId").val();
        var pageIndex = $("#pageIndex").val();
        window.location.href="backjobnopass.do?id="+id+"&pageIndex="+pageIndex;
    });

    $(".fb").click(function () {
        var pageIndex = $("#pageIndex").val();
        window.location.href="tobackjob.do?pageIndex="+pageIndex;
    });
});