<html lang="zh-CN">
<head>
    <title>登陆</title>
<#include "../common/cssandjs.ftl"/>
    <script type="text/javascript">
        function changeMe(div) {
            $("#capImg").attr("src", "${rc.contextPath}/drawImage?t=" + new Date().getTime());
        }

        $().ready(function () {
            $("#loginForm").validate(
                    {
                        errorPlacement: function(error, element) {
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
<body>

<#include "../common/head.ftl"/>
<style>
    .width1 {
        width: 40%;
    }
</style>
<div class="container">
    <h3>用户登录</h3>
    <form action="" method="post" style="60%" id="loginForm">
        <input type="hidden" name="token" value="${token!}"/>
        <div class="form-group">
            <label for="username">用户名</label>
            <div class="inline-block">
                <input type="text" class="form-control width1" id="username" name="username" placeholder="用户名"
                       minlength="5" required>
            </div>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <div class="inline-block">
                <input type="password" class="form-control width1" id="password" name="password" placeholder="密码"
                       required>
            </div>
        </div>
        <div class="form-inline">
            <label for="code">验证码</label>
            <div class="inline-block">
                <input type="text" class="form-control" id="code" name="code" placeholder="请输入右侧验证码" required>
                <img id="capImg" class="inline-block" src="${rc.contextPath}/drawImage" onclick="changeMe()">
            </div>

        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="rememberMe" value="true"> 记住我 &nbsp;&nbsp;<a href="/user/register">立即注册</a>
                &nbsp;&nbsp;<a href="/user/forgetpasswd">找回密码</a>
            </label>
        </div>
        <button type="submit" class="btn btn-default">登陆</button>
    </form>
</div>
<#include "../common/botton.html"/>

</body>
</html>
