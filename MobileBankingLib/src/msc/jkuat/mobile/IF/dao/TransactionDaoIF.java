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

package msc.jkuat.mobile.IF.dao;

import java.util.List;
import msc.jkuat.mobile.IF.TransactionIF;

/**
 *
 * @author enjogu
 */
public interface TransactionDaoIF {
    /**add transaction
     * @param accountNumber - the account number
     * @param t  - the transaction to add
     * */
    public void addTransaction(TransactionIF t, String accountNumber);
    /**get all available transactions for this account
     * @param accountNumber TODO*/
    public List<TransactionIF> getTransactions(String accountNumber);
}
