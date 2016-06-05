<html lang="zh-CN">
<head>
    <title>首页</title>
    <#include "common/cssandjs.ftl">
</head>
<body >
<#include "common/head.ftl">
<div class="container ">
    <div class="row">
        <div class="col-md-9">
                    <img src="http://img3.redocn.com/20100226/Redocn_2010022519191439.jpg" height="300px" width="95%">

            <div class="row">

            </div>
        </div>
        <div class="col-md-3">
            <h4>热销商品</h4>
            <ui>
            <#list products?if_exists as product>
                <li>
                    <b></b><a href="/user/edit/${product.id}" title="test" target="_blank"> ${product.productName!} </a>
                </li>
            </#list>
            </ui>
        </div>
    </div>
<#include "common/botton.html">

</div>
</body>
</html>