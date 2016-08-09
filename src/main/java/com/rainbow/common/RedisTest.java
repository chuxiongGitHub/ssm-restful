package com.rainbow.common;

import redis.clients.jedis.Jedis;

/**
 * Created by rainbow on 2016/8/8.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class RedisTest {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());

    }

}
