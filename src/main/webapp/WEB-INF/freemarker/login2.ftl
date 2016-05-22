<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title></title>
    <meta name="Keywords" content="">
    <meta http-equiv="mobile-agent" content="format=html5; url=http://m.guokr.com/">
    <link rel="stylesheet" type="text/css" href="../css/gui.css">
    <link rel="stylesheet" type="text/css" href="../css/index.css">
    <link rel="stylesheet" type="text/css" href="../css/login_reg.css">
<body style="zoom: 1;">
<div class="container ">
    <div class="wrap grow gmt30 gpack">
        <div class="gspan-6 gprefix-3 gsuffix-3 side">
            <div class="side-title">你还可以用第三方帐号登录</div>
            <div class="extoauth2">
                <a rel="nofollow" class="icon weixin"
                   href="2">微信帐号登录</a>
                <a rel="nofollow" class="icon qq"
                   href="">qq帐号登录</a>
            </div>
            <p>
                还没有帐号？<a href="register.htm">马上注册2222222222</a>
            </p>

        </div>
        <div class="gspan-15 gprefix-4 main">

            <h1>欢迎登录</h1>
            <form class="gform" id="loginForm" action="" method="POST" novalidate="true">
                <input id="csrf_token" name="csrf_token" type="hidden"
                       value="">
                <p class="gform-box">

                    <input class="gbtxt" id="email" maxlength="40" name="email" placeholder="邮44箱" required=""
                           type="email" value="">
                    <span class="tip"></span>
                </p>
                <p class="gform-box">
                    <input class="gbtxt" id="password" name="password" placeholder="密码" required="" type="password"
                           value="">
                    <span class="tip"></span>
                </p>
                <div>
                    <input class="gbtxt form-txt-vcode" id="captcha" maxlength="4" name="captcha" placeholder="验证码"
                           type="text" value=""><input type="hidden" name="captcha_rand" id="captchaRand"
                                                       value="170029487"><img src="./Login_files/saved_resource"
                                                                              id="captchaImage" class="captcha"><span>看不清/span>
            <span class="login-error">

            </span>
                </div>

                <p class="gform-box gform-rem">
                    <input checked="" id="permanent" name="permanent" type="checkbox" value="y">

                    <label for="permanent">记住我（网吧或别人的电脑请不要勾选）</label>

                    <span class="tip"></span>
                </p>

                <p class="gform-box">
                    <input type="submit" class="gform-submit greg-btn" value="登录">
                    <a class="gform-forget_pw" href="">忘记密码？</a>
                </p>
            </form>

        </div>
    </div>
<#include "botton.html"/>
</div>
</body>
</html>
