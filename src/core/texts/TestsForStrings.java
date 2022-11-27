package core.texts;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import static core.texts.Strings.*;

public class TestsForStrings {

	@Test
	@Disabled
	public void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
	}

	@Test
	@Disabled
	public void ipV4OctetTest() {
		assertTrue("100".matches(Strings.ipV4Octet()));
		assertTrue("10".matches(Strings.ipV4Octet()));
		assertTrue("080".matches(Strings.ipV4Octet()));
		assertTrue("167".matches(Strings.ipV4Octet()));

		assertFalse("256".matches(Strings.ipV4Octet()));
		assertFalse("1111".matches(Strings.ipV4Octet()));
		assertFalse("".matches(Strings.ipV4Octet()));
		assertFalse("5 9".matches(Strings.ipV4Octet()));

	}

	@Test
	@Disabled
	public void ipV4Test() {

		assertTrue("100.200.55.123".matches(Strings.ipV4()));
		assertTrue("5.0.222.64".matches(Strings.ipV4()));
		assertTrue("005.009.100.010".matches(Strings.ipV4()));

		assertFalse("100 200.55.123".matches(Strings.ipV4()));
		assertFalse("100.282.55.123".matches(Strings.ipV4()));
		assertFalse("100.200.55.12v".matches(Strings.ipV4()));
		assertFalse(" 1.200.55.123".matches(Strings.ipV4()));
		assertFalse("100.200.55".matches(Strings.ipV4()));

	}

	
	 @Test 
	 public void computeExpressionTest() {
		 assertEquals(10.5, computeArithmenticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		 assertTrue(Double.isNaN(computeArithmenticExpression("2 # 2 ++ 10", null, null))); 
		 assertEquals(10.5, computeArithmenticExpression("a + 2 + c * 2 + 0.5", new double[] {2, 1}, new String[] {"a", "c"}));
		 assertTrue(Double.isNaN(computeArithmenticExpression("a + 2 + c * 2 + d23",  new double[] {2, 1}, new String[] {"a", "c"})));
		 assertTrue(Double.isNaN(computeArithmenticExpression("(2 - 2 +) 10)", null, null))); 
		 assertTrue(Double.isNaN(computeArithmenticExpression("(2 - 2) + 10)", null, null)));
		 assertEquals(10,computeArithmenticExpression("((2 - 2) + 10)", null, null));
	 }
}
