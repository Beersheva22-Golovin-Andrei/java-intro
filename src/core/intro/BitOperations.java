package core.intro;

public class BitOperations {
	
	private static final int N_BITS = 64;
	
	public static int getBitValue (long number, int nBit) {
		int res = -1;
		if(checkNbit(nBit)) {
			long mask = 1 << nBit;
			if ((number & mask) == 0) {
				res = 0;
			} else {
				res = 1;
			}
		}	
		return res;
	}
	
	public static long setBitValue (long number, int nBit, long newValue) {
		
		if (checkNbit(nBit)) {
			if(getBitValue(number,nBit)!=newValue) {
				return replaceBitValue(number, nBit);
			}	
		} else {
			return -1;
		}
		return number;
	}

	public static long replaceBitValue (long number, int nBit) {
		if (checkNbit(nBit)) {
			return number^(1 << nBit);
		}
	return -1;
	}
	
	public static boolean checkNbit (int nBit) {
		return nBit<64 && nBit>-1;
	}
	
	static public int leadingZeros(long number) {
		int res = 0;
		int nBit = N_BITS-1; 
		while(nBit >= 0 && getBitValue(number, nBit) == 0) {
			nBit--;
			res++;
		}
		return res;
	}
	static public int onesInNumber(long number) {
		int res = 0;
		for (int i = 0; i < N_BITS; i++) {
			if (getBitValue(number, i) == 1) {
				res++;
			}
		}
		return res;
	}

}
