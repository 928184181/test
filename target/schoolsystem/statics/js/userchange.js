$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });
    //前端数据校验
    var passwordflag = true;
    var phoneflag = true;
    var qqflag = true;
    var wxflag = true;
    $("#password").blur(function(){
        var rag = /^\w{4,16}$/;
        var password = $("#password").val();
        if(!rag.test(password)){
            alert("密码必须由4~16位数字、字母或下划线组成！");
            passwordflag = false;
            $("#password").val('');
        }else{
            passwordflag = true;
        }
    });
    $("#phone").blur(function(){
        var rag = /^0?(13|14|15|18|17)[0-9]{9}$/;
        var phone = $("#phone").val();
        if(!rag.test(phone)){
            alert("手机号格式错误！");
            $("#phone").val('');
            phoneflag = false;
        }else{
            phoneflag = true;
        }
    });
    $("#qq").blur(function(){
        var rag = /^[1-9]([0-9]{4,10})$/;
        var qq = $("#qq").val();
        if(qq == ''){
            qqflag = true;
        }else if(rag.test(qq)){
            qqflag = true;
        }else{
            alert("QQ号格式错误！");
            $("#qq").val('');
            qqflag = false;
        }
    });
    $("#wx").blur(function(){
        var rag = /^\w{4,20}$/;
        var wx = $("#wx").val();
        if(wx == ''){
            wxflag = true;
        }else if(rag.test(wx)){
            wxflag = true;
        }else{
            alert("微信号格式错误！");
            $("#wx").val('');
            wxflag = false;
        }
    });
    $("form").submit(function(){
        if(passwordflag != true || phoneflag != true || qqflag != true || wxflag!= true){
            return false;
        }
    })
});