package core.digitalprinting;

import core.intro.Numbers;

public class DigitalNumbersPrinting {

	private static final String SYMBOL = "*";

	public static void displayDigitalNumber(int number, int offset, int width, int height) {

		int[] arrOfDigits = Numbers.getDigits(number);
		StringBuilder[] res = new StringBuilder[height];
		String[] firstDigitArr = choseSetForDigit(arrOfDigits[0], offset, width, height);
		for (int i = 0; i < res.length; i++) {
			res[i] = new StringBuilder(firstDigitArr[i]);
		}

		for (int j = 1; j < arrOfDigits.length; j++) {
			String[] digitArr = choseSetForDigit(arrOfDigits[j], offset, width, height);
			for (int i = 0; i < res.length; i++) {

				if (res[i].length() != (offset + width) * j) {
					res[i] = res[i].append(" ".repeat(width - 1));
				}
				res[i] = res[i].append(digitArr[i]);
			}
		}
		displayStrings(res);
	}

	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	public static String[] verticalLine(int offset, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] one(int offset, int width, int height) {
		return verticalLine(offset + width - 1, height);
	}

	public static String[] two(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] vertical1 = verticalLine(offset + width - 1, height / 2 - 1);
		System.arraycopy(vertical1, 0, res, 1, vertical1.length);
		res[vertical1.length + 1] = line(offset, width);
		String[] vertical2 = verticalLine(offset, height / 2 - 1);
		System.arraycopy(vertical2, 0, res, vertical1.length + 2, vertical2.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] three(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] vertical1 = verticalLine(offset + width - 1, height / 2 - 1);
		System.arraycopy(vertical1, 0, res, 1, vertical1.length);
		res[vertical1.length + 1] = line(offset, width);
		System.arraycopy(vertical1, 0, res, vertical1.length + 2, vertical1.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] four(int offset, int width, int height) {
		String[] res = new String[height];
		String[] verticalLines = twoVerticalLines(offset, width, height / 2);
		System.arraycopy(verticalLines, 0, res, 0, verticalLines.length);
		res[verticalLines.length] = line(offset, width);
		String[] vertical1 = verticalLine(offset + width - 1, height / 2);
		System.arraycopy(vertical1, 0, res, height / 2 + 1, verticalLines.length);
		return res;
	}

	public static String[] five(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] vertical1 = verticalLine(offset + width - 1, height / 2 - 1);
		String[] vertical2 = verticalLine(offset, height / 2 - 1);
		System.arraycopy(vertical2, 0, res, 1, vertical2.length);
		res[vertical1.length + 1] = line(offset, width);
		System.arraycopy(vertical1, 0, res, vertical2.length + 2, vertical1.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] six(int offset, int width, int height) {
		String[] res = new String[height];
		String[] vertical1 = verticalLine(offset, height / 2);
		System.arraycopy(vertical1, 0, res, 0, vertical1.length);
		res[vertical1.length] = line(offset, width);
		String[] verticalLines = twoVerticalLines(offset, width, height / 2);
		System.arraycopy(verticalLines, 0, res, vertical1.length + 1, verticalLines.length);
		res[height - 1] = line(offset, width);

		return res;
	}

	public static String[] seven(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] vertical = verticalLine(offset + width - 1, height - 1);
		System.arraycopy(vertical, 0, res, 1, vertical.length);

		return res;
	}

	public static String[] eight(int offset, int width, int height) {
		String[] res = zero(offset, width, height);
		res[height / 2] = line(offset, width);
		return res;
	}

	public static String[] nine(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] verticalLines = twoVerticalLines(offset, width, height / 2);
		System.arraycopy(verticalLines, 0, res, 1, verticalLines.length);
		res[verticalLines.length] = line(offset, width);

		String[] vertical1 = verticalLine(offset + width - 1, height / 2);
		System.arraycopy(vertical1, 0, res, verticalLines.length + 1, vertical1.length);

		return res;
	}

	public static void displayStrings(StringBuilder[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i].toString());
		}
	}

	public static String[] choseSetForDigit(int digit, int offset, int width, int height) {
		String[] set = null;
		switch (digit) {
		case 0:
			set = zero(offset, width, height);
			break;

		case 1:
			set = one(offset, width, height);
			break;

		case 2:
			set = two(offset, width, height);
			break;

		case 3:
			set = three(offset, width, height);
			break;

		case 4:
			set = four(offset, width, height);
			break;

		case 5:
			set = five(offset, width, height);
			break;

		case 6:
			set = six(offset, width, height);
			break;
		
		 case 7:
			 set = seven(offset, width, height);
		  break;
		  
		  case 8:
			  set = eight(offset, width, height);
		  break;
		  
		  case 9:
			  set = nine(offset, width, height);
		  break;
		}
		return set;
	}

}
