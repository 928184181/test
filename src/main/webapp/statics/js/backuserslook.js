$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    $("#password").blur(function(){
        var password = $("#password").val();
        var rag = /^\w{4,16}$/;
        if(!rag.test(password)){
            alert("密码必须由4~16位数字、字母或下划线组成！");
            $("#password").val('');
        }
    });
    $(".fb").click(function () {
        var pageIndex = $("#pageIndex").val();
        window.location.href="tobackusers.do?pageIndex="+pageIndex;
    });
});