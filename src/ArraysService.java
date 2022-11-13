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
	
	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists otherwise -1
	 * O[N] - search number in unsorted array
	 * O[LogN] - search number in sorted (binary search)
	 */
	public static int binarySearch(int arraySorted[], int number) {
		int res;
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while(left <= right && arraySorted[middle] != number) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right)/2;
		}
		
		if (left <= right) {
			res = middle;
			if (middle!=0 && arraySorted[middle-1]==number) {
				for (int i =left; i<right; i++) {
					if (arraySorted[i]==number) {
						res = i;
						break;
					}
				}
			}		
		} else {	
			res=-(left+1);
		}		
		return res; 
	}
	
	public static boolean isOneSwapForSorted (int[] arr) {
		boolean res = false;
		int[] comparArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(comparArr);
		int counter=0;
		for (int i=0; i<arr.length; i++) {
			if (comparArr[i] != arr[i]) counter ++;
		}
		if (counter==2)res = true;
		return res;
		
	}
	
	public static int[] bubbleSort(int[]arr){
	    for (int i = arr.length-1; i >= 1; i--){
	        for (int j = 0; j < i; j++){
	            if(arr[j] > arr[j + 1]) {
	            	int temp = arr[j];
	            	arr[j]=	arr[j+1];
	            	arr[j+1]=temp;
	            }
	        }
	    }
	    return arr;
	}
}
