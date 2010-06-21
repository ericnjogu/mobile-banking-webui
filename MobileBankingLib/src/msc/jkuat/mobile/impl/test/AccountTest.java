/**
 * 
 */
package msc.jkuat.mobile.impl.test;

import static org.junit.Assert.*;

import msc.jkuat.mobile.impl.Account;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class AccountTest {

	private static Account account;
	private static String name = "Account";
	private static String number = "3003";
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		account = new Account();
		account.setName(name);
		account.setNumber(number);
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.Account#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals(name, account.getName());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.Account#getNumber()}.
	 */
	@Test
	public void testGetNumber() {
		assertEquals(number, account.getNumber());
	}

}
