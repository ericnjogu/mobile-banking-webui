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

package msc.jkuat.mobile.impl.dao;

import java.util.List;

import msc.jkuat.mobile.IF.ForexRateIF;
import msc.jkuat.mobile.IF.dao.ForexRateDaoIF;

public class ForexRateDao implements ForexRateDaoIF {
	/**a list of forex rates. to be injected via spring*/
	private List<ForexRateIF> forexStore = null;
	@Override
	public List<ForexRateIF> getForexRates() {
		return forexStore;
	}
	/**
	 * @param forexStore the forexStore to set
	 */
	public void setForexStore(List<ForexRateIF> forexList) {
		if (forexList == null) {
			throw new IllegalArgumentException("forexList should not be null");
		}
		this.forexStore = forexList;
	}
	/**
	 * @return the forexStore
	 */
	public List<ForexRateIF> getForexStore() {
		return forexStore;
	}
}
