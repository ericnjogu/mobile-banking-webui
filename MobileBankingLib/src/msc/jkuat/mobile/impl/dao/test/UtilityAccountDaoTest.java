/**
 * 
 */
package msc.jkuat.mobile.impl.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import msc.jkuat.mobile.IF.AccountIF;
import msc.jkuat.mobile.impl.dao.UtilityAccountDao;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class UtilityAccountDaoTest {

	private static UtilityAccountDao uad;
	private static List<AccountIF> utilAccounts = new ArrayList<AccountIF>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uad = new UtilityAccountDao();
		uad.setUtilityAccountStore(utilAccounts );
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.dao.UtilityAccountDao#getAllAccounts()}.
	 */
	@Test
	public void testGetAllAccounts() {
		assertEquals(utilAccounts, uad.getAllAccounts());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.dao.UtilityAccountDao#setUtilityAccountStore(java.util.List)}.
	 */
	@Test
	public void testSetNullUtilityAccounts() {
		uad.setUtilityAccountStore(null);
	}
}
