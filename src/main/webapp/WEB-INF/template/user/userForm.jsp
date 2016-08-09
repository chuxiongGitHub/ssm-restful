<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/8
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <jsp:include page="../common/header.jsp"></jsp:include>
</head>
<body>
<div class="text-center">
    <span class="text-info h2">用户注册</span>
</div>
<form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/user/addUser" method="post">
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">用户名：&nbsp;&nbsp;<span class="glyphicon glyphicon-user"></span></label>

        <div class="col-sm-10">
            <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名。。。">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码：&nbsp;&nbsp;<span class="glyphicon glyphicon-print"></span></label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码。。。">
        </div>
    </div>
    <div class="form-group">
        <label for="age" class="col-sm-2 control-label">年龄：&nbsp;&nbsp;<span class="glyphicon glyphicon-arrow-down"></span></label>
        <div class="col-sm-10">
            <input type="text" class="form-control"  name="age" id="age" placeholder="请输入年龄">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox"> 记住我
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">提交</button>
            <button type="reset" class="btn btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
</html>
