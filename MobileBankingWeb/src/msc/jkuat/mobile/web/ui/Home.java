package msc.jkuat.mobile.web.ui;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;


public class Home extends GenericForwardComposer {
	/**logging facility*/
	Logger log = Logger.getLogger(getClass());
	
	/**handle the onclick event for the label*/
	public void onClick$lblLogout() {
		String logon = (String) self.getAttribute("logon");
		switchTo(logon);
	}
	
	public void onClick$lblChgPin() {
		String nxt = (String) self.getAttribute("changePin");
		switchTo(nxt);
	}
	
	public void onClick$lblFrx() {
		String nxt = (String) self.getAttribute("forex");
		switchTo(nxt);
	}
	
	public void onClick$lblAcs() {
		String nxt = (String) self.getAttribute("accounts");
		switchTo(nxt);
	}
	
	public void onClick$lblOps() {
		String nxt = (String) self.getAttribute("ops");
		switchTo(nxt);
	}

	private void switchTo(String nxt) {
		//log.debug("Logon is " + logon);
		try {
			self.detach();
			@SuppressWarnings("unused")
			Window wnd = (Window) Executions.createComponents(nxt, this.self.getParent(), null);
		} catch (Exception e) {
			log.error("switchTo", e);
		}
	}
}
