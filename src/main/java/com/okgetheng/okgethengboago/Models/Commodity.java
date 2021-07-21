/**
 * 
 */
package com.okgetheng.okgethengboago.Models;

import java.math.BigDecimal;


/**
 * @author Boago Okgetheng
 *
 */

public class Commodity {
	
	private CommodityType type;
    private BigDecimal price;

	/**
	 * 
	 */
	public Commodity(CommodityType type,BigDecimal price ) {
		this.type = type;
		this.price = price;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the type
	 */
	public CommodityType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(CommodityType type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
