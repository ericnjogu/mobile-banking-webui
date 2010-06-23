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

package msc.jkuat.mobile.impl;

import java.util.List;

import msc.jkuat.mobile.IF.AccountIF;
import msc.jkuat.mobile.IF.BankServiceIF;
import msc.jkuat.mobile.IF.CustomerAccountIF;
import msc.jkuat.mobile.IF.ForexRateIF;
import msc.jkuat.mobile.IF.UserInfoIF;
import msc.jkuat.mobile.IF.dao.CustomerAccountDaoIF;
import msc.jkuat.mobile.IF.dao.ForexRateDaoIF;
import msc.jkuat.mobile.IF.dao.UtilityAccountDaoIF;

/**
 *
 * @author enjogu
 */
public class BankService implements BankServiceIF {
    /**provides the utility operations - session scoped*/
    private UtilityAccountDaoIF utilityAccountDao;
    /**access to the list of accounts - session scoped*/
    private CustomerAccountDaoIF customerAccountDao;
    /**the user information - session scoped*/
    private UserInfoIF userInfo = null;
    /**forex rate information - session scoped*/
    private ForexRateDaoIF forexRateDao = null;
    
   /**retrieve a list of utility accounts
    * the client will save a local list
    * @return a list of Account objects
    */
   public List<AccountIF> getUtilityAccounts() {
       return this.utilityAccountDao.getAllAccounts();
   }
   /** return a list of customer accounts depending on the info in the session bean
    * user info that will be injected
    *@return CustomerAccountIF objects in a list
    */
   public List<CustomerAccountIF> getCustomerAccounts() {
       return this.customerAccountDao.getAllAccounts(userInfo);
   }

	public void setUserInfo(UserInfoIF userInfo) {
		this.userInfo = userInfo;
	}
	public UserInfoIF getUserInfo() {
		return userInfo;
	}
	/**
	 * @return the utilityAccountDao
	 */
	public UtilityAccountDaoIF getUtilityAccountDao() {
		return utilityAccountDao;
	}
	/**
	 * @param utilityAccountDao the utilityAccountDao to set
	 */
	public void setUtilityAccountDao(UtilityAccountDaoIF utilityAccountDao) {
		this.utilityAccountDao = utilityAccountDao;
	}
	/**
	 * @return the customerAccountDao
	 */
	public CustomerAccountDaoIF getCustomerAccountDao() {
		return customerAccountDao;
	}
	/**
	 * @param customerAccountDao the customerAccountDao to set
	 */
	public void setCustomerAccountDao(CustomerAccountDaoIF customerAccountDao) {
		this.customerAccountDao = customerAccountDao;
	}
	@Override
	public List<ForexRateIF> getForexRates() {
		return forexRateDao.getForexRates();
	}
	/**
	 * @param forexRateDao the forexRateDao to set
	 */
	public void setForexRateDao(ForexRateDaoIF forexRateDao) {
		this.forexRateDao = forexRateDao;
	}
	/**
	 * @return the forexRateDao
	 */
	public ForexRateDaoIF getForexRateDao() {
		return forexRateDao;
	}
}
