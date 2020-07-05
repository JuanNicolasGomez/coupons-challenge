package com.challenge.coupons.controllers;

import com.challenge.coupons.models.CouponRequest;
import com.challenge.coupons.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> controllersPostCoupon(@RequestBody CouponRequest coupon){
        List<String> itemsId = coupon.getItems_ids();
        float amount = coupon.getAmount();
        try {
            List<String> items = couponService.getCouponItems(itemsId, amount);
            return new ResponseEntity<>(items,HttpStatus.ACCEPTED);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
