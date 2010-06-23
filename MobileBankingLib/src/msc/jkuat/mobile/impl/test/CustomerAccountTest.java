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

/**
 * 
 */
package msc.jkuat.mobile.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import msc.jkuat.mobile.IF.AccountIF;
import msc.jkuat.mobile.impl.AppConstants;
import msc.jkuat.mobile.impl.CustomerAccount;
import msc.jkuat.mobile.impl.Transaction;
import msc.jkuat.mobile.impl.dao.TransactionDao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class CustomerAccountTest {

	private static CustomerAccount ca;
	private static BigDecimal rate = BigDecimal.TEN;
	private static BigDecimal balance = new BigDecimal(100);
	private static BigDecimal minBal =  new BigDecimal(5);
	private BigDecimal transactionAmt = BigDecimal.ONE;
	private String description = "Test Transaction";
	private static CustomerAccount customerAccountTo;
	private static String accountNumber = "3003";
	private BigDecimal balAfterAirtime = balance.subtract((AppConstants.AIRTIME_COMM.add(transactionAmt)));
	private BigDecimal balAfterDebit = balance.subtract(transactionAmt);
	private BigDecimal balAfterCredit = balance.add(transactionAmt);
	private BigDecimal balAfterUtility = balance.subtract((AppConstants.UTILITY_COMM.add(transactionAmt)));
	private BigDecimal balAfterTransfer = balance.subtract((AppConstants.TRANSFER_COMM.add(transactionAmt)));
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ca = new CustomerAccount();
		ca.setInterestRate(rate );
		ca.setMinimumBalance(minBal );
		ca.setNumber(accountNumber );
		customerAccountTo = new CustomerAccount();
		customerAccountTo.setTransactionDao(new TransactionDao());
		customerAccountTo.setBalance(balance);
		customerAccountTo.setNumber(accountNumber);
	}
	@Before
	public void setUpBeforeMethod() throws Exception {
		//restore balance
		ca.setBalance(balance);
		//start with a clean transaction list every time
		ca.setTransactionDao(new TransactionDao());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.CustomerAccount#getInterestRate()}.
	 */
	@Test
	public void testGetInterestRate() {
		assertEquals(rate, ca.getInterestRate());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.CustomerAccount#buyAirtime(java.lang.String, java.math.BigDecimal)}.
	 * @throws Exception 
	 */
	@Test
	public void testBuyAirtime() throws Exception {
		//try {
			ca.buyAirtime(null, BigDecimal.ONE);
			assertEquals(balAfterAirtime , ca.getBalance());
			//airtime and commission debits
			assertEquals(2, ca.getMiniStatement().size());
		/*} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.CustomerAccount#debit(java.math.BigDecimal, java.lang.String)}.
	 */
	@Test
	public void testDebit() {
		ca.debit(transactionAmt, description);
		assertEquals(balAfterDebit , ca.getBalance());
		Transaction t = (Transaction) ca.getMiniStatement().get(0);
		assertEquals(description, t.getDescription());
		assertEquals(transactionAmt, t.getAmount());
		assertEquals(AppConstants.DEBIT, t.getDrCrCode());
		assertNotNull(t.getDate());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.CustomerAccount#credit(java.math.BigDecimal, java.lang.String)}.
	 */
	@Test
	public void testCredit() {
		ca.credit(transactionAmt, description);
		assertEquals(balAfterCredit , ca.getBalance());
		Transaction t = (Transaction) ca.getMiniStatement().get(0);
		assertEquals(description, t.getDescription());
		assertEquals(transactionAmt, t.getAmount());
		assertEquals(AppConstants.CREDIT, t.getDrCrCode());
		assertNotNull(t.getDate());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.CustomerAccount#getMiniStatement()}.
	 */
	@Test
	@Ignore// - this method is tested under other methods e.g. pay bill
	public void testGetMiniStatement() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.CustomerAccount#payUtilityBill(AccountIF, java.math.BigDecimal, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testPayUtilityBill() throws Exception {
		//try {
			ca.payUtilityBill(null, transactionAmt, description);
			assertEquals(balAfterUtility , ca.getBalance());
			//utility and commission debits
			assertEquals(2, ca.getMiniStatement().size());
		/*} catch (Excepti
		 * on e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.CustomerAccount#transferFundsTo(msc.jkuat.mobile.IF.CustomerAccountIF, java.math.BigDecimal)}.
	 * @throws Exception 
	 */
	@Test
	public void testTransferFundsTo() throws Exception {
		//try {
			ca.transferFundsTo(customerAccountTo, transactionAmt);
			assertEquals(balAfterTransfer , ca.getBalance());
			//transfer and commission debits
			assertEquals(2, ca.getMiniStatement().size());
			//test destn account
			assertEquals(balAfterCredit,customerAccountTo.getBalance());
			assertEquals(1, customerAccountTo.getMiniStatement().size());
		/*} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.CustomerAccount#getBalance()}.
	 */
	@Test
	public void testGetBalance() {
		assertEquals(balance, ca.getBalance());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.CustomerAccount#getMinimumBalance()}.
	 */
	@Test
	public void testGetMinimumBalance() {
		assertEquals(minBal, ca.getMinimumBalance());
	}

}
