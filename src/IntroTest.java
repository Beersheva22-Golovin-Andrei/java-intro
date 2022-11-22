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
	 @Disabled
	 void addsNumberTest () {
		 int [] array = {7, 7, 12, 0, 5};
		 assertArrayEquals (new int []{7, 7, 12, 0, 5, 8}, ArraysService.addsNumber(array, 8));
	 }
	 	 
	 @Test
	 @Disabled
	 void removeNumberTest () {
		 int [] array = {8, 15, 7, 4, 8, 9, 11};
		 assertArrayEquals (new int []{15, 7, 4, 8, 9, 11}, ArraysService.removeNumber(array, 0));
		 assertArrayEquals (new int []{8, 15, 7, 8, 9, 11}, ArraysService.removeNumber(array, 3));
		 assertArrayEquals (array, ArraysService.removeNumber(array, 7));
	 }
	 
	  
	 @Test
	 @Disabled
	 void insertSortedTest () {
		 int [] sortedArray = {-9, 3, 3, 4, 8, 9, 11};
		 
		 assertArrayEquals (new int []{-9, -9, 3, 3, 4, 8, 9, 11}, ArraysService.insertSorted(sortedArray, -9));
		 assertArrayEquals (new int []{-9, -9, 3, 3, 4, 8, 9, 11}, ArraysService.insertSorted(sortedArray, -9));
		 assertArrayEquals (new int []{-9, 3, 3, 4, 4, 8, 9, 11}, ArraysService.insertSorted(sortedArray, 4));
		 assertArrayEquals (new int []{-9, 3, 3, 4, 5, 8, 9, 11}, ArraysService.insertSorted(sortedArray, 5));
		 assertArrayEquals (new int []{-9, 3, 3, 4, 8, 9, 11, 12}, ArraysService.insertSorted(sortedArray, 12));
		 assertArrayEquals (new int []{1, 1}, ArraysService.insertSorted(new int []{1}, 1));
	 }
	 
	 @Test
	 @Disabled
	 void verifyTeudatTest () {
		 assertTrue (IsraelIdentity.verify(346849847));
		 assertFalse (IsraelIdentity.verify(346849747));

	 }
	 
	 @Test
	 @Disabled
	 void isOneSwapTestFalse() {
		 int ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		 int ar2[] = { 1, 2, 3, 4, 5, 10 };
		 int ar3[] = { 5, 1, 2, 4, 6, 10 };
		 int ar4[] = { 1, 5, 2, 4, 3, 10 };
		 int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		 int ar6[] = {1, 3, 20, 4, 5, 6, 10};
		 int ar7[] = {1, 3, 20, 4, 5, 11, 2};
	 assertFalse(ArraysService.isOneSwapForSorted(ar1));
	 assertFalse(ArraysService.isOneSwapForSorted(ar2));
	 assertFalse(ArraysService.isOneSwapForSorted(ar3));
	 assertFalse(ArraysService.isOneSwapForSorted(ar4));
	 assertFalse(ArraysService.isOneSwapForSorted(ar5));
	 assertFalse(ArraysService.isOneSwapForSorted(ar6));
	 assertFalse(ArraysService.isOneSwapForSorted(ar7));

	 }
	 @Test
	 @Disabled
	 void isOneSwapTestTrue() {

	 int ar1[] = { 10, 2, 3, 4, 1 };
	 int ar2[] = { 1, 2, 4, 3, 5, 10 };
	 int ar3[] = { 1, 2, 3, 10, 5, 4 };
	 int ar4[] = { 1, 5, 3, 4, 2, 10 };
	 int ar5[] = { 1, 2, 3, 4, 10, 5 };
	 int ar6[] = { 2, 1, -3, 4, 5, 10 };
	 int ar7[] = { 3, 2, 1, 4, 5, 6 };
	 assertTrue(ArraysService.isOneSwapForSorted(ar1));
	 assertTrue(ArraysService.isOneSwapForSorted(ar2));
	 assertTrue(ArraysService.isOneSwapForSorted(ar3));
	 assertTrue(ArraysService.isOneSwapForSorted(ar4));
	 assertTrue(ArraysService.isOneSwapForSorted(ar5));
	 assertTrue(ArraysService.isOneSwapForSorted(ar6));
	 assertTrue(ArraysService.isOneSwapForSorted(ar7));

	 }
	 
	 @Test
	 @Disabled
	 public void isSum2Test() {
		assertTrue(ArraysService.isSum2 (new short[] {8,3,1,14,0,5,4,1,9}, (short) 2));
	 	assertTrue(ArraysService.isSum2 (new short[] {3,5,8,5,7,7,4,12,6}, (short) 15));
		assertTrue(ArraysService.isSum2 (new short[] { 1, 2, 8, 7, 3, 5, 2}, (short) 3));

		assertTrue(ArraysService.isSum2 (new short[] { 4, 10, 8, 7, 7, 7, 1, 5, 3}, (short) 7));
		assertTrue(ArraysService.isSum2 (new short[] { 1, 3, 8, 7, 2, 5, 2}, (short) 5));
		assertTrue(ArraysService.isSum2 (new short[] { 1, 3, 5, 7, 5, 1, 2}, (short) 3));
		
		assertTrue(ArraysService.isSum2 (new short[] { 1, 2, 5, 7, 5, 1, 2}, (short) 10));
		
		
		assertFalse(ArraysService.isSum2(new short[]{ 4, 10, 8, 3, 1, 5, 3}, (short)10));
		assertFalse(ArraysService.isSum2(new short[]{ 10, 10, 8, 3, 1, 5, 3}, (short)19));
		assertFalse(ArraysService.isSum2(new short[]{ 4, 10, 8, 3, 1, 5, 3}, (short)2));
		
		
		
		assertTrue(ArraysService.isSum2norm (new short[] {8,3,1,14,0,5,4,1,9}, (short) 2));
	 	assertTrue(ArraysService.isSum2norm (new short[] {3,5,8,5,7,7,4,12,6}, (short) 15));
		assertTrue(ArraysService.isSum2norm (new short[] { 1, 2, 8, 7, 3, 5, 2}, (short) 3));

		assertTrue(ArraysService.isSum2norm (new short[] { 4, 10, 8, 7, 7, 7, 1, 5, 3}, (short) 7));
		assertTrue(ArraysService.isSum2norm (new short[] { 1, 3, 8, 7, 2, 5, 2}, (short) 5));
		assertTrue(ArraysService.isSum2norm (new short[] { 1, 3, 5, 7, 5, 1, 2}, (short) 3));
		
		assertTrue(ArraysService.isSum2norm (new short[] { 1, 2, 5, 7, 5, 1, 2}, (short) 10));
		
		
		assertFalse(ArraysService.isSum2norm(new short[]{ 4, 10, 8, 3, 1, 5, 3}, (short)10));
		assertFalse(ArraysService.isSum2norm(new short[]{ 10, 10, 8, 3, 1, 5, 3}, (short)19));
		assertFalse(ArraysService.isSum2norm(new short[]{ 4, 10, 8, 3, 1, 5, 3}, (short)2));
	 }
	 
	 @Test
	 @Disabled
	 void anagramaTest() {
		 
		 assertTrue(Strings.isAnagram("asdtyrohfr", "asdtyrohfr"));
		 assertTrue(Strings.isAnagram("asdtyrohfr", "asdtyrohfr"));
		 assertTrue(Strings.isAnagram("sDDjkl mno", "lsDk jmnDo"));
		 assertTrue(Strings.isAnagram("+-! /", "/+ -!"));
		 
		 assertFalse(Strings.isAnagram("asdtyrohfr", "asdtyrohf"));
		 assertFalse(Strings.isAnagram("asdtyrohfr", "asdtyyohfr"));
		 
		
				 String word = "loweyl";
				 assertTrue(Strings.isAnagram(word, "elolyw"));
				 assertTrue(Strings.isAnagram(word, "wolley"));
				 assertTrue(Strings.isAnagram(word, "loleyw"));
				 assertFalse(Strings.isAnagram(word,""));
				 assertFalse(Strings.isAnagram(word, "yellob"));
				 assertFalse(Strings.isAnagram(word,"yello"));
				 assertFalse(Strings.isAnagram(word,"yelllo"));
	 }
	 
	 
	 @Test
	 void sortStringNumbersTest(){
		
		 String [] arrIn = 	{"55","0", "5", "-5", "-117", "-9","-9", "47", "60","1","1","0"};
		 String [] sortArr = {"-117", "-9", "-9", "-5", "0", "0", "1", "1", "5", "47", "55", "60" };
		 Strings.sortStringNumbers(arrIn);
		 
		 for (int i =0; i<arrIn.length; i++) {
			 assertEquals(arrIn[i], sortArr[i]);
		 }
	 }
	 
	 
	 
	 
}
