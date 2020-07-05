package com.challenge.coupons.services;

import java.util.List;
import java.util.Map;

public interface CouponService {

    List<String> calculate(Map<String, Float> items, Float amount);
    List<String> getCouponItems(List<String> itemsId, Float amount);
}
