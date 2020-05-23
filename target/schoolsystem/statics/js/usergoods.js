$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });
    //数据校验
    var countflag = true;
    var priceflag = true;
    $("#count").blur(function(){
        var count = $("#count").val();
        var rag = /^[1-9][0-9]{0,}$/;
        if(!rag.test(count)){
            alert("请输入正确的数量！");
            countflag = false;
            $("#count").val('');
        }else{
            countflag = true;
        }
    });
    $("#price").blur(function(){
        var price = $("#price").val();
        var rag = /^[0-9]+(\.[0-9]{0,2})?$/;
        if(!rag.test(price)){
            alert("请输入正确的金额！");
            $("#price").val('');
            priceflag = false;
        }else{
            priceflag = true;
        }
    });
    $("form").submit(function(){
        if(countflag != true || priceflag != true){
            return false;
        }
    });
});