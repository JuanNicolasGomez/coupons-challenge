package com.challenge.coupons.cache;

import com.challenge.coupons.utils.JedisUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Map;


@Service
public class RedisCacheService implements CacheService{
    Jedis jedis;
    public RedisCacheService(){

    }

    @Override
    public void setItem(String key, Float value) {
        try (Jedis jedis = JedisUtils.getPool().getResource()) {
            jedis.set(key, Float.toString(value));
        }
    }

    @Override
    public Float getItem(String key) {
        Float value = 0f;
        try (Jedis jedis = JedisUtils.getPool().getResource()) {
            value = Float.parseFloat(jedis.get(key));

        }
        return value;
    }

    @Override
    public boolean hasKey(String key) {
        boolean keyExists = false;
        try (Jedis jedis = JedisUtils.getPool().getResource()) {
            keyExists = jedis.exists(key);
        }
        return keyExists;


    }
}
