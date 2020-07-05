package com.challenge.coupons;

import com.challenge.coupons.services.CouponService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class CouponsApplicationTests {

	@Autowired
	CouponService couponService;

	@Test
	public void calculateMaxValueProducts() {
		try {
			Map<String, Float> items = new HashMap<>();
			items.put("MLA1",100f);
			items.put("MLA2",210f);
			items.put("MLA3",260f);
			items.put("MLA4",80f);
			items.put("MLA5",90f);

			List<String> result = couponService.calculate(items, 500f);
			assertThat(result, containsInAnyOrder("MLA1","MLA2","MLA4","MLA5"));
		} catch (Exception ex) {
			Assertions.fail();
		}
	}

	@Test
	public void calculateMaxValueProductsWithDecimals() {
		try {
			Map<String, Float> items = new HashMap<>();
			items.put("MLA1",10.0f);
			items.put("MLA2",8.50f);
			items.put("MLA3",23.20f);
			items.put("MLA4",12.0f);
			items.put("MLA5",90.56f);
			List<String> result = couponService.calculate(items, 100f);
			assertThat(result, containsInAnyOrder("MLA2","MLA5"));
		} catch (Exception ex) {
			Assertions.fail();
		}
	}
	@Test
	public void calculateMaxValueProductsEmpty() {
		try {
			Map<String, Float> items = new HashMap<>();
			List<String> result = couponService.calculate(items, 100f);
			Assertions.assertEquals(result, new ArrayList<>());
		} catch (Exception ex) {
			Assertions.fail();
		}
	}

	@Test
	public void calculateTotal() {
		try {
			Map<String, Float> items = new HashMap<>();
			List<String> itemsId = new ArrayList<>();
			itemsId.add("MLA1");
			itemsId.add("MLA2");
			itemsId.add("MLA4");
			itemsId.add("MLA5");
			Float result = couponService.calculateTotal(items);
			Assertions.assertEquals(result, 480f);
		} catch (Exception ex) {
			Assertions.fail();
		}
	}


}
