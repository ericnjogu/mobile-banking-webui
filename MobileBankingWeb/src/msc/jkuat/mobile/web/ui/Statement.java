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
