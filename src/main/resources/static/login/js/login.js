$(function () {
    alert("1");
    $("#username").blur(function () {
        if ($(this).val()==""||$(this).val()==null){
            alert("账号不能为空！");
        }
    })
})