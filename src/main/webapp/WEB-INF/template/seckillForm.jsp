<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/3
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/bootstrap/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/css/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/css/demo.css">
    <script type="application/javascript" src="<%=request.getContextPath()%>/res/js/jquery.min.js"></script>
    <script type="application/javascript" src="<%=request.getContextPath()%>/res/js/jquery.easyui.min.js"></script>
    <script type="application/javascript" src="<%=request.getContextPath()%>/res/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
<form action="<%=request.getContextPath()%>/seckill/insertSeckill" method="post">
    <table class="table table-bordered">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>商品数量</td>
            <td><input type="text" name="number"></td>
        </tr>
        <tr>
            <td>开始时间</td>
            <td><input type="text" name="startTime" class="easyui-datetimebox"></td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td><input type="endTime" name="endTime" class="easyui-datetimebox"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
               <input type="submit" class="btn btn-primary" value="提交" >
                <input type="reset" class="btn bg-warning" value="重置">
            </td>
        </tr>
    </table>
</form>
<script type="application/javascript" src="<%=request.getContextPath()%>/res/js/jquery-1.8.3.min.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/res/bootstrap/js/bootstrap.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/res/js/bootstrap-datetimepicker.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/res/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>
</body>
</html>
