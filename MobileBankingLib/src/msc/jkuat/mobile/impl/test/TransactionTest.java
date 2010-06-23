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
