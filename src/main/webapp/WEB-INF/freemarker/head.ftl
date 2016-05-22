<#if Session.shopUser?exists>
    <#assign user = Session.shopUser >
</#if>
<div class="container">
    <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">首页</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li>
                <#if user?exists>
                   <li> <a href="/user/info">${user.username!}</a></li>
                   <li><a href="/user/dologout">退出登录</a></li>
                <#else>
                    <li> <a rel="nofollow" href="/user/register">注册</a></li>
                    <li> <a rel="nofollow" href="/user/login">登录</a></li>
                </#if>
                </li>
            </ul>
        </div>
        <div>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
        </div>
    </nav>
</div>