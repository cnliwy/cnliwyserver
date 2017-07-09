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
    <link href="${basePath}/css/login.css" rel="stylesheet" type="text/css"/>
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
            background: url(${basePath}/image/background-login.jpg) no-repeat center center;
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
</head>
<body id="background">
<input type="hidden" id="result" value="${result}"/>
<div class="container" >
<div style="display: block;" class="bg-photo bg-photo-auto">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="background-color:rgba(0,0,0,0.4)">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#" style="color: #ffffff">暮醉南山阁</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right" style="margin-right: 8px">
                        <li>
                            <a id="a-register" href="#id-register" role="button" style="color: #ffffff" data-toggle="modal">注册</a>
                        </li>
                        <li>
                            <%--<a href="#" style="color: #ffffff">登录</a>--%>
                            <a id="a-login" href="#id-login" role="button" style="color: #ffffff" data-toggle="modal">登录</a>
                            <%--<button >登录</button>--%>
                        </li>
                    </ul>
                </div>

            </nav>
        </div>
    </div>
    <%--登录框--%>
    <%--<div class="row" style="margin-top: 120px;">--%>
    <div class="modal fade" id="id-login" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <%--<div class="col-md-offset-3 col-md-6">--%>
        <div  class="modal-dialog">
            <form class="form-horizontal" action="${basePath}/login" method="post" id="login_form">
                <div class="modal-header" style="height: 10px;">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <span class="heading">暮醉南山阁</span>
                <div class="form-group">
                    <input type="text" class="form-control" name="username" id="inputEmail3" placeholder="用户名或电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default" style="width: 100%;margin: 0 auto;">登录</button>
                </div>
            </form>
        </div>
    </div>

    <%--注册--%>
    <div class="modal fade" id="id-register" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
        <%--<div class="col-md-offset-3 col-md-6">--%>
        <div  class="modal-dialog">
            <form class="form-horizontal" action="${basePath}/register" method="post" id="register_form">
                <div class="modal-header" style="height: 10px;">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <span class="heading">注册</span>
                <div class="form-group">
                    <input type="text" class="form-control" name="username" id="inputEmail1" placeholder="用户名或电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="password" id="inputPassword1" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="name" id="name" placeholder="真实姓名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="qq" id="qq" placeholder="QQ">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="phone" id="phone" placeholder="手机号">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default" style="width: 100%;">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
<script>
    function turnToRegister(){
        window.location.href = "${basePath}/toRegister";
    }
    function login() {
        alert( $("#account").val());
    }
    // 页面加载完成后自动调用
    $(function() {
        var result = $("#result").val();
        if(result.length > 0){
            alert(result);
        }
    });
   </script>
</html>
