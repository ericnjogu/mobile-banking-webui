/**
 * 
 */
package msc.jkuat.mobile.impl.test;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import msc.jkuat.mobile.impl.AppConstants;

import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class AppConstantsTest {
	@Test
	public void getDebit () {
		assertEquals("DR", AppConstants.DEBIT);
	}
	@Test
	public void getCredit() {
		assertEquals("CR", AppConstants.CREDIT);
	}
	@Test
	public void getAirTimeComm() {
		assertEquals(0, AppConstants.AIRTIME_COMM.compareTo(new BigDecimal(10)));
	}
	
	@Test
	public void getTransferComm() {
		assertEquals(0, AppConstants.TRANSFER_COMM.compareTo(new BigDecimal(50)));
	}
	
	@Test
	public void getUtilityComm() {
		assertEquals(0, AppConstants.UTILITY_COMM.compareTo(new BigDecimal(10)));
	}
}
