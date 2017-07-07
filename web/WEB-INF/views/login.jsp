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
    <link href="<%=basePath%>/css/login.css" rel="stylesheet" type="text/css"/>
    <%--自动伸缩背景样式--%>
    <style>
        #background
        {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
            background-color: #211f1f;
            /*display:none\8;*/
        }
        #background .bg-photo
        {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            display: none;
            overflow: hidden;
            -webkit-background-size: cover !important;
            -moz-background-size: cover !important;
            -o-background-size: cover !important;
            background-size: cover !important;
        }
        #background .bg-photo-auto
        {
            background: url(<%=basePath%>image/background-login.jpg) no-repeat center center;
        }

        #background-ie {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
            background-color: #211f1f;
        }
    </style>
    <!--引入jquery脚本-->
    <script src="<%=basePath%>js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <!--引入bootstrap脚本-->
    <script src="<%=basePath%>js/bootstrap.js" type="text/javascript"></script>
    <script>
        function login() {
            alert( $("#account").val());
        }
    </script>
</head>
<body id="background" >
<div style="display: block;" class="bg-photo bg-photo-auto">
    <div class="container" style="margin-top: 200px;">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="<%=basePath%>login.do" method="post">
                <span class="heading">暮醉南山阁</span>
                <div class="form-group">
                    <input type="text" class="form-control" name="username" id="inputEmail3" placeholder="用户名或电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">记住密码</span>
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
