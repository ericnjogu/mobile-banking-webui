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

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;


public class ChangePin extends ForwardComposer {
	private Textbox txtCurrent = null;
	private Textbox txtNew1 = null;
	private Textbox txtNew2 = null;
	@SuppressWarnings("unused")
	private Label lblMsg = null;
	private Button btnChange = null;
	private Button btnCancel = null;
	
//	Logger log = Logger.getLogger(getClass());
	
	/**handle onClick on cancel button*/
	public void onClick$btnCancel() {
		//go to logon screen and disable the menubar
		String nxt = (String) btnCancel.getAttribute("target");
		switchTo(nxt);
	}
	
	/*private void switchToNext() {
		self.detach();
		String nxt = (String) self.getAttribute("next");
		Window wnd = (Window) Executions.createComponents(nxt, self.getParent(), null);
		//TODO this code (switching, appears in all backing components. Implement a parent component for that
		page.getFellow("content").setAttribute("current", wnd.getId());
		TODO - the strings above - content and current should be created as constants for access both from the
		 * java components and zul pages 
		 
	}*/

	public void onClick$btnChange() {
		UserInfoIF user = (UserInfoIF) SpringUtil.getBean("user_info");
		log.debug("Current password is " + user.getPIN());
		if (!user.getPIN().equalsIgnoreCase(txtCurrent.getText())) {
			throw new WrongValueException(txtCurrent, "Current PIN does not match");
		}
		
		if (txtCurrent.getText().trim() == "") {
			throw new WrongValueException(txtCurrent, "Current PIN is blank");
		}
		if (txtNew1.getText().trim() == "") {
			throw new WrongValueException(txtNew1, "New PIN is blank");
		}
		if (txtNew2.getText().trim() == "") {
			throw new WrongValueException(txtNew2, "Confirmation PIN is blank");
		}
		
		if (!txtNew2.getText().trim().equalsIgnoreCase(txtNew1.getText().trim())) {
			throw new WrongValueException(txtNew1, "New and Confirmation PIN are different");
		}
		user.changePIN(txtNew2.getText().trim());
		log.debug("PIN changed to " + user.getPIN());
		try {
			Messagebox.show("PIN changed. Please relogon with new PIN");
		} catch (InterruptedException e) {
			log.error("onClick$btnChange", e);
		}
		String nxt = (String) btnChange.getAttribute("target");
		switchTo(nxt);
		page.getFellow("mnuBar").setVisible(false);
	}
	
	/**
	 * 21-04-09 commented out since we are not validating onchange anymore but
	 * rather on
	 */
	/*public void onChange$txtCurrent() {
		manipulateBtnChange();
	}
	
	public void onChange$txtNew1() {
		manipulateBtnChange();
	}
	
	public void onChange$txtNew2() {
		manipulateBtnChange();
	}

	private void manipulateBtnChange() {
		if (txtCurrent.getText().trim() != "" 
			&& txtNew1.getText().trim() != "" && txtNew2.getText().trim() != "") {
			btnChange.setDisabled(false);
			//lblMsg.setVisible(false);
		}
	}*/
}
