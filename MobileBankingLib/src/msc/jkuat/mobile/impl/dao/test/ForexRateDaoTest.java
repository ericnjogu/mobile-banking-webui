/**
 * 
 */
package msc.jkuat.mobile.impl.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import msc.jkuat.mobile.IF.ForexRateIF;
import msc.jkuat.mobile.impl.dao.ForexRateDao;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class ForexRateDaoTest {

	private static ForexRateDao frd;
	private static List<ForexRateIF> forexList = new ArrayList<ForexRateIF>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		frd = new ForexRateDao();
		frd.setForexStore(forexList );
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.dao.ForexRateDao#getForexRates()}.
	 */
	@Test
	public void testGetForexRates() {
		assertEquals(forexList, frd.getForexStore());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.dao.ForexRateDao#setForexStore(java.util.List)}.
	 */
	@Test
	public void testSetNullForexStore() {
		frd.setForexStore(null);
	}

}
