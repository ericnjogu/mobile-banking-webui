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
