<html lang="zh-CN">
<head>
    <title>忘记密码</title>
<#include "../common/cssandjs.ftl">
</head>
<body>
<#include "../common/head.ftl">

<div class="container ">
    <form action="/user/dogetpasswd" method="post" style="">
        <input type="hidden" name="token" value="${token!}" />
        <div class="form-group">
            <input type="text"   class="form-control"  id="email" name="email" placeholder="请输入邮箱">
        </div>

        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>
<#include "../common/botton.html">
</body>
</html>