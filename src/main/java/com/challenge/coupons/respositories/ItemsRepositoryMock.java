package com.challenge.coupons.respositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsRepositoryMock implements ItemsRepository{

    Map<String, Float> items = new HashMap<>();

    public void ItemsRepositoryMock(){
        items.put("MLA1",100f);
        items.put("MLA2",210f);
        items.put("MLA3",260f);
        items.put("MLA4",80f);
        items.put("MLA5",90f);
    }

    @Override
    public Map<String, Float> getItems() {
        return items;
    }
}
