<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/4
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>>
<html>
<head>
    <title>秒杀商品列表</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/bootstrap/css/bootstrap.css" type="text/css">
</head>
<body>
<table class="table table-bordered">
    <tr>
        <th colspan="6">商品列表</th>
    </tr>
    <tr>
        <th>商品id</th>
        <th>商品名字</th>
        <th>商品剩余数量</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>创建时间</th>
    </tr>
<c:forEach items="${seckill}" var="data">
    <tr>
        <td>${data.seckillId}</td>
        <td>${data.name}</td>
        <td>${data.number}</td>
        <td><fmt:formatDate value="${data.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
        <td><fmt:formatDate value="${data.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
        <<td><fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
    </tr>

</c:forEach>

</table>
</body>
</html>
