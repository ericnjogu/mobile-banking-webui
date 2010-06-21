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
