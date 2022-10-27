import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class IntroTest {

	int number = 1256987;
	
	@Test
	void test() {
		
	assertEquals(1, getAllDigits(number).get(6));
	assertEquals(9, getAllDigits(number).get(2));
		
		}
	
	
	public List<Integer> getAllDigits (int number) {
		
		List<Integer> digits = new ArrayList<>();
		
		for (int i = 1; number>0; i++) {
			
			int difer = number % (int)Math.pow(10, i);
			
			digits.add(difer/(int)Math.pow(10, i-1));
		
			number = number - difer;
	}
		return digits;
}
}
