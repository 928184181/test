$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });
    $(".fb").click(function () {
        window.location.href="tonewjob.do"
    });
});