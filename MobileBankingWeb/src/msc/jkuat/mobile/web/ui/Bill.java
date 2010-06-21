package msc.jkuat.mobile.web.ui;

import msc.jkuat.mobile.IF.AccountIF;
import msc.jkuat.mobile.IF.CustomerAccountIF;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Button;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;

public class Bill extends ForwardComposer {
	private Button btnCancel = null;
	@SuppressWarnings("unused")
	private Button btnPay = null;
	private Decimalbox txtAmount = null;
	private Listbox lstAcsFrom = null;
	private Listbox lstAcsUtil = null;
	private Logger log = Logger.getLogger(getClass());
	
	public void onClick$btnCancel() {
		String nxt = (String) btnCancel.getAttribute("target");
		switchTo(nxt);
	}
	
	public void onClick$btnPay() {
		if (txtAmount.getValue() == null) {
			throw new WrongValueException(txtAmount, "Should not be blank");
		}
		AccountIF caUtil = (AccountIF) lstAcsUtil.getSelectedItem().getValue();
		CustomerAccountIF caFrom = (CustomerAccountIF) lstAcsFrom.getSelectedItem().getValue();
		try {
			caFrom.payUtilityBill(caUtil, txtAmount.getValue(), null);
		} catch (Exception e) {
			log.error("onClick$btnPay", e);
			throw new WrongValueException(txtAmount, e.getMessage());
		}
		try {
			Messagebox.show("Bill paid");
		} catch (InterruptedException e) {
			log.error("Messagebox.show", e);
		}
		//keep it here
		/*String nxt = (String) btnPay.getAttribute("target");
		switchTo(nxt);*/
	}
	
	
	/*private void switchTo(String nxt) {
		try {
			self.detach();
			Window wnd = (Window) Executions.createComponents(nxt, this.self.getParent(), null);
			page.getFellow("content").setAttribute("current", wnd.getId());
		} catch (Exception e) {
			log.error("switchTo", e);
		}
	}*/
	
	/**validation done onClick
	 * 
	 */
	/*public void onChange$txtAmount() {
		manipulateBtnChange();
	}

	private void manipulateBtnChange() {
		if (txtAmount.getValue() != null) {
			btnPay.setDisabled(false);
		}
	}*/
}
