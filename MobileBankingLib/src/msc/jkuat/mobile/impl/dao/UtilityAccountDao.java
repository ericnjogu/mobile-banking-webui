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
