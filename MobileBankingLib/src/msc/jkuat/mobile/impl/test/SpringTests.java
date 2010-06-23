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

import java.math.BigDecimal;

import msc.jkuat.mobile.impl.BankService;
import msc.jkuat.mobile.impl.Transaction;
import msc.jkuat.mobile.impl.dao.CustomerAccountDao;
import msc.jkuat.mobile.impl.dao.ForexRateDao;
import msc.jkuat.mobile.impl.dao.UtilityAccountDao;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author protosoft
 *
 */
public class SpringTests {
	private static ClassPathXmlApplicationContext factory;

	@BeforeClass
	public static void setupSpring() {
		factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
	@Test
	public void testInit() {
		assertNotNull(factory);
	}
	@Test
	public void testPlainBeans() {
		assertNotNull(factory.getBean("user_info"));
		assertNotNull(factory.getBean("transaction_dao"));
		assertEquals("dd-MMM-yyyy", ((Transaction)factory.getBean("transaction")).getDateFormat());
	}
	@Test
	public void testForexDao() {
		ForexRateDao fd = (ForexRateDao) factory.getBean("forex_dao");
		assertEquals(3, fd.getForexRates().size());
		assertEquals(new BigDecimal(15), fd.getForexRates().get(0).getRate());
	}
	@Test
	public void testUtilityDao() {
		UtilityAccountDao ud =  (UtilityAccountDao) factory.getBean("utility_dao");
		assertEquals(4, ud.getAllAccounts().size());
		assertEquals("3002", ud.getAllAccounts().get(1).getNumber());
	}
	@Test
	public void testCustomerAccountDao() {
		CustomerAccountDao cad = (CustomerAccountDao) factory.getBean("customer_account_dao");
		assertEquals(4, cad.getAllAccounts(null).size());
		assertEquals(new BigDecimal(5), cad.getAllAccounts(null).get(3).getMinimumBalance());
	}
	@Test
	public void testBankService() {
		BankService bs = (BankService) factory.getBean("bank_service");
		assertNotNull(bs.getCustomerAccountDao());
		assertNotNull(bs.getForexRateDao());
		assertNotNull(bs.getUserInfo());
		assertNotNull(bs.getUtilityAccountDao());
	}
}
