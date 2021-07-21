/**
 * 
 */
package com.okgetheng.okgethengboago.Services;

import java.math.BigDecimal;

import com.okgetheng.okgethengboago.Models.Bill;
import com.okgetheng.okgethengboago.Models.WebsiteUser;

/**
 * @author Boago Okgetheng
 *
 */
public interface DiscountService {
	
	 BigDecimal CalculateDiscount(WebsiteUser user, Bill bill);
}
