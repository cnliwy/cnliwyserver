<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/9
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../menu.jsp"%>
<html>
<head>
    <script>
    </script>
</head>
<body>
<div class="container" style="margin-top: 80px;">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="navbar-form navbar-left" id="form-add" role="search" action="${basePath}/appdata/add" method="post">
                <div class="form-group">
                    <input type="text" name="jsonKey" id="jsonKey" class="form-control" placeholder="请输入key"/>
                    <input type="text" name="jsonData" id="jsonData" class="form-control" placeholder="请输入json内容"/>
                </div> <button type="button" class="btn btn-default" onclick="add()">新增</button>
            </form>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        编号
                    </th>
                    <th>
                        jsonKey
                    </th>
                    <th>
                        json数据
                    </th>
                    <th>
                        创建时间
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${appDatas}" var="data" varStatus="status">
                    <c:if test="${status.index % 2} > 0">
                        <h4>hello</h4>
                        <tr>
                    </c:if>
                    <c:if test="${status.index % 2} == 0">
                        <h4>world</h4>
                        <tr class="success">
                    </c:if>
                    <%--<tr>--%>
                        <td>${status.index % 2}</td>
                        <td>
                            ${data.jsonKey}
                        </td>
                        <td> ${data.jsonData}</td>
                        <td>${data.createTime}</td>
                        <td>
                            <a href="${basePath}/appdata/delete">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                <%--<tr>--%>
                    <%--<td>--%>
                        <%--1--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--TB - Monthly--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--01/04/2012--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--Default--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="success">--%>
                    <%--<td>--%>
                        <%--1--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--TB - Monthly--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--01/04/2012--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--Approved--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="error">--%>
                    <%--<td>--%>
                        <%--2--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--TB - Monthly--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--02/04/2012--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--Declined--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="warning">--%>
                    <%--<td>--%>
                        <%--3--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--TB - Monthly--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--03/04/2012--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--Pending--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="info">--%>
                    <%--<td>--%>
                        <%--4--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--TB - Monthly--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--04/04/2012--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--Call in to confirm--%>
                    <%--</td>--%>
                <%--</tr>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script>
    function add() {
        var jsonKey = $("#jsonKey").val();
        var jsonData = $("#jsonData").val();
        if(jsonData.length == 0 || jsonData.trim().length == 0){
            alert("账号不能为空")
            return;
        }
        if(jsonData.length == 0 || jsonData.trim().length == 0){
            alert("密码不能为空")
            return;
        }

        $.ajax({
            type:"post",
            url : "${basePath}/appdata/add",
            data : $("#form-add").serialize(),
            dataType : "json",
            success : function (data) {
                if(data.state == 0){
                    alert("添加成功")
                }
            },
            error : function (data) {
                alert("请求失败");
            }
        });
    }
</script>
</html>
