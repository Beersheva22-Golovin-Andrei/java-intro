package core.intro;

public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * no additional collections / arrays
	 */
	public static void main(String[] args) {
	long resNumber = 0;
	int newNumber = 0;
	int counter = 0;
  		while (counter < 6) {
			newNumber = getRandomInt(1, 49);
			if (!isPresentDigit (resNumber, newNumber)) {
				resNumber =  resNumber*100 + newNumber;	
				System.out.print(newNumber + " ");
				counter++;
			}	
		}
	}
	
	public static int getRandomInt(int min, int max) {
		return (int)(min + Math.random() * (max - min + 1));
	}
	
	public static boolean isPresentDigit (long intermidNumber, int digitForCheck) {
		boolean result = false;
		while (intermidNumber != 0) {
			if (intermidNumber%100==digitForCheck) result = true;
			intermidNumber /=100;
		}
		return  result;
	}
	
	
	
	public static void lotoViaBitOperations () {
		int newNumber = 0;
		int counter = 0;
		long container = 0L;
  		while (counter < 6) {
			newNumber = getRandomInt(1, 49);
			
			if (BitOperations.getBitValue(container, newNumber)==0) {
				container = BitOperations.setBitValue(container, newNumber, 1);
				counter++;
				System.out.print(newNumber + " ");
			}
  		}
	}
	
}