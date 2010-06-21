package msc.jkuat.mobile.web.ui;

import java.util.Map;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;
/**
 * meant to hold the common code for the 'applied' classes
 * applied in the meaning that they have been used in the apply
 * attribute of the components in the ZUL files
 * @author enjogu
 *
 */
public class ForwardComposer extends GenericForwardComposer {
	protected Logger log = Logger.getLogger(getClass());
	/**
	 * switch from one window to the next within the specified area
	 * @param nxt - the path to the file containing the new window
	 * @return - the id of
	 */
	protected void switchTo(String nxt, Map<String, Object> arg) {
		//log.debug("Logon is " + logon);
		try {
			Component content = page.getFellow("content");
			String current = (String) content.getAttribute("current");
			log.debug("nxt is " + nxt);
			page.getFellow(current).detach();
			Window wnd = (Window) Executions.createComponents(nxt, content, arg);
			page.getFellow("content").setAttribute("current", wnd.getId());
			//return wnd.getId();
		} catch (Exception e) {
			log.error("switchTo", e);
			//return null;
		}
	}
	
	protected void switchTo(String nxt) {
		switchTo(nxt, null);
	}
}
