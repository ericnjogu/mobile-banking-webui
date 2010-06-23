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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.impl.dao;

import java.util.List;

import msc.jkuat.mobile.IF.AccountIF;
import msc.jkuat.mobile.IF.dao.UtilityAccountDaoIF;

/**
 *
 * @author enjogu
 */
public class UtilityAccountDao implements UtilityAccountDaoIF{
	private List<AccountIF> utilityAccountStore = null;
	@Override
	public List<AccountIF> getAllAccounts() {
		return utilityAccountStore;
	}
	/**
	 * @param utilAccounts the utilityAccountStore to set
	 */
	public void setUtilityAccountStore(List<AccountIF> utilAccounts) {
		if (utilAccounts == null) {
			throw new IllegalArgumentException("utilityAccountStore should not be null");
		}
		this.utilityAccountStore = utilAccounts;
	}
	/**
	 * @return the utilityAccountStore
	 */
	public List<AccountIF> getUtilityAccountStore() {
		return utilityAccountStore;
	}

}
