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
