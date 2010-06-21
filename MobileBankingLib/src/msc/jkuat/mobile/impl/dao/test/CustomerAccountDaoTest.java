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
