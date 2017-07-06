<%--
  Created by IntelliJ IDEA.
  User: liwy
  Date: 2017/7/6
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp" %>
<html>
<head>
    <title>登录</title>
    <!--引入bootstrap样式-->
    <link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <!--引入jquery脚本-->
    <script src="<%=basePath%>js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <!--引入bootstrap脚本-->
    <script src="<%=basePath%>js/bootstrap.js" type="text/javascript"></script>
    <script>
        function test() {
            alert( $("#account").val());
        }
    </script>
</head>
<body background="<%=basePath%>image/1.jpg">
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">菜鸟教程</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">SVN</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Java
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%--<img src="<%=basePath%>image/1.jpg"/>--%>
<h1>暮醉南山阁</h1>
<form action="<%=basePath%>test.do" method="post">
<input type="text" id="account" name="account" value="admin"/>
<input type="password" id="password" name="password" value="123456"/>
    <input type="submit" onclick="test()" value="登录"/>
</form>
<input type="button" onclick="test()" value="测试"/>
</body>
</html>
