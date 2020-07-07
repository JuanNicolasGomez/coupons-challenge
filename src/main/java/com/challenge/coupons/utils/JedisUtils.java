package com.challenge.coupons.utils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisUtils {
    private  static JedisPool pool;

    static {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1024);
        config.setMaxIdle(200);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        pool = new JedisPool(config, "127.0.0.1",
                Integer.valueOf("6379"));
    }

    public static JedisPool getPool(){
        return pool;
    }
}
