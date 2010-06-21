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
