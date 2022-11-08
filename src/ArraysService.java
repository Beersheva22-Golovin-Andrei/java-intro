import java.util.Arrays;

public class ArraysService {
	
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added at end a given number
	 */
	public static int[] addsNumber(int[] array, int number) {
		int[]resArray = Arrays.copyOf(array, array.length+1);
		resArray[resArray.length-1] = number;
		return resArray;
	}
	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array
	 * if index doesn't exist in a given array it returns the same array
	 */
	public static int[] removeNumber(int array[], int index) {
		int[] resArray = new int [array.length-1];
		if (index >= 0 && index < array.length) {
			System.arraycopy(array, 0, resArray, 0, index);
			System.arraycopy(array, index+1, resArray, index, array.length-1-index);
		} else resArray = array;
		return resArray;
	}
	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int arraySorted[], int number) {
		int[] resArray = new int [arraySorted.length+1];
		int relativePosition = Arrays.binarySearch(arraySorted, number);
		
		if (relativePosition<0) {
			relativePosition = Math.abs(relativePosition);
		} else relativePosition++;
		
		System.arraycopy(arraySorted, 0, resArray, 0, relativePosition-1);
		resArray[relativePosition-1] = number;
		System.arraycopy(arraySorted, relativePosition-1, resArray, relativePosition, resArray.length-relativePosition);
				
		return resArray;
	}

}
