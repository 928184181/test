$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });
    var flag = true;
    //数据校验
    $("#password").blur(function(){
        var name = $("#password").val();
        var rag = /^\w{4,16}$/;
        if(!rag.test(name)){
            alert("密码必需由4~16位字母数字或下划线组成！");
            $("#password").val('');
            flag = false;
        }
    });
    $("#pass").click(function () {
        var userName = $("#userName").val();
        var password = $("#password").val();
        var id = $("#adminId").val();
        if(flag == true){
            window.location.href="adminchange.do?userName="+userName+"&password="+password+"&id="+id;
        }
    });
});