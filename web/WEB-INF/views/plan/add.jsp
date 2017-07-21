<%--
  Created by IntelliJ IDEA.
  User: liwy
  Date: 2017/7/21
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../menu.jsp"%>
<html>
<html>
<head>
</head>
<body>
<div style="margin-top: 80px;" >
    <div class="row clearfix">
        <div class="col-md-12 column">

        <form class="form-horizontal" role="form" action="${basePath}/plan/addPlan" method = "post">
            <div class="form-group">
                <label for="planTitle" class="col-sm-2 control-label">计划标题</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="planTitle" name="planTitle"/>
                </div>
            </div>
            <div class="form-group">
                <label for="planContent" class="col-sm-2 control-label">计划内容</label>
                <div class="col-sm-10">
                    <input type="text"  class="form-control" id="planContent" name="planContent"/>
                </div>
            </div>

            <div class="form-group">
                <label for="planContent" class="col-sm-2 control-label">计划周期</label>
                <div class="col-sm-10">
                    <input type="text"  class="form-control" id="planDays" name="planDays" />
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">添加</button>
                </div>
            </div>
        </form>
    </div>
    </div>
</div>
</body>
</html>
