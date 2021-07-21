package com.okgetheng.okgethengboago;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.okgetheng.okgethengboago.BillMethods.BillCalculation;
import com.okgetheng.okgethengboago.Models.Commodity;
import com.okgetheng.okgethengboago.Models.CommodityType;
import com.okgetheng.okgethengboago.Models.WebsiteUser;
import com.okgetheng.okgethengboago.Models.WebsiteUserType;

public class BillCalculationTest {
	
	  @Test(expected = IllegalArgumentException.class)
        public void testCalculateDiscount_error() {
		  BillCalculation billcalculation = new BillCalculation();
		  billcalculation.calculateDiscount(new BigDecimal(100),  new BigDecimal(5.0));
	    }
	  
	  @Test(expected = NullPointerException.class)
	  public void testReferencingUnavailableUser() {
		  BillCalculation billcalculation = new BillCalculation();
		 billcalculation.getTheDiscountOfTheUser(null);
	  }

	    
  @Test
  public void testCalculateDiscountFor0Percent() {
  	BillCalculation billcalculation = new BillCalculation();
      BigDecimal total = billcalculation.calculateDiscount(new BigDecimal(100),  new BigDecimal(0.0));
      assertEquals(100.00, total.doubleValue(), 0);
  }

	
  @Test
  public void testCalculateDiscountFor30Percent() {
      BillCalculation billcalculation = new BillCalculation();
      BigDecimal total = billcalculation.calculateDiscount(new BigDecimal(100), new BigDecimal(0.3));
      assertEquals(70.00, total.doubleValue(), 0);
  }
  @Test
  public void testCalculateDiscountFor50Percent() {
  	BillCalculation billcalculation = new BillCalculation();
      BigDecimal total = billcalculation.calculateDiscount(new BigDecimal(100), new BigDecimal(0.5));
      assertEquals(50.00, total.doubleValue(), 0);
  }

  @Test
  public void testCalculateDiscountFor100Percent() {
  	  BillCalculation billcalculation = new BillCalculation();
      BigDecimal total = billcalculation.calculateDiscount(new BigDecimal(1000),  new BigDecimal(1.0));
      assertEquals(0.0, total.doubleValue(), 0);
  }

  @Test
  public void testCalculateBillsDiscountCase1() {
	  BillCalculation billcalculation = new BillCalculation();
      BigDecimal amount = billcalculation.calculateBillsDiscount(new BigDecimal(100),  new BigDecimal(50),  new BigDecimal(10));
      assertEquals(20, amount.doubleValue(), 0);
  }

  @Test
  public void testCalculateBillsDiscountCase2() {
	  BillCalculation billcalculation = new BillCalculation();
      BigDecimal amount = billcalculation.calculateBillsDiscount(new BigDecimal(100),  new BigDecimal(50),  new BigDecimal(5));
      assertEquals(10, amount.doubleValue(), 0);
  }

  @Test
  public void testIsCustomerQualifyingForDiscountCase1() {
	  BillCalculation billcalculation = new BillCalculation();
      LocalDate joinDate = LocalDate.now();
      boolean hasTwoyears = billcalculation.isCustomerQualifyingForDiscount(joinDate, 2);
      assertFalse(hasTwoyears);
  }

  @Test
  public void testIsCustomerQualifyingForDiscountCase2() {
	  BillCalculation billcalculation = new BillCalculation();
      LocalDate joinDate = LocalDate.now().minusYears(3);
      boolean hasTwoyears = billcalculation.isCustomerQualifyingForDiscount(joinDate, 2);
      assertTrue(hasTwoyears);
  }
  
  @Test
  public void testCalculateTotalGroceriesOnly() {
      List<Commodity> commodities = new ArrayList<Commodity>();
      commodities.add(new Commodity(CommodityType.GROCERY, new BigDecimal(100.0)));
      commodities.add(new Commodity(CommodityType.CELLPHONES, new BigDecimal(100.0)));
      commodities.add(new Commodity(CommodityType.COMPUTERS, new BigDecimal(100.0)));
      commodities.add(new Commodity(CommodityType.GROCERY, new BigDecimal(100.0)));
      
      BillCalculation billcalculation = new BillCalculation();
      
      BigDecimal totalGrocery = billcalculation.calculateTotalPerType(commodities, CommodityType.GROCERY);
      assertEquals(200.00, totalGrocery.doubleValue(), 0);
  }
  
  @Test
  public void testGetDiscountForEmployee() {
      WebsiteUser user = new WebsiteUser(WebsiteUserType.EMPLOYEE, LocalDate.now());
      BillCalculation billcalculation = new BillCalculation();
      BigDecimal discount = billcalculation.getTheDiscountOfTheUser(user);
      assertEquals(0.3, discount.doubleValue(), 0);
  }
  
  @Test
  public void testGetDiscountForCustomer() {
      WebsiteUser user = new WebsiteUser(WebsiteUserType.CUSTOMER, LocalDate.now());
      BillCalculation billcalculation = new BillCalculation();
      BigDecimal discount = billcalculation.getTheDiscountOfTheUser(user);
      assertEquals(0.0, discount.doubleValue(), 0);
  }
  
  @Test
  public void testGetDiscountForAffiliate() {
      WebsiteUser user = new WebsiteUser(WebsiteUserType.AFFILIATE, LocalDate.now());
      BillCalculation billcalculation = new BillCalculation();
      BigDecimal discount = billcalculation.getTheDiscountOfTheUser(user);
      assertEquals(0.1, discount.doubleValue(), 0);
  }
  
  
}
