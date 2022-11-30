package core.intro;

public class IsraelIdentity {

	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false
	 * number 
	 * control sum should be multiple of 10  ( sum % 10 == 0)
	 * for even indexes (0, 2, 4, 6, 8) digits as is
	 * for odd indexes (1, 3, 5, 9) digit = digit * 2, if > 9 the sum of inner digits is taken
	 * example, 123456782 => 1 + 4(2 * 2) + 3 + 8(4 * 2) +5 + 3 (6 * 2 = 12 => 1 + 2) + 7 + 7 (8 * 2=16=>1 + 6) + 2
	 */
		public static boolean verify(int id) {
		return getSumForVerification (id)%10 == 0;
	}
		
		public static int getSumForVerification (int id) {
			int sum = 0;
			boolean paritySign = true;
			for (int digit : Numbers.getDigits(id)) {
				
				if (paritySign) {
					sum+=digit; 
				} else {
					digit = 2*digit;
					if (digit >9) {
						sum+= Numbers.getSumDigits(digit);
					} else sum+=digit;
				}
				paritySign=!paritySign;				
			}
			return sum;
		}
		
	
	/**
	 * 	
	 * @return random number of 9 digits matching right Israel id
	 * cycle not more than 9 iterations
	 */
		public static int generateRandomId() {
			int resNumber = 0;
			int counter = 0;
			do {
				counter = 0;
				resNumber = SportLotoAppl.getRandomInt(10000000,99999999);
				resNumber = resNumber*10 + (10 - getSumForVerification (resNumber)%10);
				counter++;
			} while (!verify(resNumber) && counter<=9);

			return resNumber;
		}
		
		
}
