$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });
    $("#pass").click(function () {
        var id = $("#newsId").val();
        var pageIndex = $("#pageIndex").val();
        window.location.href="backnewspass.do?id="+id+"&pageIndex="+pageIndex;
    });
    $("#nopass").click(function () {
        var id = $("#newsId").val();
        var pageIndex = $("#pageIndex").val();
        window.location.href="backnewsnopass.do?id="+id+"&pageIndex="+pageIndex;
    });

    $(".fb").click(function () {
        var pageIndex = $("#pageIndex").val();
        window.location.href="toAdmin.do?pageIndex="+pageIndex;
    });
});