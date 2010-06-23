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

import org.apache.log4j.Logger;

import msc.jkuat.mobile.IF.CustomerAccountIF;
import msc.jkuat.mobile.IF.UserInfoIF;
import msc.jkuat.mobile.IF.dao.CustomerAccountDaoIF;

/**
 *
 * @author enjogu
 */
public class CustomerAccountDao implements CustomerAccountDaoIF{
	/**a list of accounts to be injected via spring*/
	private List<CustomerAccountIF> customerAccountStore = null;
	/**logging*/
	Logger log = Logger.getLogger(getClass());
	
	/**
	 * @param customerAccts the customerAccounts to set
	 */
	public void setCustomerAccountStore(List<CustomerAccountIF> customerAccts) {
		if (customerAccts == null) {
			throw new IllegalArgumentException("customerAccounts should not be null");
		}
		this.customerAccountStore = customerAccts;
	}
	/**
	 * @return the customerAccounts
	 */
	public List<CustomerAccountIF> getCustomerAccountStore() {
		return customerAccountStore;
	}
	@Override
	public List<CustomerAccountIF> getAllAccounts(UserInfoIF userInfo) {
		//log.debug("returning " + customerAccountStore.size() + " accounts");
		return customerAccountStore;
	}

}
