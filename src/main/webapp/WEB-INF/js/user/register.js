$().ready(function () {
    $("#registerForm").validate(
        {
            errorPlacement: function(error, element) {
                $( element )
                    .closest( "form" )
                    .find( "label[for='" + element.attr( "id" ) + "']" )
                    .append( error );
            },
            submitHandler: function (form) {
                $("#password").val($.md5($("#password").val().trim()));
                $("#password2").val($.md5($("#password2").val().trim()));
                $("#registerSubmit").attr("disabled", "disabled");

                var dataArr = $(form).serializeArray();
                var dataObj = {};
                $.each(dataArr, function(index, el){
                    dataObj[el.name] = el.value;
                });

                $.ajax({
                        type: "post",
                        url: "/user/doregister",
                        dataType: 'json',
                        data: dataObj,
                        success: function (res) {
                            if (res.status == false) {
                                alert(res.errors);
                                $("#registerSubmit").removeAttr("disabled");
                            } else {
                                window.location.href = "/";
                            }
                        }
                    }
                );
            },
            rules:{

                password:{
                    required:true,
                    minlength: 6
                },
                password2:{
                    required:true,
                    minlength: 6,
                    equalTo: "#password"
                }
            },
            errorElement: "span",
            messages: {
                password: {
                    required: "请输入密码",
                    minlength: "密码不能小于6个字符"
                },
                password2: {
                    required: "请输入确认密码",
                    minlength: "密码不能小于6个字符",
                    equalTo: "再次输入密码不一致"
                }
            }
        }
    );
});