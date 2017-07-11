<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/9
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp" %>
<html>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">暮醉南山阁</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li  id="index">
                            <a href="${basePath}/main">首页</a>
                        </li>
                        <li  id="test">
                            <a href="${basePath}/appdata/list">接口测试</a>
                        </li>
                        <li  id="navigator">
                            <a href="#">导航</a>
                        </li>
                    </ul>
                    <%--<form class="navbar-form navbar-left" role="search">--%>
                        <%--<div class="form-group">--%>
                            <%--<input type="text" class="form-control" />--%>
                        <%--</div> <button type="submit" class="btn btn-default">Submit</button>--%>
                    <%--</form>--%>
                    <ul class="nav navbar-nav navbar-right" style="margin-right: 10px;">
                        <%--<li>--%>
                            <%--<a href="#">Link</a>--%>
                        <%--</li>--%>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">${username}<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">个人信息</a>
                                </li>
                                <li>
                                    <a href="#">设置</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="${basePath}/logout">退出登录</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </nav>
        </div>
    </div>
</div>
</body>
<script>
    // 根据当前页面使菜单高亮
    $(function() {
        var menu = "${menu}";
        $("#" + menu).addClass("active"); // 追加样式
    });
</script>
</html>
