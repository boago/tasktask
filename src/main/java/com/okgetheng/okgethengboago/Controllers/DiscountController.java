/**
 * 
 */
package com.okgetheng.okgethengboago.Controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.okgetheng.okgethengboago.Models.Discount;
import com.okgetheng.okgethengboago.Services.DiscountService;

/**
 * @author Boago Okgetheng
 *
 */
@RestController
@RequestMapping("api/discount")
public class DiscountController {

 @Autowired
	    private DiscountService discountService;

	    @PostMapping
	    public BigDecimal createDiscount(@RequestBody Discount discount) {
	    	
	        return discountService.CalculateDiscount(discount.getUser(), discount.getBill());
	    }
}
