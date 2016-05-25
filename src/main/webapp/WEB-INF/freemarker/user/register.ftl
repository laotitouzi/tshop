<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>注册</title>
<#include "../common/cssandjs.ftl">
    <script type="text/javascript">
        $().ready(function () {
            $("#registerForm").validate(
                    {
                        errorPlacement: function(error, element) {
                            // Append error within linked label
                            $( element )
                                    .closest( "form" )
                                    .find( "label[for='" + element.attr( "id" ) + "']" )
                                    .append( error );
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

    </script>
</head>
<body style="zoom: 1;">
<#include "../common/head.ftl"/>
<div class="container">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-8">
            <h3>用户注册</h3>
            <form action="/user/doregister" id="registerForm" method="post" style="">
                <input type="hidden" name="token" value="${token!}" />
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" required>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" required>
                </div>
                <div class="form-group">
                    <label for="password2">密码确认</label>
                    <input type="password" class="form-control" id="password2" name="password2" placeholder="请再次输入密码" required>
                </div>
                <div class="form-group">
                    <label for="phone">手机号码</label>
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号" required>
                </div>
                <div class="form-group">
                    <label for="email">电子邮箱</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱" required email="true" >
                </div>
                <button type="submit" class="btn btn-default">注册</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已经有账号了？<a href="/user/login">点此登陆</a>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<#include "../common/botton.html">
</body>
</html>
