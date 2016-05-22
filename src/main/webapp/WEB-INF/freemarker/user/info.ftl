<#if Session.shopUser?exists>
    <#assign user = Session.shopUser >
</#if>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title></title>
    <meta name="Keywords" content="">
    <meta http-equiv="mobile-agent" content="">
    <link rel="stylesheet" type="text/css" href="../../css/gui.css">
    <link rel="stylesheet" type="text/css" href="../../css/index.css">
<body style="zoom: 1;">
<div class="container ">
   <#include "../head.ftl">
        <#if user?exists>
                ${user.username!}<br>
        ${user.nickname!}
        </#if>
   <#include "../botton.html">
</div>
</body>
</html>