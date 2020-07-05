package com.challenge.coupons.models;

import java.util.List;

public class CouponResponse {
    private List<String> items_ids;
    public Float total;

    public CouponResponse(){}
    public CouponResponse(List<String> itemsIds, Float total ){
        this.items_ids = itemsIds;
        this.total = total;
    }

    public List<String> getItems_ids() {
        return items_ids;
    }

    public void setItems_ids(List<String> items_ids) {
        this.items_ids = items_ids;
    }

    public void setTotal(Float amount) {
        this.total = amount;
    }

    public float getTotal(){
        return total;
    }
}
