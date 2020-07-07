package com.challenge.coupons.cache;

public interface CacheService {
    void setItem(String key, Float value);
    Float getItem(String key);
    boolean hasKey(String key);

}
