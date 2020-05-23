$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    $(".n_btn_1").click(function(){
        var id = $("#goodsId").val();
        var price = $("#price").text();
        var sum = $(".n_ipt").val();
        var sums = parseInt(sum) +1;
        $.post("goodsbutton.do","id="+id,function (date) {
            var count = date["count"];
            if(sums > count){
                alert("物品超过最大值！");
            }else {
                $(".n_ipt").attr("value",sums);
                var prices = price * sums;
                $("#prices").html(prices);
            }
        },"JSON");
    });
    $(".n_btn_2").click(function(){
        var sum = $(".n_ipt").val();
        sum--;
        var price = $("#price").text();
        if(sum<1){
            alert("数量达到最小值，无法减小！");
            $(".n_ipt").attr("value",1);
            var prices = $("#price").text();
            $("#prices").html(prices);
        }else{
            $(".n_ipt").attr("value",sum);
            var prices = price * sum;
            $("#prices").html(prices);
        }
    });
    $(".buy").click(function () {
        var userId = $("#userId").val();
        var goodsId = $("#goodsId").val();
        var price = $("#prices").text();
        var count = $("#count").val();
        window.location.href="goodsbuy.do?userId="+userId+"&goodsId="+goodsId+"&price="+price+"&count="+count;
    });
});