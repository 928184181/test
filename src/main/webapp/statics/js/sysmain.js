$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });
    $(".goods").mouseover(function(){
        $(this).css("box-shadow","0px 0px 5px 5px #d8d8d8");
    }).mouseout(function(){
        $(this).css("box-shadow","none");
    });
    $(".goods1").mouseover(function(){
        $(this).css("box-shadow","0px 0px 5px 5px #d8d8d8");
    }).mouseout(function(){
        $(this).css("box-shadow","none");
    });
    $(".action").mouseover(function(){
        $(this).css("box-shadow","0px 0px 5px 5px #d8d8d8");
    }).mouseout(function(){
        $(this).css("box-shadow","none");
    });
    $(".lostgoods").mouseover(function(){
        $(this).css("box-shadow","0px 0px 5px 5px #d8d8d8");
    }).mouseout(function(){
        $(this).css("box-shadow","none");
    });

    function scoll(){
        $("#express1").animate({"margin-top":"-30px"},1000,"linear",function(){
            $("#express1").find("li:first").appendTo("#express1");
            $("#express1").css({"margin-top":"0px"});
        });
    }
    var myVar = setInterval(scoll,1000);
    $("#express1").hover(function(){
        $(this).stop();
        clearInterval(myVar);
    },function(){
        myVar = setInterval(scoll,1000);
    });

    function scoll1(){
        $("#express2").animate({"margin-top":"-30px"},1000,"linear",function(){
            $("#express2").find("li:first").appendTo("#express2");
            $("#express2").css({"margin-top":"0px"});
        });
    }
    var myVar1 = setInterval(scoll1,1000);
    $("#express2").hover(function(){
        $(this).stop();
        clearInterval(myVar1);
    },function(){
        myVar1 = setInterval(scoll1,1000);
    });

    //页面跳转
    $(".goods").click(function(){
        var id = $(this).attr("name");
        window.location.href="togoodsdetails.do?id="+id;
    });
    $(".action").click(function(){
        var id = $(this).attr("id");
        window.location.href="toactionlook.do?id="+id;
    });
    $(".lostgoods").click(function(){
        var id = $(this).attr("name");
        window.location.href="lostdetails.do?id="+id;
    });
})