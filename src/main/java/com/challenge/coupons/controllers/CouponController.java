package com.challenge.coupons.controllers;

import com.challenge.coupons.Model.Coupon;
import com.challenge.coupons.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/coupon/")
public class CouponController {
    @Autowired
    CouponService couponService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> controllersPostCoupon(@RequestBody Coupon coupon){
        List<String> items = coupon.getItems();
        float amount = coupon.getAmount();
        //couponService.calculate(items, amount);
        return null;
    }
}
