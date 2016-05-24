<html lang="zh-CN">
<head>
    <title>登陆</title>
    <#include "../common/cssandjs.ftl"/>
    <script type="text/javascript">
        function changeMe(div) {
        $("#capImg").attr("src", "${rc.contextPath}/drawImage?t="+new Date().getTime());
            alert($.md5($.md5("123456")));
        }
    </script>
</head>
<body>

<#include "../common/head.ftl"/>
<div class="container">
    <h3>用户登录</h3>
    <form action="/user/dologin" method="post" style="60%">
        <input type="hidden" name="token" value="${token!}" />
        <div class="form-group">
        <label for="exampleUsername">用户名</label>
        <input type="text"   class="form-control"  id="username" name="username" placeholder="用户名">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" class="form-control"  id="password" name= "password" placeholder="密码">
    </div>
        <div class="form-group">
            <label for="">验证码</label>
            <div  class="inline-block">
                <input type="text"   class="form-control "  id="password" name= "password" placeholder="请输入右侧验证码">
                <img  id="capImg" class="inline-block" src="${rc.contextPath}/drawImage" onclick="changeMe()">
            </div>

        </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="rememberMe" value="true"> 记住我      &nbsp;&nbsp;<a href="/user/register">立即注册</a>   &nbsp;&nbsp;<a href="/user/forgetpasswd">找回密码</a>
        </label>
    </div>
    <button type="button" class="btn btn-default">登陆</button>
</form>
</div>
<#include "../common/botton.html"/>

</body>
</html>
