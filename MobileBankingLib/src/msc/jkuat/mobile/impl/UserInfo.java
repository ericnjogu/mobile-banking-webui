/*
   Copyright [2010] [Eric Njogu]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

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
