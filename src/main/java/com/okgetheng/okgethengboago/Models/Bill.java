/**
 * 
 */
package com.okgetheng.okgethengboago.Models;

import java.util.List;

/**
 * @author Boago Okgetheng
 *
 */
public class Bill {
	  private List<Commodity> commodities;

	/**
	 * 
	 */
	public Bill(List<Commodity> commodities) {
		this.commodities = commodities;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the commodities
	 */
	public List<Commodity> getCommodities() {
		return commodities;
	}

	/**
	 * @param commodities the commodities to set
	 */
	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

}
