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

import java.math.BigDecimal;

import msc.jkuat.mobile.impl.ForexRate;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class ForexRateTest {

	private static ForexRate forexRate;
	private static String cname = "US Dollar";
	private static BigDecimal rate = new BigDecimal(80);
	private static String symbol = "USD";
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		forexRate = new ForexRate();
		forexRate.setCurrencyName(cname);
		forexRate.setRate(rate );
		forexRate.setSymbol(symbol );
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.ForexRate#getRate()}.
	 */
	@Test
	public void testGetRate() {
		assertEquals(rate, forexRate.getRate());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.ForexRate#getSymbol()}.
	 */
	@Test
	public void testGetSymbol() {
		assertEquals(symbol, forexRate.getSymbol());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.ForexRate#getCurrencyName()}.
	 */
	@Test
	public void testGetCurrencyName() {
		assertEquals(cname, forexRate.getCurrencyName());
	}

}
