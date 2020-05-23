$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    $("#pass").click(function () {
        var id = $("#goodsId").val();
        var pageIndex = $("#pageIndex").val();
        window.location.href="backgoodspass.do?id="+id+"&pageIndex="+pageIndex;
    });
    $("#nopass").click(function () {
        var id = $("#goodsId").val();
        var pageIndex = $("#pageIndex").val();
        window.location.href="backgoodsnopass.do?id="+id+"&pageIndex="+pageIndex;
    });

    $(".fb").click(function () {
        var pageIndex = $("#pageIndex").val();
        window.location.href="tobackgoods.do?pageIndex="+pageIndex;
    });
});