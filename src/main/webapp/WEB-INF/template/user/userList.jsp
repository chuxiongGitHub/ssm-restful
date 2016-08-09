<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/8
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <jsp:include page="../common/header.jsp"></jsp:include>
    <jsp:include page="../common/tag.jsp"></jsp:include>
</head>
<body>
<div class="text-info h2">
    <span class="glyphicon glyphicon-user">用户列表</span>
</div>
<table class="table table-bordered" >
    <thead>
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>用户年龄</th>
        <th>创建时间</th>
    </tr>
    <c:forEach items="${user}" var="data">
        <tr>
            <td></td>
            <td>${data.username}</td>
            <td>${data.age}</td>
            <td><fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
    </c:forEach>
    </thead>
</table>
<script type="text/javascript">
    $(function(){
        var len=$('table tr').length;
        console.log(len);
        for(var i=1;i<len;i++){
            $('table tr:eq('+i+') td:first').text(i);
        }
    });
</script>
</body>
</html>
