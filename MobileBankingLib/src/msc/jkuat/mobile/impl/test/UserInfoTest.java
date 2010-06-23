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

import msc.jkuat.mobile.impl.UserInfo;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author protosoft
 *
 */
public class UserInfoTest {

	private static UserInfo userInfo;
	private static String firstName = "Eric";
	private static String lastName = "Njogu";
	private static String pin = "3003";
	private static String title = "Mr.";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userInfo = new UserInfo();
		userInfo.setFirstName(firstName );
		userInfo.setLastName(lastName );
		userInfo.setPIN(pin );
		userInfo.setTitle(title );
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.UserInfo#changePIN(java.lang.String)}.
	 */
	@Test
	public void testChangePIN() {
		userInfo.changePIN("3002");
		assertEquals("3002", userInfo.getPIN());
		//restore for the sake of other methods
		userInfo.setPIN(pin);
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.UserInfo#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		assertEquals(firstName, userInfo.getFirstName());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.UserInfo#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		assertEquals(lastName, userInfo.getLastName());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.UserInfo#getPIN()}.
	 */
	@Test
	public void testGetPIN() {
		assertEquals(pin, userInfo.getPIN());
	}

	/**
	 * Test method for {@link msc.jkuat.mobile.impl.UserInfo#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		fail("Not yet implemented");
	}

}
