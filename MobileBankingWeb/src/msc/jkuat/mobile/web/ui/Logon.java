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

package msc.jkuat.mobile.web.ui;

import msc.jkuat.mobile.IF.UserInfoIF;

import org.apache.log4j.Logger;
import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 * processes actions on the logon window
 * @author protosoft
 *
 */

public class Logon extends GenericForwardComposer {
	/**the pin textbox*/
	private Textbox txtPin = null;
	/**logging facility*/
	private Logger log = Logger.getLogger(getClass());
	/*public void onChange$txtPin(Event evt) {
		//log.debug("txtPin contains '" + txtPin.getText() + "'");
		if (txtPin.getText() == "") {
			btnLogin.setDisabled(true);
		} else {
			btnLogin.setDisabled(false);
			lblLogin.setVisible(false);
		}
	}*/
	private String next = null;

	/**
	 * track clicks on the login button
	 * @param evt
	 */
	public void onClick$btnLogin(Event evt) {
		//hard code a password/PIN
		if (validatePIN(txtPin.getText())) {
			String nxt = (String) self.getAttribute("next");
			log.debug("PIN given on as " + txtPin.getText());
			try {
				self.detach();
				Window wnd = (Window) Executions.createComponents(nxt, page.getFellow("content"), null);
				log.debug(wnd.getId() + " displayed on login");
				page.getFellow("content").setAttribute("current", wnd.getId());
				page.getFellow("mnuBar").setVisible(true);
			} catch (Exception e) {
				log.error("onClick$btnLogin", e);
			}
		} else {
			throw new WrongValueException(txtPin,"The PIN is invalid");
		}
	}
	/**
	 * track changes on the pin txt box and manipulate the login button
	 * 21-04-09 commented out since tabs may not work as expected on a mobile device
	 * whereas you need to tab out of the PIN text box to get the onChange to fire
	 * @param evt
	 */
	/*public void onChange$txtPin(Event evt) {
		//log.debug("txtPin contains '" + txtPin.getText() + "'");
		if (txtPin.getText() == "") {
			btnLogin.setDisabled(true);
		} else {
			btnLogin.setDisabled(false);
			lblLogin.setVisible(false);
		}
	}*/
	/**can be overriden to create a concrete impl of validation
	 * and population of the userInfo spring bean
	 * @param text
	 * @return
	 */
	protected boolean validatePIN(String text) {
		UserInfoIF user = (UserInfoIF) SpringUtil.getBean("user_info");
		if (text.equalsIgnoreCase(user.getPIN())) {
			return true;
		} else if (text.trim().equalsIgnoreCase("")){
			return false;
		} else {
			return false;
		}
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(String next) {
		this.next = next;
	}
	/**
	 * @return the next
	 */
	public String getNext() {
		return next;
	}
}
