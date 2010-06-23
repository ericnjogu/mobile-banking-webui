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
