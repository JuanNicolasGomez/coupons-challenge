package com.challenge.coupons.models;

import java.util.List;
import java.util.Map;

public class Coupon {
    private List<String> items_ids;
    public Float amount;

    public Coupon(){}
    public Coupon(List<String> itemsIds,Float amount ){
        this.items_ids = itemsIds;
        this.amount = amount;
    }

    public List<String> getItems_ids() {
        return items_ids;
    }

    public void setItems_ids(List<String> items_ids) {
        this.items_ids = items_ids;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public float getAmount(){
        return amount;
    }
}
