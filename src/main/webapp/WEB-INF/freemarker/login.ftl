<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>登陆</title>
    <meta name="Keywords" content="">
    <meta http-equiv="mobile-agent">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<body style="zoom: 1;">

<div class="container">
<form action="/user/dologin" method="post" style="width: 30%;">
    <div class="form-group">
        <label for="exampleUsername">用户名</label>
        <input type="text"   class="form-control"  id="username" name="username" placeholder="用户名">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" class="form-control"  id="password" name= "password" placeholder="密码">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="rememberMe" value="true"> 记住我      <a href="/user/register">立即注册</a>
        </label>
    </div>
    <button type="submit" class="btn btn-default">登陆</button>
</form>
</div>

</body>
</html>
