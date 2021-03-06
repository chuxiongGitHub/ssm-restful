<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀列表</title>
    <%@include file="common/header.jsp" %>
    <%@include file="common/tag.jsp" %>
</head>
<body>
<!--页面显示部分-->
<div class="container">
    <div class="header-panel">
        <span>
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/seckill/seckillForm">添加商品</a>
        </span>
        <span class="form-group">
            <input type="text" >
            <a class="btn-primary btn">查询</a>
        </span>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>秒杀列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>创建时间</th>
                    <th>详情页</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${seckill}" var="data">
                    <tr>
                        <td>${data.name}</td>
                        <td>${data.number}</td>
                        <td><fmt:formatDate value="${data.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${data.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><a class="btn-primary btn" href="/seckill/${data.seckillId}/detail" target="_blank">详情信息</a>
                        </td>
                        <td><a class="btn btn-primary" href="#">编辑</a>
                        <a class="btn btn-danger" href="#">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</html>
