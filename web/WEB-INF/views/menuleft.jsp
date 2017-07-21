<%--
  Created by IntelliJ IDEA.
  User: liwy
  Date: 2017/7/19
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp" %>
<html>
<head>
    <title>暮醉南山阁</title>
    <!--引入bootstrap样式-->
    <link href="${basePath}/css/leftmenu.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<!--菜单begin-->
<%--<div class="navbar navbar-duomi navbar-static-top" role="navigation">--%>
<%--<div class="container-fluid">--%>
<%--<div class="navbar-header">--%>
<%--<a class="navbar-brand" href="/Admin/index.html" id="logo">配置管理系统（流量包月）--%>
<%--</a>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<div style="margin-top: 80px" >
    <div class="container-fluid" style="float: left">
        <%--<div class="row">--%>
            <%--<div class="col-md-2">--%>
            <ul id="main-nav" class="nav nav-tabs nav-stacked" style="float: none">
                <li  id="list">
                    <a href="${basePath}/plan/list">
                        <i class="glyphicon glyphicon-th-large"></i>
                        我的
                    </a>
                </li>
                <li>
                    <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-cog"></i>
                        系统管理
                        <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                        <li><a href="#"><i class="glyphicon glyphicon-user"></i>用户管理</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>菜单管理</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>角色管理</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-edit"></i>修改密码</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>日志查看</a></li>
                    </ul>
                </li>
                <li id="add">
                    <a href="${basePath}/plan/toAdd">
                        <i class="glyphicon glyphicon-credit-card"></i>
                        新增计划
                    </a>
                </li>
                <li>
                    <a href="./grid.html">
                        <i class="glyphicon glyphicon-globe"></i>
                        分发配置
                        <span class="label label-warning pull-right">5</span>
                    </a>
                </li>
                <li>
                    <a href="./charts.html">
                        <i class="glyphicon glyphicon-calendar"></i>
                        图表统计
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-fire"></i>
                        关于系统
                    </a>
                </li>
            </ul>
        <%--</div>--%>
        <%--<div class="col-md-10">--%>
            <%--内容--%>
        <%--</div>--%>
         <%--</div>--%>
    </div>
</div>
</body>
<script>
    // 根据当前页面使菜单高亮
    $(function() {
        var menu = "${plan}";
        $("#" + menu).addClass("active"); // 追加样式
    });
</script>
</html>
