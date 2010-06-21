package msc.jkuat.mobile.web.ui;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;

import common.Logger;

public class LabelLink extends GenericForwardComposer {
	Logger log = Logger.getLogger(getClass());
	private Window homeMacro = null;
	public void onClick() {
		log.debug(Path.getPath(self) + " clicked");
		//log.debug("homeMacro title " + homeMacro.getTitle());
		//TODO generalize so that a Label Link can be contained by other windows
		homeMacro.detach();
		@SuppressWarnings("unused")
		Window wnd = (Window) Executions.createComponents((String) self.getAttribute("target"), this.self.getParent(), null);
	}
}
