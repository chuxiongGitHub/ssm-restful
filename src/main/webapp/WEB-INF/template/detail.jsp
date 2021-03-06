<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀详情页</title>
    <%@include file="common/header.jsp" %>
    <%@include file="common/tag.jsp" %>
</head>
<body>
<!--页面显示部分-->
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h2>${seckill.name}</h2>

        </div>
        <div class="panel-body">
            <h2 class="text-danger">
                <!--显示time图标-->
                <span class="glyphicon glyphicon-time"></span>
                <!--展示倒计时-->
                <span class="glyphicon" id="seckill-box"></span>

            </h2>
        </div>
    </div>
</div>
<!--登录弹出层，输入电话-->
<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
            <h3 class="modal-title text-center">
                <span class="glyphicon glyphicon-phone"></span>秒杀电话
            </h3>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2">
                    <input type="text" name="killPhone" id="killPhoneKey" placeholder="请输入手机号码" class="form-control">
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <!--验证信息-->
            <span id="killPhoneMessage" class="glyphicon"></span>
            <button type="button" id="killPhoneBtn" class="btn btn-success">
            <span class="glyphicon glyphicon-phone"></span>
            提交
            </button>
        </div>
    </div>
    </div>
</div>
</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=request.getContextPath()%>/res/js/jquery.countdown.js"></script>
<!--开始交互逻辑-->
<script type="application/javascript" src="<%=request.getContextPath()%>/res/js/seckill.js"></script>
<script type="application/javascript">
    $(function () {
        //使用el表达式传入参数
        seckill.detail.init({
            seckillId:${seckill.seckillId},
            startTime:${seckill.startTime.time},//拿到毫秒时间.time
            endTime:${seckill.endTime.time}
        });
    });
</script>
</html>
