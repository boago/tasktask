/**
 * 
 */
package com.okgetheng.okgethengboago.Models;

import java.time.LocalDate;

/**
 * @author Boago Okgetheng
 *
 */

public class WebsiteUser {
	private WebsiteUserType websiteusertype;
    private LocalDate registerDate;

	/**
	 * 
	 */
	public WebsiteUser(WebsiteUserType typeOfTheUser,LocalDate registrationDate ) {
		this.websiteusertype = typeOfTheUser;
		this.registerDate= registrationDate;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the websiteusertype
	 */
	public WebsiteUserType getWebsiteusertype() {
		return websiteusertype;
	}

	@Override
	public String toString() {
		return String.format("User", websiteusertype);
	}

	/**
	 * @return the registerDate
	 */
	public LocalDate getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

}