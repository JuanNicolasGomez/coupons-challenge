package com.challenge.coupons.services;

import com.challenge.coupons.models.CouponResponse;
import com.challenge.coupons.respositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CouponServiceStub implements CouponService {
    @Autowired
    ItemsRepository itemsRepository;


    @Override
    public List<String> calculate(Map<String, Float> items, Float amount){
        List<String> result = new ArrayList<>();
        List<String> tempResult = new ArrayList<>();
        float currentMaxAmount = 0;
        float currentAmount = 0;
        for (Map.Entry<String, Float> item : items.entrySet()) {
            tempResult.clear();
            tempResult.add(item.getKey());
            currentAmount = item.getValue();
            for (Map.Entry<String, Float> entry : items.entrySet()) {
                if (item!=entry && currentAmount + entry.getValue() <= amount){
                    currentAmount += entry.getValue();
                    tempResult.add(entry.getKey());
                }
            }
            if (currentAmount > currentMaxAmount){
                currentMaxAmount = currentAmount;
                result = new ArrayList<>(tempResult);
            }
        }
        return result;
    }

    @Override
    public Float calculateTotal(Map<String, Float> items) {
        Float total = 0f;
        for (Map.Entry<String, Float> item : items.entrySet()) {
            total += item.getValue();
        }
        return total;
    }

    @Override
    public List<String> getCouponItems(List<String> itemsId, Float amount) {
        Map<String, Float> items = itemsRepository.getItems(itemsId);
        List<String> itemsResult = calculate( items, amount);
        return itemsResult;
    }

    @Override
    public Float getCouponTotal(List<String> itemsId){
        Map<String, Float> couponItems = itemsRepository.getItems(itemsId);
        Float total = calculateTotal(couponItems);
        return total;
    }






}
