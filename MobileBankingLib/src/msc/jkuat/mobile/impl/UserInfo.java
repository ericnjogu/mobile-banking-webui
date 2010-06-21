package msc.jkuat.mobile.impl;

import msc.jkuat.mobile.IF.UserInfoIF;

public class UserInfo implements UserInfoIF {
	/**bank assigned password for access to mobile banking*/
	private String pin = null;
	/**e.g. Eric*/
	private String firstName = null;
	/**e.g. Njogu*/
	private String lastName = null;
	/**e.g. Mr. */
	private String title = null;

	@Override
	public void changePIN(String newPIN) {
		/*the assumption is that the UI has validated it against the existing PIN
		and other criteria like length*/
		setPIN(newPIN);
		//TODO persist the PIN across sessions
	}

	@Override
	public String getFirstName() {
		return firstName ;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getPIN() {
		return pin ;
	}

	@Override
	public String getTitle() {
		return title ;
	}

	@Override
	public void setPIN(String pin) {
		this.pin = pin;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
