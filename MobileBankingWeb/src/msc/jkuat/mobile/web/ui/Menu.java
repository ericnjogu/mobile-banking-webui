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
//import java.awt.Event;

import org.zkoss.zul.Menuitem;


public class Menu extends ForwardComposer {
	//private Logger log = Logger.getLogger(getClass());
	private Menuitem mnuAcs = null;
	private Menuitem mnuFrx = null;
	private Menuitem mnuOps = null;
	private Menuitem mnuChgPin = null;
	private Menuitem mnuLogout = null;
	private Menuitem mnuAir = null;
	private Menuitem mnuBill = null;
	private Menuitem mnuTfr = null;
	
	public void onClick$mnuTfr() {
		switchFrom(mnuTfr);
	}
	
	public void onClick$mnuBill() {
		switchFrom(mnuBill);
	}
	
	public void onClick$mnuAir() {
		switchFrom(mnuAir);
	}
	
	public void onClick$mnuFrx() {
		switchFrom(mnuFrx);
	}
	
	public void onClick$mnuOps() {
		switchFrom(mnuOps);
	}
	
	public void onClick$mnuChgPin() {
		switchFrom(mnuChgPin);
	}
	
	public void onClick$mnuLogout() {
		log.debug("Logout clicked");
		switchFrom(mnuLogout);
		page.getFellow("mnuBar").setVisible(false);
		//enable so that when the menu is made visible again, it will be business as usual
		mnuLogout.setDisabled(false);
	}
	
	public void onClick$mnuAcs() {
		//change if the content is not already showing
		log.debug(mnuAcs.getId() + " clicked");
		switchFrom(mnuAcs);
	}
	
	private void switchFrom(Menuitem mnu) {
			switchTo((String) mnu.getAttribute("target"));
			if (self.getAttribute("selected") != null) {
				Menuitem mnuPrev = (Menuitem)self.getAttribute("selected");
				mnuPrev.setDisabled(false);
			}
			mnu.setDisabled(true);
			self.setAttribute("selected", mnu);
		/*} else {
			log.debug(mnu.getLabel() + " content already showing");
		}*/
		
	}

	/*private String switchTo(String nxt) {
		//log.debug("Logon is " + logon);
		try {
			Component content = page.getFellow("content");
			String current = (String) content.getAttribute("current");
			//log.debug("current before switch to " + nxt + " is " + current);
			page.getFellow(current).detach();
			Window wnd = (Window) Executions.createComponents(nxt, content, null);
			return wnd.getId();
		} catch (Exception e) {
			log.error("switchTo", e);
			return null;
		}
	}*/
}
