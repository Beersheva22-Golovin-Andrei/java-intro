
public class Numbers {

	static public int getNdigits(long number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while(number != 0);
		return res;
	}

	/**
	 * 
	 * @param number
	 * @return true only if number comprises of 6 digits
	 * and sum of first three digits equals the sum of last three digits
	 */
	static public boolean isHappyNumber(int number) {
	boolean result = false;
	if (getNdigits(number)==6) { 
		result = sumOfDigits(number%1000)== sumOfDigits(number/1000);
	}
		return result;
	}
	
	public static int sumOfDigits (int partOfNumber) {
		int sum = 0;
		while (partOfNumber != 0) {
			sum+=partOfNumber%10;
			partOfNumber/=10;
		}
		return sum;		
	}
	
	public static int getSumDigits(int number) {
		int res = 0;
		do {
			res += number % 10;
			number /= 10;
		} while (number != 0);
		return res;
	}
	
	public static int[] getDigits(int number) {
		int res[] = new int[getNdigits(number)];
		for(int i = res.length - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}
	public static int getNumberFromDigits(int[] digits) {
		int res = 0;
		for(int i = 0; i < digits.length; i++) {
			res = res * 10 + digits[i];
		}
		return res;
	}
	}

