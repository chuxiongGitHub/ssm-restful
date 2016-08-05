package com.rainbow.service.impl;

import com.rainbow.dto.Exporer;
import com.rainbow.dto.SeckillExecution;
import com.rainbow.entity.Seckill;
import com.rainbow.entity.SuccessSeckilled;
import com.rainbow.enums.SeckillStatEnum;
import com.rainbow.exception.RepeatKillException;
import com.rainbow.exception.SeckillCloseException;
import com.rainbow.exception.SeckillException;
import com.rainbow.mapper.SeckillMapper;
import com.rainbow.mapper.SuccessSeckilledMapper;
import com.rainbow.service.SeckillService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
//@Component组件扫描，统称为spring中的组件
@Service
public class SeckillServiceImpl implements SeckillService {
    private static Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);

    //注入service依赖
    @Autowired
    private SeckillMapper seckillMapper;
    @Autowired
    private SuccessSeckilledMapper successSeckilledMapper;

    //加入一个混淆的概念
    private final String slat = "asdfasdfewdsdf%#43@5&8***sdfas!~~￥##@ftT";

    public List<Seckill> getSeckillList() {
        return seckillMapper.queryAll(0, 15);
    }

    public Seckill getById(Long seckillId) {
        return seckillMapper.queryById(seckillId);
    }

    public Exporer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillMapper.queryById(seckillId);
        if (seckill == null) {
            return new Exporer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        //系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()) {
            return new Exporer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        String md5 = getMD5(seckillId);
        return new Exporer(true, md5, seckillId);
    }

    @Transactional
    /**
     *使用注解控制事物方法的有点：
     * 1、开发团队达成一致，明确标注事物方法的风格
     * 2、保证事物方法的执行时间尽可能短,不要穿插其它的网络操作，RPC/HTTP请求或者剥离到事物方法外部
     * 3、不是所有的方法都需要事物，如只有一条修改操作，只读操作不需要事物控制
     */
    public SeckillExecution excuteSeckill(Long seckillId, Long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("秒杀数据被篡改");
        }
        //执行秒杀逻辑+记录购买行为
        Date nowTime = new Date();
        //减库存
        try {


            int updateCount = seckillMapper.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新到记录
                throw new SeckillCloseException("秒杀已经关闭");
            } else {
                //记录购买行为
                int insertCount = successSeckilledMapper.insertSuccessSeckilled(seckillId, userPhone);
                if (insertCount <= 0) {
                    throw new SeckillException("不能重复秒杀");
                } else {
                    //秒杀成功
                    SuccessSeckilled successSeckilled = successSeckilledMapper.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successSeckilled);
                }
            }

        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所以编译期异常，转化为运行期异常
            throw new SeckillException("秒杀内部错误" + e.getMessage());
        }
    }

    public void insertSeckill(Seckill seckill) throws Exception {
        //调用mybatis的mapper接口执行插入操作
        logger.info("开始插入数据");
        seckillMapper.insert(seckill);
        logger.info("插入的数据是：", seckill);

    }


    /**
     * md5加密
     */
    private String getMD5(Long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5Hex(base.getBytes());
        return md5;
    }

    public List<Seckill> queryList() {
        List<Seckill> list = seckillMapper.queryList();

        return list;
    }
}
