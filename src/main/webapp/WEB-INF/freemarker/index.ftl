<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title></title>
    <meta name="Keywords" content="">
    <meta http-equiv="mobile-agent" content="">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css">

<body style="zoom: 1;">
<div class="container ">
   <#include "head.ftl">
    <div class="grow gclear index-page">
        <div class="main">
            <div class="gbtitle">
                <h1>最新推荐</h1>
                <div class="gbtitle-advert">
                    <div id="bdadm-624095" class="gbtitle-advert-text"></div>
                </div>
            </div>
            <div class="recos gclear">
                <!--以下是首页轮播器代码-->
                <div class="focus">
                    <div class="focus-content">
                        <a href="" target="_blank" style="display: none;">
                            <img width="330" height="235" src="">
                        </a>

                        <a href="4" target="_blank" style="display: none;">
                            <img width="330" height="235" src="">
                        </a>
                    </div>
                    <div class="focus-explain">
                        <ul class="focus-title">
                            <li class="current" style="display: none;">
                                <a href="" title="" data-gaevent="home_recommend_articles_focus:v1.1.1.1:article"
                                   target="_blank">afdads</a>
                            </li>
                            <li class="current" style="display: none;">
                                <a href="" title="" data-gaevent="home_recommend_articles_focus:v1.1.1.1:article"
                                   target="_blank">afdads</a>
                            </li>
                        </ul>
                        <ul class="focus-tag">
                            <li class=""></li>
                            <li class="current"></li>
                        </ul>
                    </div>
                </div>
                <div class="recos-article">
                    <ul class="gclear">
                    <#list products?if_exists as product>
                        <li class="stress">
                              <h2><a href="test" title="test" target="_blank"> ${product.productName!} </a></h2>
                        </li>
                    </#list>
                    </ul>
                </div>
            </div>

           <#-- 下面新开一行显示-->
            <div class="gbtitle post-pop">
                <h1>小组热帖</h1>
                <div class="gbtitle-advert">
                    <div id="bdadm-624101" class="gbtitle-advert-text">ddd</div>
                </div>
            </div>
            <div class="contents gclear">
                <div class="contents-l">
                    <div class="content">
                        <h2 class="content-title">科技</h2>
                        <ul>
                        <#list products?if_exists as product>
                            <li class="stress">
                                <a href="test" title="test" target="_blank"> ${product.productName!} </a>
                            </li>
                        </#list>
                        </ul>
                    </div>
                </div>
                <div class="contents-r">
                    <div class="content">
                        <h2 class="content-title">生活</h2>
                        <ul>
                        <#list products?if_exists as product>
                            <li class="stress">
                                <a href="test" title="test" target="_blank"> ${product.productName!} </a>
                            </li>
                        </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="side">
            <div id="bdadm-633161" class="side-advert">广告位</div>
            <div class="side-title-border gclear">
                <h2>社区热点</h2>
            </div>
            <div class="side-post gclear">
                <ul>
                    <li><b class="prefix-dot"></b><a href="" title="" target="_blank">test</a></li>
                    <li><b class="prefix-dot"></b><a href="" title="" target="_blank">test</a></li>
                    <li><b class="prefix-dot"></b><a href="" title="" target="_blank">test</a></li>
                    <li><b class="prefix-dot"></b><a href="" title="" target="_blank">test</a></li>

                <#list products?if_exists as product>
                    <li class="stress">
                       <b class="prefix-dot"></b><a href="test" title="test" target="_blank"> ${product.productName!} </a>
                    </li>
                </#list>
                </ul>
            </div>
        </div>
    </div>
    <div id="bdadm-624092" class="bottom-ads"></div>
   <#include "botton.html">
</div>
</body>
</html>