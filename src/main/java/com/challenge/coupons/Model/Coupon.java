package com.challenge.coupons.Model;

import java.util.List;
import java.util.Map;

public class Coupon {
    private Map<String, Object> couponMap;

    public List<String> getItems(){
        if (couponMap == null) {
            return null;
        }
        return (List<String>) couponMap.get("items_ids");
    }

    public float getAmount(){
        if (couponMap == null) {
            return 0f;
        }
        return (float) couponMap.get("amount");
    }
}
