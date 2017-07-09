<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/8
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp" %>
<html>
<head>
    <!--引入bootstrap样式-->
    <link href="${basePath}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/css/login.css" rel="stylesheet" type="text/css"/>
    <title>注册</title>
</head>
<body style="background: #211f1f">
<input type="hidden" id="result" value="${result}"/>
<div class="container" style="margin-top: 200px;">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="${basePath}/register" method="post" id="register_form">
                <span class="heading">注册</span>
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
</body>
<script>
    // 页面加载完成后自动调用
    $(function() {
        var result = $("#result").val();
        if(result.length > 0){
            alert(result);
        }
    });
</script>
</html>
