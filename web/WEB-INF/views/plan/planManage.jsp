<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/9
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../menu.jsp"%>
<%@include file="../menuleft.jsp"%>
<html>
<head>
</head>
<body>
<div class="container" style="float:left">
    <div class="row clearfix">
                <%--<div class="col-md-10">--%>
                    <%--page内容--%>
                    <div class="col-md-12 column">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>
                                    编号
                                </th>
                                <th>
                                    计划标题
                                </th>
                                <th>
                                    计划内容
                                </th>
                                <th>
                                    开始时间
                                </th>
                                <th>
                                    完成总时间
                                </th>
                                <th>
                                    操作
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${planDatas}" var="data" varStatus="status">
                                <c:if test="${status.index % 2 == 0} ">
                                    <tr class="warning">
                                    <%--class状态success  error   info--%>
                                </c:if>
                                <c:if test="${status.index % 2 > 0}">
                                    <tr class="success">
                                </c:if>
                                <td>${status.index}</td>
                                <td>
                                        ${data.planTitle}
                                </td>
                                <td  id="${data.id}"> ${data.planContent}</td>
                                <td>${data.startTime}</td>
                                <td>${data.planDays}</td>
                                <td>
                                        <%--<a href="#" class="btn" onclick="showEdit('${data.id}','${data.notifyTitle}')">编辑</a>--%>
                                    <a href="#" class="btn" onclick="deletePushData('${data.id}')">删除</a>
                                </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                <%--</div>--%>
        <!--菜单end-->
    </div>

    <%--AppData数据编辑--%>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="modal fade" id="div-edit" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form class="form-horizontal" action="${basePath}/plan/editPlan" method="post" id="form-edit">
                    <input type="hidden" id="id-edit" name="id"/>
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                编辑
                            </h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group" style="width: 80%;">
                                <input type="text" class="form-control" name="jsonKey" id="jsonKey-edit" placeholder="请输入key">
                                <i class="fa fa-user"></i>
                            </div>
                            <div class="form-group">
                                <textarea class="form-control"  name="jsonData" id="jsonData-edit" placeholder="输入json数据"></textarea>
                                <i class="fa fa-user"></i>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary" onclick="edit()">保存</button>
                        </div>
                    </div>
                    </form>
                </div>

            </div>

        </div>
    </div>

    <%--AppData接口使用帮助--%>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="modal fade" id="div-help" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 class="modal-title" id="helpLabel">
                                    使用帮助
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group" style="width: 80%;">
                                    <h4 class="modal-title">
                                        获取json数据的方式：<br/>
                                        1.url:${basePath}/appdata/getTestData<br/>
                                        2.参数：identity和jsonKey<br/>
                                        3.get和post均可访问。<br/>
                                        4.根据不同的jsonKey获取相应的json数据<br/>
                                    </h4>
                                </div>
                                <div class="form-group">
                                    我的identity值：${identity}<br/>
                                    jsonKey即是下方列表里的jsonKey<br/>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function push() {
        var notifyTitle = $("#notifyTitle").val();
        var notifyContent = $("#notifyContent").val();
        if(notifyTitle.length == 0 || notifyTitle.trim().length == 0){
            alert("通知标题不能为空")
            return;
        }
        if(notifyContent.length == 0 || notifyContent.trim().length == 0){
            alert("通知内容不能为空")
            return;
        }

        $.ajax({
            type:"post",
            url : "${basePath}/push/pushAction",
            data : $("#form-add").serialize(),
            dataType : "json",
            success : function (data) {
                if(data.state == 0){
                    window.location.href = "${basePath}/push/pushManage";
                }
            },
            error : function (data) {
                alert("请求失败");
            }
        });
    }

    function deletePushData(id) {
        $.ajax({
            type:"post",
            url : "${basePath}/plan/deletePlan?planId=" + id,
            dataType : "json",
            success : function (data) {
                if(data.state == 0){
                    alert("删除成功")
                    window.location.href = "${basePath}/plan/planManage";
                }
            },
            error : function (data) {
                alert("删除失败");
            }
        });
    }
    function showEdit(id,jsonKey) {
        $("#id-edit").val(id);
        $("#jsonKey-edit").val(jsonKey);
        $("#jsonData-edit").val($("#"+id).html());
        $("#div-edit").modal("show");
    }
    function edit(){
        var jsonKey = $("#jsonKey-edit").val();
        var jsonData = $("#jsonData-edit").val();
        if(jsonData.length == 0 || jsonData.trim().length == 0){
            alert("key不能为空")
            return;
        }
        if(jsonData.length == 0 || jsonData.trim().length == 0){
            alert("json数据不能为空")
            return;
        }

        $.ajax({
            type:"post",
            url : "${basePath}/appdata/edit",
            data : $("#form-edit").serialize(),
            dataType : "json",
            success : function (data) {
                if(data.state == 0){
                    window.location.href = "${basePath}/appdata/list";
                }else{
                    alert(data.result);
                }
            },
            error : function (data) {
                alert("请求失败");
            }
        });
    }
</script>
</html>
