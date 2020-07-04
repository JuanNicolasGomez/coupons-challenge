package com.challenge.coupons.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CouponServiceStub implements CouponService {

    @Override
    public List<String> calculate(Map<String, Float> items, Float amount){
        List<String> result = new ArrayList<>();
        List<String> tempResult = new ArrayList<>();
        float currentMaxAmount = 0;
        float currentAmount = 0;
        for (Map.Entry<String, Float> item : items.entrySet()) {
            tempResult.clear();
            tempResult.add(item.getKey());
            System.out.println("Entry item: " + item.getKey() + "tempResult: "+ tempResult.toString());
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
                System.out.println("Result: " + (tempResult.toString()));
            }
            System.out.println("current " + currentAmount + ", maxCuurr: " + currentMaxAmount );
        }
        return result;
    }

}
