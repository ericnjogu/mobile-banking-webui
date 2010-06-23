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

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//import common.Logger;

import msc.jkuat.mobile.IF.AccountIF;
import msc.jkuat.mobile.IF.CustomerAccountIF;
import msc.jkuat.mobile.IF.TransactionIF;
import msc.jkuat.mobile.IF.dao.TransactionDaoIF;

/**
 *operations on a customer account are represented here
 *all the DAOs will be dependency injected as session beans
 * @author enjogu
 */
public class CustomerAccount extends Account implements CustomerAccountIF, ApplicationContextAware{
    /**the balance at a point in time -  the latest at the time of  retrieval*/
    private BigDecimal balance = null;
    /**the source of transactions*/
    private TransactionDaoIF transactionDao;
    /**the interest rate on the account*/
	private BigDecimal interestRate = null;
	/**the minimum balance that the account should maintain. Useful for transactions*/
	private BigDecimal minimumBalance = null;
	/**logging*/
	private Logger log = Logger.getLogger(getClass());
	/**the application context for retrieving the transaction bean*/
	private ApplicationContext appContext = null;
    
	@Override
	public BigDecimal getInterestRate() {
		return interestRate ;
	}
	@Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public void setInterestRate(BigDecimal rate) {
		this.interestRate = rate;
	}
	@Override
	public void buyAirtime(String phoneNumber, BigDecimal amount) throws Exception {
		log.debug("buying airtime");
		if (sufficientFunds(amount, AppConstants.AIRTIME_COMM)) {
			debitWithCommission(amount, AppConstants.AIRTIME_COMM, "Airtime (" + phoneNumber + ")" );
			
			//TODO airtime top up logic
		} else {
			throw new Exception("Balance (" + balance.toString() + " ) insufficient for airtime purchase");
		}
	}
	/**
	 * do the common logic to deduct an amount from this account and charge comm
	 * @param amount - the amount to debit
	 * @param comm - the commission to charge
	 * @param description TODO
	 */
	private void debitWithCommission(BigDecimal amount, BigDecimal comm, String description) {
		log.debug("debiting with commission");
		//debit amount
		debit(amount, description);
	
		//debit commission
		debit(comm, description + " Commission");
	}
	/**
	 * debit this account
	 * @param amount
	 */
	public void debit(BigDecimal amount, String description) {
		log.debug("debit " + description);
		//TODO check for min balance before subtract 
		balance = balance.subtract(amount);
		//generate and store transaction
		TransactionIF t = (TransactionIF) appContext.getBean("transaction");
		t.setAmount(amount);
		t.setDate(Calendar.getInstance().getTime());
		t.setDescription(description);
		t.setDrCrCode(AppConstants.DEBIT);
		transactionDao.addTransaction(t, getNumber());
	}
	/**
	 * credit this account
	 * @param amount - to credit
	 * @param description - to be reflected on the transaction
	 */
	public void credit(BigDecimal amount, String description) {
		balance = balance.add(amount);
		//generate and store transaction
		TransactionIF t = (TransactionIF) appContext.getBean("transaction");
		t.setAmount(amount);
		t.setDate(Calendar.getInstance().getTime());
		t.setDescription(description);
		t.setDrCrCode(AppConstants.CREDIT);
		transactionDao.addTransaction(t, getNumber());
	}
	@Override
	public List<TransactionIF> getMiniStatement() {
		return transactionDao.getTransactions(this.getNumber());
	}
	@Override
	public void payUtilityBill(AccountIF utilityAccount,
			BigDecimal amount, String ref) throws Exception {
		if (sufficientFunds(amount, AppConstants.UTILITY_COMM)) {
			debitWithCommission(amount, AppConstants.UTILITY_COMM, utilityAccount.getName());
			//TODO credit utility account
		} else {
			throw new Exception("Balance (" + balance.toString() + " ) insufficient for Utility Bill");
		}
	}
	@Override
	public void transferFundsTo(CustomerAccountIF customerAccountTo,
			BigDecimal amount) throws Exception {
		String desc = "Funds Transfer";
		if (sufficientFunds(amount, AppConstants.TRANSFER_COMM)) {
			//debit this source account
			debitWithCommission(amount, AppConstants.TRANSFER_COMM, desc);
			//credit destination account
			customerAccountTo.credit(amount, desc);
		} else {
			throw new Exception("Balance (" + balance.toString() + " ) insufficient for " + desc);
		}
		
	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public BigDecimal getMinimumBalance() {
		return minimumBalance;
	}

	@Override
	public void setMinimumBalance(BigDecimal minBal) {
		minimumBalance = minBal;
	}
	/**
	 * check if this account has enough to carry out a transaction
	 * @param debitAmount - the amount to be debited from the account
	 * @param commission - what the bank gets for its trouble
	 * @return
	 */
	private boolean sufficientFunds(BigDecimal debitAmount, BigDecimal commission) { 
		if (balance.subtract(debitAmount.add(commission)).compareTo(minimumBalance) == -1) {
			return false;
		} else {
			 return true;
		}
	}
	/**
	 * @return the transactionDao
	 */
	public TransactionDaoIF getTransactionDao() {
		return transactionDao;
	}
	/**
	 * @param transactionDao the transactionDao to set
	 */
	public void setTransactionDao(TransactionDaoIF transactionDao) {
		this.transactionDao = transactionDao;
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.appContext = arg0;
	}
}
