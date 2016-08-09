package com.rainbow.mapper.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.rainbow.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by rainbow on 2016/8/9.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class RedisDao {
    private static Logger logger = LoggerFactory.getLogger(RedisDao.class);

    private JedisPool jedisPool;
    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    public Seckill getSeckill(long seckillId) {
        //redis操作逻辑
        try {

            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckillId;
                //没有实现内部序列化操作
                //get->byte[]   ->反序列化操作  ->Object[Seckill]
                //采用自定义序列化
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    //空对象
                    Seckill seckill = schema.newMessage();
                    ProtobufIOUtil.mergeFrom(bytes, seckill, schema);
                    //seckill被反序列化
                    return seckill;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String putSeckill(Seckill seckill) {
        //set Object[Seckill]  ->序列化 ->bytes[]
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckill.getSeckillId();
                byte[] bytes = ProtobufIOUtil.toByteArray(seckill, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //调用set方法
                //超时缓存
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
}
