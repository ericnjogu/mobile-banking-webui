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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

//import common.Logger;

import msc.jkuat.mobile.IF.TransactionIF;
import msc.jkuat.mobile.IF.dao.TransactionDaoIF;

/**
 *
 * @author enjogu
 */
public class TransactionDao implements TransactionDaoIF {
	/**TODO default implementation. to be set via spring configuration file
	 * to hold accountNumber, transaction_list pairs
	 * 
	 * In the meantime, start off with an empty list since I need to know how to input dates
	 *  via spring configuration first
	 */
	private Map<String, List<TransactionIF>> transactionStore = null;
	
	/**logging*/
	Logger log = Logger.getLogger(getClass());
	
    /**
	 * default constructor
	 */
	public TransactionDao() {
		//initialize transactionStore - as an alternative to spring injection
		transactionStore = new HashMap<String, List<TransactionIF>>();
	}
	@Override
	public void addTransaction(TransactionIF t, String accountNumber) {
        if (t == null) {
        	throw new IllegalArgumentException("transaction is null");
        }
        if (accountNumber == null) {
        	throw new IllegalArgumentException("accountNumber is null");
        }
        //check if the account exists
    	if (transactionStore.containsKey(accountNumber)) {
    		getTransactions(accountNumber).add(t);
    	} else {
    		List<TransactionIF> list = new ArrayList<TransactionIF>();
    		list.add(t);
    		transactionStore.put(accountNumber, list);
    	}
    	log.debug("added transaction for " + accountNumber);
    }
	@Override
    public List<TransactionIF> getTransactions(String accountNumber) {
    	if (transactionStore.containsKey(accountNumber)) {
    		return transactionStore.get(accountNumber);
    	} else {
    		return null;
    		//throw new IllegalArgumentException("'" + accountNumber + "' not found in transaction map");
    	}
    }

	/**
	 * @param transactionStore the transactionStore to set
	 */
	public void setTransactionStore(Map<String, List<TransactionIF>> transactionStore) {
		if (transactionStore == null) {
			throw new IllegalArgumentException("transactionStore should not be null");
		}
		this.transactionStore = transactionStore;
	}

	/**
	 * @return the transactionStore
	 */
	public Map<String, List<TransactionIF>> getTransactionStore() {
		return transactionStore;
	}

}
