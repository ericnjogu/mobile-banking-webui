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
