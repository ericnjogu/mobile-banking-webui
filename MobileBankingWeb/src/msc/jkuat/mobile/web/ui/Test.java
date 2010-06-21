package msc.jkuat.mobile.web.ui;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Messagebox;

public class Test extends GenericForwardComposer {
	public void onClick$btnClick() {
		try {
			Messagebox.show("Who knows?\n It not my fault");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
