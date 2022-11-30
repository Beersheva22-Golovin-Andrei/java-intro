package core.intro;
import java.util.ArrayList;
import java.util.List;

public class DigitsService {
	
public static List<Integer> getAllDigits (int number) {
		
		List<Integer> digits = new ArrayList<>();
		
		for (int i = 1; number>0; i++) {
			
			int difer = number % (int)Math.pow(10, i);
			
			digits.add(difer/(int)Math.pow(10, i-1));
		
			number = number - difer;
		}
		return digits;
	}

}
