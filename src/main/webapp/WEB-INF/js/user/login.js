$().ready(function () {
    $("#loginForm").validate(
        {
            errorPlacement: function (error, element) {
                $(element)
                    .closest("form")
                    .find("label[for='" + element.attr("id") + "']")
                    .append(error);
            },
            submitHandler: function (form) {
                $("#password").val($.md5($("#password").val()));
                $("#loginSubmit").attr("disabled", "disabled");
                var dataArr = $(form).serializeArray();
                var dataObj = {};
                $.each(dataArr, function(index, el){
                    dataObj[el.name] = el.value;
                });
               $.ajax({
                   url:"/user/dologin",
                   type:"post",
                   data:dataObj,
                    dataType:"json",
                    success:function (res) {
                        if(res.status==0){
                            alert(res.message);
                        }else if(res.status==1){
                            alert("登陆成功");
                            window.location.href="/";
                        }else{
                            alert("系统错误");
                        }
                    }
               });
            },
            errorElement: "span"
            /* ,
             messages: {
             user: {
             required: " (必需字段)",
             minlength: " (不能少于 3 个字母)"
             },
             password: {
             required: " (必需字段)",
             minlength: " (字母不能少于 5 个且不能大于 12 个)",
             maxlength: " (字母不能少于 5 个且不能大于 12 个)"
             }
             }*/
        }
    );
});