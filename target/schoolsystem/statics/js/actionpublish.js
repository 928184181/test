$(function(){
    $(".nav").mouseover(function(){
        $(this).css("background-color","#858cff");
    }).mouseout(function(){
        $(this).css("background-color","white");
    });

    var fileflag = true;
    $("form").submit(function () {
        if(fileflag == false){
            return false;
        }
    });

    $(".inpim").change(function(){
        var str = $(this).val();
        var arr=str.split("\\");
        var fileName=arr[arr.length-1];
        var fileExt = fileName.substring(fileName.lastIndexOf('.') + 1);
        var extarr = ["jpg","png","jpeg","gif"];
        var vlaue = $.inArray(fileExt, extarr);
        if(vlaue == -1){
            alert("图片格式错误！（仅支持jpg,jpeg,png,gif格式）");
            fileflag = false;
        }else{
            fileflag = true;
        }
    });
});