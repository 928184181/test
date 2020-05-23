$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    $(".buy").click(function () {
        var id = $("#lost").val();
        if(confirm("您确定要认领该物品吗？")){
            window.location.href="lostclaim.do?id="+id;
        }
    });
});