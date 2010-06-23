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

package msc.jkuat.mobile.impl.test;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * in the absence of javadoc, find out the values returned
 * by BigDecimal's compare
 */
public class BigDecimalTests {
	private static BigDecimal myDecimal;

	@BeforeClass
	public static void setUp() {
		myDecimal = new BigDecimal(2);
	}
	@Test
	public void lessThan() {
		assertEquals(-1, myDecimal.compareTo(new BigDecimal(3)));
	}
	@Test
	public void equalTo() {
		assertEquals(0, myDecimal.compareTo(myDecimal));
	}
	@Test
	public void moreThan() {
		assertEquals(1, myDecimal.compareTo(BigDecimal.ONE));
	}
}
