package com.challenge.coupons.cache;

import com.challenge.coupons.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class RedisCacheService implements CacheService{
    Jedis jedis;
    public RedisCacheService(){
        jedis = JedisUtils.getPool().getResource();
    }

    @Override
    public void setItem(String key, Float value) {
        jedis.set(key, Float.toString(value));
    }

    @Override
    public Float getItem(String key) {
        return Float.parseFloat(jedis.get(key));
    }
}
