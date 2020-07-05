package com.challenge.coupons.services;

import com.challenge.coupons.models.CouponResponse;

import java.util.List;
import java.util.Map;

public interface CouponService {

    List<String> calculate(Map<String, Float> items, Float amount);
    CouponResponse getCouponItems(List<String> itemsId, Float amount);
    Float calculateTotal(Map<String, Float> items);
}
