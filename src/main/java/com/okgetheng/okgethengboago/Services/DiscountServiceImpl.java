/**
 * 
 */
package com.okgetheng.okgethengboago.Services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.okgetheng.okgethengboago.BillMethods.BillCalculation;
import com.okgetheng.okgethengboago.Models.Bill;
import com.okgetheng.okgethengboago.Models.CommodityType;
import com.okgetheng.okgethengboago.Models.WebsiteUser;

/**
 * @author Boago Okgetheng
 *
 */
@Service
public class DiscountServiceImpl implements DiscountService {

	@Override
	public BigDecimal CalculateDiscount(WebsiteUser user, Bill bill) {
		BillCalculation billCalculator = new BillCalculation();
		
		BigDecimal groceryAmount = billCalculator.calculateTotalPerType(bill.getCommodities(), CommodityType.GROCERY);
		BigDecimal discountOfTheUser = billCalculator.getTheDiscountOfTheUser(user);
        BigDecimal totalBill = billCalculator.calculateTotalBill(bill.getCommodities());
        BigDecimal nonGroceryAmount = totalBill.subtract(groceryAmount);
   
        BigDecimal billsDiscount = billCalculator.calculateBillsDiscount(totalBill, new BigDecimal(100), new BigDecimal(5));
        
		if (nonGroceryAmount.compareTo(BigDecimal.ZERO) > 0) {
			
			nonGroceryAmount = billCalculator.calculateDiscount(nonGroceryAmount, discountOfTheUser);
		}

        BigDecimal netAmount = (groceryAmount.add(nonGroceryAmount).subtract(billsDiscount));
		return netAmount;
	}
}