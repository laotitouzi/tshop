<#if Session.shopUser?exists>
    <#assign user = Session.shopUser >
</#if>
<html lang="zh-CN">
<head>
    <title>个人中心</title>
<#include "../common/cssandjs.ftl">
</head>
<body>
<#include "../common/head.ftl">

<div class="container ">
<#if user?exists>
${user.username!}<br>
${user.nickname!}
</#if>
</div>
<#include "../common/botton.html">
</body>
</html>