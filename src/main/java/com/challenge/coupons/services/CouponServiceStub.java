package com.challenge.coupons.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CouponServiceStub implements CouponService {

    @Override
    public List<String> calculate(Map<String, Float> items, Float amount){

        return null;
    }
}
