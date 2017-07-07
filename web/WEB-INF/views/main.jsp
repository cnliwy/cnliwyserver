<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/7
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp" %>
<html>
<head>
    <title>暮醉南山阁</title>
    <!--引入bootstrap样式-->
    <link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/css/login.css" rel="stylesheet" type="text/css"/>
    <!--引入jquery脚本-->
    <script src="<%=basePath%>js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <!--引入bootstrap脚本-->
    <script src="<%=basePath%>js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">暮醉南山阁</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">Android</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Java
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">spring</a></li>
                        <li><a href="#">struts2</a></li>
                        <li><a href="#">mysql</a></li>
                        <li class="divider"></li>
                        <li><a href="#">html</a></li>
                        <li class="divider"></li>
                        <li><a href="#">js</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
