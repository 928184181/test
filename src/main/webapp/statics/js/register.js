$(function(){
    var userNameFlag = false;
    var userCodeFlag = false;
    var passwordFlag = false;
    var phoneFlag = false;
    var qqFlag = false;
    var weixinFlag = false;
    $("#userCode").blur(function(){
        var userCode = $(this).val();
        var rag = /^\w{4,16}$/;
        if(rag.test(userCode)){
            $.post("login/usercode.do","userCode="+userCode,function (data) {
                if(data ==="error"){
                    alert("用户名已存在，请重新输入！");
                    $("#userCode").val('');
                }else {
                    $("#userCode").css("border","1px solid green");
                    userCodeFlag = true;
                }
            },"text")
        }else{
            $(this).css("border","1px solid red");
        }
    });
    $("#userName").blur(function(){
        var userName = $(this).val();
        if(userName != ''){
            $(this).css("border","1px solid green");
            userNameFlag = true;
        }else{
            $(this).css("border","1px solid red");
        }
    });
    $("#password").blur(function(){
        var password = $(this).val();
        var rag = /^\w{4,16}$/;
        if(rag.test(password)){
            $(this).css("border","1px solid green");
            passwordFlag = true;
        }else{
            $(this).css("border","1px solid red");
        }
    });
    $("#phone").blur(function(){
        var phone = $(this).val();
        var rag = /^0?(13|14|15|18|17)[0-9]{9}$/;
        if(rag.test(phone)){
            $(this).css("border","1px solid green");
            phoneFlag = true;
        }else{
            $(this).css("border","1px solid red");
        }
    });
    $("#qq").blur(function(){
        var qq = $(this).val();
        var rag = /^[1-9]([0-9]{4,10})$/;
        if(qq == ''){
            qqFlag = true;
            $(this).css("border","1px solid black");
        }else if(rag.test(qq)){
            $(this).css("border","1px solid green");
            qqFlag = true;
        }else{
            $(this).css("border","1px solid red");
        }
    });
    $("#weixin").blur(function(){
        var weixin = $(this).val();
        var rag = /^\w{4,20}$/;
        if(weixin == ''){
            weixinFlag = true;
            $(this).css("border","1px solid black");
        }else if(rag.test(weixin)){
            $(this).css("border","1px solid green");
            weixinFlag = true;
        }else{
            $(this).css("border","1px solid red");
        }
    });
    $("form").submit(function(){
        if(userNameFlag != true || passwordFlag != true || userCodeFlag != true || phoneFlag != true || qqFlag != true || weixinFlag != true){
            return false;
        }
    })
});
