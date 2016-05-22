<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="Keywords" content="">
    <meta http-equiv="mobile-agent" content="">
    <link rel="stylesheet" type="text/css" href="${rc.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${rc.contextPath}/css/bootstrap-theme.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<body style="zoom: 1;">

<div class="container ">
<#include "head.ftl">
    <div class="row">
        <div class="col-md-9">
            <div class="row">
                <img src="http://img3.redocn.com/20100226/Redocn_2010022519191439.jpg" height="300px" width="100%">
            </div>
        </div>
        <div class="col-md-3">
            <h4>热销商品</h4>
            <ui>
            <#list products?if_exists as product>
                <li class="stress">
                    <b class="prefix-dot"></b><a href="test" title="test" target="_blank"> ${product.productName!} </a>
                </li>
            </#list>
            </ui>
        </div>
    </div>
<#include "botton.html">

</div>
</body>
</html>