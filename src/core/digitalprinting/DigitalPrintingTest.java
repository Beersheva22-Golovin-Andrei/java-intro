package core.digitalprinting;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import static core.digitalprinting.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {
	@Test
	@Disabled
	public void lineTest() {
		System.out.println(line(30, 30));
	}
	@Test
	@Disabled
	public void verticalLineTest() {
		displayStrings(verticalLine(30, 5));
	}
	@Test
	@Disabled
	public void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 10, 5));
	}
	@Test
	public void zeroTest() {
		displayStrings(zero(10, 6, 9));
	}
	@Test
	public void oneTest() {
		displayStrings(one(30, 5, 4));
	}
	
	
	@Test
	public void DigitalNumbersPrintingTest() {
		displayDigitalNumber(276483549, 3, 6, 9);
	}
	

	public static  void displayStrings(String[] strings) {
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}	
	}
}
