package msc.jkuat.mobile.web.ui;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

//import common.Logger;

public class Ops extends GenericForwardComposer {
	private Label lblAirtime = null;
	private Label lblBill = null;
	private Label lblTransfer = null;
	private Label lblHome = null;
	
	private Logger log = Logger.getLogger(getClass());
	
	public void onClick$lblAirtime() {
		String nxt = (String) lblAirtime.getAttribute("target");
		switchTo(nxt);
	}
	
	public void onClick$lblBill() {
		String nxt = (String) lblBill.getAttribute("target");
		switchTo(nxt);
	}
	
	public void onClick$lblTransfer() {
		String nxt = (String) lblTransfer.getAttribute("target");
		switchTo(nxt);
	}
	
	public void onClick$lblHome() {
		String nxt = (String) lblHome.getAttribute("target");
		switchTo(nxt);
	}
	
	private void switchTo(String nxt) {
		try {
			self.detach();
			@SuppressWarnings("unused")
			Window wnd = (Window) Executions.createComponents(nxt, this.self.getParent(), null);
		} catch (Exception e) {
			log.error("switchTo", e);
		}
	}

}
