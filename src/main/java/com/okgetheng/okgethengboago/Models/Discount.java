/**
 * 
 */
package com.okgetheng.okgethengboago.Models;

/**
 * @author Boago Okgetheng
 *
 */
public class Discount {
	
	private WebsiteUser user;
    private Bill bill;

	/**
	 * 
	 */
	public Discount(WebsiteUser user,  Bill bill) {
		this.user = user;
		this.bill = bill;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the user
	 */
	public WebsiteUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(WebsiteUser user) {
		this.user = user;
	}

	/**
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
