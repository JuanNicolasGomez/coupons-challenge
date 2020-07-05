package com.challenge.coupons.respositories;

import java.util.List;
import java.util.Map;

public interface ItemsRepository {

    Map<String,Float> getItems(List<String> itemsId);
}
