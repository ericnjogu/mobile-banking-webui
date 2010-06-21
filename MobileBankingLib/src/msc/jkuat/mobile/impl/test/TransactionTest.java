/**
 * 
 */
package msc.jkuat.mobile.impl.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import msc.jkuat.mobile.impl.AppConstants;
import msc.jkuat.mobile.impl.Transaction;
/**
 * @author protosoft
 *
 */
public class TransactionTest {

	private static Transaction transaction;
	private static BigDecimal amount = new BigDecimal(99);
	private static Date date = Calendar.getInstance().getTime();
	private static String description = "Testing";
	private static String drCrCode = AppConstants.DEBIT;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		transaction = new Transaction();
		transaction.setAmount(amount );
		transaction.setDate(date );
		transaction.setDescription(description );
		transaction.setDrCrCode(drCrCode );
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.Transaction#getDate()}.
	 */
	@Test
	public void testGetDate() {
		assertEquals(date, transaction.getDate());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.Transaction#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		assertEquals(description, transaction.getDescription());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.Transaction#getAmount()}.
	 */
	@Test
	public void testGetAmount() {
		assertEquals(amount, transaction.getAmount());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.Transaction#getDrCrCode()}.
	 */
	@Test
	public void testGetDrCrCode() {
		assertEquals(drCrCode, transaction.getDrCrCode());
	}
}
