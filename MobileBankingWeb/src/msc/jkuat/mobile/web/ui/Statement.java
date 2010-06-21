package msc.jkuat.mobile.web.ui;

import org.zkoss.zul.Label;


public class Statement extends ForwardComposer {
	private Label lblBack = null;
	
	public void onClick$lblBack() {
		String back = (String) lblBack.getAttribute("back");
		/*self.detach();
		Window wnd = (Window) Executions.createComponents(back, this.self.getParent(), null);
		page.getFellow("content").setAttribute("current", wnd.getId());*/
		switchTo(back);
	}
}
