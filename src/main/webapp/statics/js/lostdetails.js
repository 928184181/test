$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    $(".buy").click(function () {
        var id = $("#lost").val();
        if(confirm("��ȷ��Ҫ�������Ʒ��")){
            window.location.href="lostclaim.do?id="+id;
        }
    });
});