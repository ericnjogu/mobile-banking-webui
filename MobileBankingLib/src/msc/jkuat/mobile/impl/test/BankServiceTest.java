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

import java.util.ArrayList;
import java.util.List;

import msc.jkuat.mobile.IF.AccountIF;
import msc.jkuat.mobile.IF.CustomerAccountIF;
import msc.jkuat.mobile.IF.ForexRateIF;
import msc.jkuat.mobile.IF.UserInfoIF;
import msc.jkuat.mobile.impl.BankService;
import msc.jkuat.mobile.impl.UserInfo;
import msc.jkuat.mobile.impl.dao.CustomerAccountDao;
import msc.jkuat.mobile.impl.dao.ForexRateDao;
import msc.jkuat.mobile.impl.dao.UtilityAccountDao;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class BankServiceTest {

	private static BankService bs;
	private static CustomerAccountDao customerAccountDao = new CustomerAccountDao();
	private static List<CustomerAccountIF> customerAccts = new  ArrayList<CustomerAccountIF>();
	private static UtilityAccountDao utilityAccountDao = new UtilityAccountDao();
	private static List<AccountIF> utilAccounts = new ArrayList<AccountIF>();
	private static UserInfoIF userInfo = new UserInfo();
	private static ForexRateDao forexRateDao = new ForexRateDao();
	private static List<ForexRateIF> forexList = new ArrayList<ForexRateIF>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bs = new BankService();
		bs.setCustomerAccountDao(customerAccountDao );
		customerAccountDao.setCustomerAccountStore(customerAccts );
		bs.setUtilityAccountDao(utilityAccountDao);
		utilityAccountDao.setUtilityAccountStore(utilAccounts);
		bs.setUserInfo(userInfo );
		bs.setForexRateDao(forexRateDao );
		forexRateDao.setForexStore(forexList );
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.BankService#getUtilityAccounts()}.
	 */
	@Test
	public void testGetUtilityAccounts() {
		assertEquals(utilAccounts, bs.getUtilityAccounts());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.BankService#getCustomerAccounts()}.
	 */
	@Test
	public void testGetCustomerAccounts() {
		assertEquals(customerAccts, bs.getCustomerAccounts());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.BankService#getUserInfo()}.
	 */
	@Test
	public void testGetUserInfo() {
		assertEquals(userInfo, bs.getUserInfo());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.BankService#getUtilityAccountDao()}.
	 */
	@Test
	public void testGetUtilityAccountDao() {
		assertEquals(utilityAccountDao, bs.getUtilityAccountDao());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.BankService#getCustomerAccountDao()}.
	 */
	@Test
	public void testGetCustomerAccountDao() {
		assertEquals(customerAccountDao, bs.getCustomerAccountDao());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.BankService#getForexRates()}.
	 */
	@Test
	public void testGetForexRates() {
		assertEquals(forexList, bs.getForexRates());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.BankService#getForexRateDao()}.
	 */
	@Test
	public void testGetForexRateDao() {
		assertEquals(forexRateDao, bs.getForexRateDao());
	}
	//TODO test for setXXX(null) exp for DAOs
}
