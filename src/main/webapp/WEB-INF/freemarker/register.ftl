<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>注册</title>
    <meta name="Keywords" content="">
    <meta http-equiv="mobile-agent">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<body style="zoom: 1;">

<div class="container">
    <form action="/user/doregister" method="post" style="width: 30%;">
        <div class="form-group">
            <label for="exampleUsername">用户名</label>
            <input type="text"   class="form-control"  id="username" name="username" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">密码</label>
            <input type="password" class="form-control"  id="password" name= "password" placeholder="请输入密码">
            <label for="exampleInputPassword1">密码确认</label>
            <input type="password" class="form-control"  id="password2" name= "password2" placeholder="请再次输入密码">
        </div>
        <div class="form-group">
            <label for="ex">手机号码</label>
            <input type="text"   class="form-control"  id="phone" name="phone" placeholder="请输入手机号">
            <label for="ex2">电子邮箱</label>
            <input type="text"   class="form-control"  id="phone" name="email" placeholder="请输入点子邮箱">
        </div>
        <button type="submit" class="btn btn-default">注册</button>
    </form>
</div>

</body>
</html>
