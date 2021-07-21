/**
 * 
 */
package com.okgetheng.okgethengboago.BillMethods;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.okgetheng.okgethengboago.Models.Commodity;
import com.okgetheng.okgethengboago.Models.CommodityType;
import com.okgetheng.okgethengboago.Models.WebsiteUser;
import com.okgetheng.okgethengboago.Models.WebsiteUserType;

/**
 * @author Administrator
 *
 */
public class BillCalculation {

	/**
	 * 
	 */
	
	private static final int QUALIFYING_YEARS_FOR_DISCOUNT = 2;
    private static final double EMPLOYEE_DISCOUNT_PERCENTAGE = 0.30;
    private static final double AFFILIATE_DISCOUNT_PERCENTAGE = 0.10;
    private static final double CUSTOMER_DISCOUNT_PERCENTAGE = 0.05;
    

    public boolean isCustomerQualifyingForDiscount(LocalDate registeredDate, long years) {
        Period period = Period.between(registeredDate, LocalDate.now());
        return period.getYears() >= years;
    }

    public BigDecimal calculateTotalBill(List<Commodity> commodities) {
    	
        return commodities.stream().map(i -> i.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    
    public BigDecimal calculateTotalPerType(List<Commodity> commodities, CommodityType type) {
        BigDecimal total = new BigDecimal(0);
        if (type == null) {
        	
            throw new NullPointerException("Type cannot be null");
        }
        
        else{
        	
            total = commodities.stream().filter(i -> type.equals(i.getType())).map(i -> i.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return total;
    }

    /**
     * Get the discount of the user as per type
     * returns the decimal
	 * 
	 */
    
    public BigDecimal getTheDiscountOfTheUser(WebsiteUser user) {
    	
    	BigDecimal discount = new BigDecimal(0);
    	
        if (user == null) {
            throw new NullPointerException("User cannot be null");
        }
        
        else{

        WebsiteUserType type = user.getWebsiteusertype();

        switch (type) {
            case EMPLOYEE:
                discount = new BigDecimal(EMPLOYEE_DISCOUNT_PERCENTAGE);
                break;

            case AFFILIATE:
                discount = new BigDecimal(AFFILIATE_DISCOUNT_PERCENTAGE);
                break;

            case CUSTOMER:
                if (isCustomerQualifyingForDiscount(user.getRegisterDate(), QUALIFYING_YEARS_FOR_DISCOUNT)) {
                    discount = new BigDecimal(CUSTOMER_DISCOUNT_PERCENTAGE);
                }
                break;

            default:
                break;
        }
        
        return discount;
        }
    }

    public BigDecimal calculateBillsDiscount(BigDecimal totalAmount, BigDecimal amount, BigDecimal discountAmount) {
        int billDiscount = totalAmount.divide(amount).intValue();
        BigDecimal discount = discountAmount.multiply(new BigDecimal(billDiscount));
        return discount;
    }
    

    public BigDecimal calculateDiscount(BigDecimal amount, BigDecimal discount) {
        if (discount.doubleValue() > 1.0) {
            throw new IllegalArgumentException("Discount error");
        }

        BigDecimal x = amount.multiply(discount);
        return amount.subtract(x);
    }
}
