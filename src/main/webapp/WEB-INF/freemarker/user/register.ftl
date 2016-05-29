<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>注册</title>
<#include "../common/cssandjs.ftl">
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
                    <input type="password" class="form-control" id="password2" name="password2" placeholder="请再次输入密码" required >
                </div>
                <div class="form-group">
                    <label for="phone">手机号码</label>
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号" required>
                </div>
                <div class="form-group">
                    <label for="email">电子邮箱</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱" required email="true" >
                </div>
                <button type="submit" id="registerSubmit" class="btn btn-default">注册</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已经有账号了？<a href="/user/login">点此登陆</a>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<#include "../common/botton.html">
<script type="text/javascript" src="${rc.contextPath}/js/user/register.js"></script>
</body>
</html>
