/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF;

import java.util.List;

/**
 *this is meant to be a proxy object for the remote system - mainly.
 * it has some methods that will get local data.
 * It should ideally not do any UI work therefore reconsider the doOperation method
 * @author enjogu
 */
public interface BankServiceIF {
    /**
     * return a list of customer accounts that have been registered for this bank
     * @return CustomerAccount objects in a list
     */
    List<CustomerAccountIF> getCustomerAccounts();
    /**
     * retrieve a list of utility accounts
     * the client will save a local list
     * @return a list of Account objects
     */
    public List<AccountIF> getUtilityAccounts();
    /**retrieve an account by number*/
  
    /**get all the forex rates
     * @return a list of forex rate objects
     */
    public List<ForexRateIF> getForexRates();
    
}
