$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    $("#pass").click(function () {
        var id = $("#actionId").val();
        var pageIndex = $("#pageIndex").val();
        window.location.href="adminactionpass.do?id="+id+"&pageIndex="+pageIndex;
    });
    $("#nopass").click(function () {
        var id = $("#actionId").val();
        var pageIndex = $("#pageIndex").val();
        window.location.href="adminactionnopass.do?id="+id+"&pageIndex="+pageIndex;
    });

    $(".fb").click(function () {
        var pageIndex = $("#pageIndex").val();
        window.location.href="toAdmin.do?pageIndex="+pageIndex;
    });
});