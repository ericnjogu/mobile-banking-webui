/**
 * 
 */
package msc.jkuat.mobile.impl.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import msc.jkuat.mobile.IF.TransactionIF;
import msc.jkuat.mobile.impl.Transaction;
import msc.jkuat.mobile.impl.dao.TransactionDao;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class TransactionDaoTest {

	private static TransactionDao td;
	private static Map<String, List<TransactionIF>> tranStore = new HashMap<String, List<TransactionIF>>();
	private static String accountNumber = "3003";
	private static List<TransactionIF> transactions = new ArrayList<TransactionIF>();
	private static Transaction transaction;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		td = new TransactionDao();
		td.setTransactionStore(tranStore );
		tranStore.put(accountNumber , transactions );
		transaction = new Transaction();
		td.addTransaction(transaction, accountNumber);
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.dao.TransactionDao#addTransaction(msc.jkuat.mobile.IF.TransactionIF, java.lang.String)}.
	 */
	@Test
	public void testAddNullTransaction() {
		td.addTransaction(null, accountNumber);
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.dao.TransactionDao#getTransactions(java.lang.String)}.
	 */
	@Test
	public void testGetTransactionsForAccount() {
		assertEquals(transactions, td.getTransactions(accountNumber));
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.dao.TransactionDao#getTransactionStore()}.
	 */
	@Test
	public void testGetTransactionStore() {
		assertEquals(tranStore, td.getTransactionStore());
	}
	/**
	 * test for null transactionStore argument
	 */
	@Test
	public void testSetNullTransactionStore() {
		td.setTransactionStore(null);
	}
}