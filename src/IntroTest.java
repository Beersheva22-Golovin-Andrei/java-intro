import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class IntroTest {

	final int number = 1256987;
	
	final long numberForBit = 0x3ab7f5;
	
	@Test
	@Disabled
	void testForDigitsInNumber() {
		
	assertEquals(1, DigitsService.getAllDigits(number).get(6));
	assertEquals(9, DigitsService.getAllDigits(number).get(2));
		
		}
	
	@Test
	@Disabled
	void getBitValueTest () {
	
		assertEquals(1, BitOperations.getBitValue(numberForBit, 5));
		assertEquals(0, BitOperations.getBitValue(numberForBit, 11));
		assertEquals(0, BitOperations.getBitValue(numberForBit, 1));
		assertEquals(1, BitOperations.getBitValue(numberForBit, 2));		
	}
	
	@Test
	@Disabled
	void setBitValueTest () {
		
		assertEquals(0x3ab7f5, BitOperations.setBitValue(numberForBit, 5, 1));
		assertEquals(0x3ab7d5, BitOperations.setBitValue(numberForBit, 5, 0));
	}
	
	@Test
	@Disabled
	void replaceBitValueTest () {
		
		assertEquals(0x3ab7d5, BitOperations.replaceBitValue(numberForBit, 5));
		assertEquals(0x3ab7f4, BitOperations.replaceBitValue(numberForBit, 0));
	}
	
	@Test
	@Disabled
	void digitsNumberTest() {
		 assertEquals(5, Numbers.getNdigits(15896));
	}
	@Test
	@Disabled
	void leadingZerosTest() {
		assertEquals(31, BitOperations.leadingZeros(1));
		assertEquals(18, BitOperations.leadingZeros(9848));
	}
	 @Test
	 @Disabled
	 void isHappyNumberTest() {
		 assertEquals(true, Numbers.isHappyNumber(857965));
		 assertEquals(false, Numbers.isHappyNumber(8579650));
		 assertEquals(false, Numbers.isHappyNumber(111011));
	 } 
	 
	 @Test
	 void addsNumberTest () {
		 int [] array = {7, 7, 12, 0, 5};
		 assertArrayEquals (new int []{7, 7, 12, 0, 5, 8}, ArraysService.addsNumber(array, 8));
	 }
	 	 
	 @Test
	 void removeNumberTest () {
		 int [] array = {8, 15, 7, 4, 8, 9, 11};
		 assertArrayEquals (new int []{15, 7, 4, 8, 9, 11}, ArraysService.removeNumber(array, 0));
		 assertArrayEquals (new int []{8, 15, 7, 8, 9, 11}, ArraysService.removeNumber(array, 3));
		 assertArrayEquals (array, ArraysService.removeNumber(array, 7));
	 }
	 
	  
	 @Test
	 void insertSortedTest () {
		 int [] sortedArray = {-9, 3, 3, 4, 8, 9, 11};
		 
		 assertArrayEquals (new int []{-9, -9, 3, 3, 4, 8, 9, 11}, ArraysService.insertSorted(sortedArray, -9));
		 assertArrayEquals (new int []{-9, -9, 3, 3, 4, 8, 9, 11}, ArraysService.insertSorted(sortedArray, -9));
		 assertArrayEquals (new int []{-9, 3, 3, 4, 4, 8, 9, 11}, ArraysService.insertSorted(sortedArray, 4));
		 assertArrayEquals (new int []{-9, 3, 3, 4, 5, 8, 9, 11}, ArraysService.insertSorted(sortedArray, 5));
		 assertArrayEquals (new int []{-9, 3, 3, 4, 8, 9, 11, 12}, ArraysService.insertSorted(sortedArray, 12));
	 }
	 
	 @Test
	 void verifyTeudatTest () {
		 assertTrue (IsraelIdentity.verify(346849847));
		 assertFalse (IsraelIdentity.verify(346849747));
	 }
	 
	 
}
