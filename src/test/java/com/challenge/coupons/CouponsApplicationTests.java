package com.challenge.coupons;

import com.challenge.coupons.services.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

			List<String> expectedResult = new ArrayList<>();
			expectedResult.add("MLA1");
			expectedResult.add("MLA2");
			expectedResult.add("MLA4");
			expectedResult.add("MLA5");
			List<String> result = couponService.calculate(items, 500f);
			assertEquals(expectedResult,result);
		} catch (Exception ex) {
			fail();
		}
	}

}
