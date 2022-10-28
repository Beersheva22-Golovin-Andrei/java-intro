import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class IntroTest {

	final int number = 1256987;
	
	final long numberForBit = 0x3ab7f5;
	
	@Test
	void testForDigitsInNumber() {
		
	assertEquals(1, DigitsService.getAllDigits(number).get(6));
	assertEquals(9, DigitsService.getAllDigits(number).get(2));
		
		}
	
	@Test
	void getBitValueTest () {
	
		assertEquals(1, BitOperations.getBitValue(numberForBit, 5));
		assertEquals(0, BitOperations.getBitValue(numberForBit, 11));
		assertEquals(0, BitOperations.getBitValue(numberForBit, 1));
		assertEquals(1, BitOperations.getBitValue(numberForBit, 2));		
	}
	
	@Test
	void setBitValueTest () {
		
		assertEquals(0x3ab7f5, BitOperations.setBitValue(numberForBit, 5, 1));
		assertEquals(0x3ab7d5, BitOperations.setBitValue(numberForBit, 5, 0));
	}
	
	@Test
	void replaceBitValueTest () {
		
		assertEquals(0x3ab7d5, BitOperations.replaceBitValue(numberForBit, 5));
		assertEquals(0x3ab7f4, BitOperations.replaceBitValue(numberForBit, 0));
	}
}
