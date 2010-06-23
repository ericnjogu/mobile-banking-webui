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
package msc.jkuat.mobile.impl.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import msc.jkuat.mobile.IF.CustomerAccountIF;
import msc.jkuat.mobile.impl.dao.CustomerAccountDao;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class CustomerAccountDaoTest {

	private static CustomerAccountDao cao;
	private static List<CustomerAccountIF> customerAccounts = new ArrayList<CustomerAccountIF>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cao = new CustomerAccountDao();
		cao.setCustomerAccountStore(customerAccounts );
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.dao.CustomerAccountDao#getCustomerAccountStore()}.
	 */
	@Test
	public void testGetCustomerAccounts() {
		assertEquals(customerAccounts, cao.getCustomerAccountStore());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.dao.CustomerAccountDao#getAllAccounts(msc.jkuat.mobile.IF.UserInfoIF)}.
	 */
	@Test
	public void testGetAllAccounts() {
		assertEquals(customerAccounts, cao.getAllAccounts(null));
	}
	
	@Test
	//TODO how do I test for expected errors 
	public void testSetNullCustomerAccounts() {
		cao.setCustomerAccountStore(null);
	}
}
