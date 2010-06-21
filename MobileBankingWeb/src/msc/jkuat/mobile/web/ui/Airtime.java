package msc.jkuat.mobile.web.ui;
import msc.jkuat.mobile.IF.CustomerAccountIF;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Button;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;


public class Airtime extends ForwardComposer {
	private Button btnCancel = null;
	@SuppressWarnings("unused")
	private Button btnBuy = null;
	private Decimalbox txtPhone = null;
	private Decimalbox txtAmount = null;
	private Listbox lstAcs = null;
	private Logger log = Logger.getLogger(getClass());
	
	public void onClick$btnCancel() {
		String nxt = (String) btnCancel.getAttribute("target");
		switchTo(nxt);
	}
	
	public void onClick$btnBuy() {
		if (txtPhone.getValue() == null) {
			throw new WrongValueException(txtPhone, "Should not be blank");
		}
		if (txtAmount.getValue() == null) {
			throw new WrongValueException(txtAmount, "Should not be blank");
		}
		CustomerAccountIF ca = (CustomerAccountIF) lstAcs.getSelectedItem().getValue();
		try {
			ca.buyAirtime(txtPhone.getValue().toPlainString(), txtAmount.getValue());
		} catch (Exception e) {
			log.error("onClick$btnBuy", e);
			throw new WrongValueException(txtAmount, e.getMessage());
		}
		try {
			Messagebox.show("Airtime purchased");
		} catch (InterruptedException e) {
			log.error("Messagebox.show", e);
		}
		//do not switch
		/*String nxt = (String) btnBuy.getAttribute("target");
		switchTo(nxt);*/
	}
	
	
	/*private void switchTo(String nxt) {
		try {
			self.detach();
			Window wnd = (Window) Executions.createComponents(nxt, this.self.getParent(), null);
			//this needs to be set so that the menu can work next time it is clicked
			page.getFellow("content").setAttribute("current", wnd.getId());
		} catch (Exception e) {
			log.error("switchTo", e);
		}
	}*/
	/**
	 * validating onClick instead
	 */
	/*public void onChange$txtAmount() {
		manipulateBtnChange();
	}
	
	public void onChange$txtPhone() {
		manipulateBtnChange();
	}

	private void manipulateBtnChange() {
		if (txtAmount.getValue() != null && txtPhone.getValue() != null) {
			btnBuy.setDisabled(false);
		}
	}*/
}
