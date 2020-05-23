function changeVerifyCode(img){
    img.src="Kaptcha?"+Math.floor(Math.random()*100);
}
$(function(){
    var userflag = false;
    var passwordflag = false;
    var yanzmflag = false;
    $("#userName").blur(function(){
        var userName = $(this).val();
        var rag = /^\w{4,16}$/;
        if(rag.test(userName)){
            $(this).css("border","2px solid green");
            $(this).next().show();
            userflag = true;
        }else if(userName == ''){
            $(this).css("border","2px solid gray");
            $(this).next().hide();
        }else{
            $(this).css("border","2px solid red");
        }
    });
    $("#password").blur(function(){
        var password = $(this).val();
        var rag = /^\w{4,16}$/;
        if(rag.test(password)){
            $(this).css("border","2px solid green");
            $(this).next().show();
            passwordflag = true;
        }else if(password == ''){
            $(this).css("border","2px solid gray");
            $(this).next().hide();
        }else{
            $(this).css("border","2px solid red");
        }
    });
    //验证码校验

    $("#yanzm").blur(function(){
        var yzm = $("#yanzm").val();
        $.post("login/yanzm.do","yzm="+yzm,function(data){
            if(data === "error"){
                alert("验证码错误！");
            }else {
                yanzmflag = true;
            }
        },"text");
    });

    var admin = "user";
    $(".box").click(function () {
        if($(this).is(":checked")){
            admin = "admin";
        }else {
            admin="user";
        }
    })
    $("#img").click(function(){
        var userCode = $("#userName").val();
        var password = $("#password").val();
        if(userflag == true && passwordflag == true && yanzmflag ==true){
            $.post("login/log.do","userCode="+userCode+"&password="+password+"&admin="+admin,function (data) {
                if(data === "error"){
                    alert("账号或密码错误！");
                }else if(data === "admin"){

                    window.location.href = "toAdmin.do";
                }else {
                    window.location.href = "toSysmain.do";
                }
            },"text")
        }
    })
});

