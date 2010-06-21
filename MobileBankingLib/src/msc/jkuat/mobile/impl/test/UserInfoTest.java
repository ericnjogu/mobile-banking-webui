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
