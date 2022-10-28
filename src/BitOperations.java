
public class BitOperations {
	
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

}
