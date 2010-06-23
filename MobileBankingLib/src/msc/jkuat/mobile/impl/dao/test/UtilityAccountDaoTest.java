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
