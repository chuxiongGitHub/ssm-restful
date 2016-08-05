/**
 * Created by Administrator on 2016/8/5.
 */
//javaScript模块化
var seckill = {
    //封装秒杀相关ajax的URL地址
    URL: {
        now: function () {
            return '/seckill/time/now';
        },
        exposer: function (seckillId) {
            return '/seckill/' + seckillId + '/exposer';
        },
        execution: function (seckillId, md5) {
            return '/seckill/' + seckillId + '/' + md5 + '/execution';
        }
    },
    //秒杀逻辑处理
    handlerSeckillKill: function (seckillId, node) {
        //获取秒杀地址，控制显示逻辑，执行秒杀
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">一键秒杀</button>');
        $.post(seckill.URL.exposer(seckillId), {}, function (result) {
            //回调函数中，执行交互流程
            if (result && result['success']) {
                var exposer = result['data'];
                if (exposer['exposed']) {
                    //开启秒杀
                    //获取秒杀地址
                    var md5 = exposer['md5'];
                    var killUrl = seckill.URL.execution(seckillId, md5);
                    //只绑定一次点击事件
                    $('#killBtn').one('click', function () {
                        //绑定执行秒杀请求操作
                        //1、先禁用按钮
                        $(this).addClass('disabled');
                        //2、发送秒杀请求,执行秒杀
                        $.post(killUrl, {}, function (result) {
                            if (result && result['success']) {
                                var killResult = result['data'];
                                var status = killResult['status'];
                                var statusInfo = killResult['statusInfo'];
                                //显示秒杀结果
                                node.html('<span class="label label-success">' + statusInfo + '</span>')
                            }
                        });
                    });
                    node.show();
                } else {
                    //未开启秒杀
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end = exposer['end'];
                    //重新计算计时逻辑
                    seckill.count(seckillId, now, start, end);
                }

            }
            else {
                console.error("result:" + result);
            }
        })

    },
    //验证手机号
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        }
        else {
            return false;
        }
    },
    count: function (seckillId, nowTime, startTime, endTime) {
        var seckillBox = $('#seckill-box');
        //时间判断
        if (nowTime > endTime) {
            seckillBox.html("秒杀结束");
        }
        else if (nowTime < startTime) {
            //秒杀开始,计时时间绑定
            var killTime = new Date(startTime + 1000);
            seckillBox.countdown(killTime, function (enent) {
                var format = enent.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒');
                console.log(format);
                seckillBox.html(format);
                //时间完成之后回调事件
            }).on('finsh.coutndown', function () {
                //获取秒杀地址，控制显示逻辑，执行秒杀
                seckill.handlerSeckillKill(seckillId, seckillBox);

            })
        }
        else {
            //秒杀开始
            seckillBox.html("正在秒杀");
            seckill.handlerSeckillKill(seckillId, seckillBox);

        }
    },
    //详情页面秒杀逻辑
    detail: {
        init: function (params) {
            //用户手机验证和登录，计时交互
            //规划交互流程
            //在cookie中查找手机号
            var killPhone = $.cookie("killPhone");

            if (!seckill.validatePhone(killPhone)) {
                //绑定手机号
                var killPhoneModal = $('#killPhoneModal');
                killPhoneModal.modal({
                    //显示弹出层
                    show: true,
                    //禁止位置关闭
                    backdrop: 'static',
                    //关闭键盘事件
                    keyboard: false
                });
                $('#killPhoneBtn').click(function () {

                    var inputPhone = $('#killPhoneKey').val();
                    // console.log(inputPhone);//TODO
                    if (seckill.validatePhone(inputPhone)) {
                        //电话写入cookie
                        $.cookie('killPhone', inputPhone, {expires: 7, path: '/seckill'});
                        //刷新页面
                        window.location.reload();
                    }
                    else {
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误</label>').show(300);

                    }
                });
            }
            //已经登录
            //计时交互
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            $.get(seckill.URL.now(), {}, function (result) {
                if (result && result['success']) {
                    var nowTime = result['data'];
                    console.log(nowTime);
                    //时间判断
                    seckill.count(seckillId, nowTime, startTime, endTime);

                } else {
                    console.log("result:" + result);
                }

            });
        }
    }
}