package core.texts;

public class Strings {
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1
	 * complexity O[N] two passes
	 * only one additional array
	 * only symbols or English letters
	 * 1. the same length
	 * 2. the same symbols just in different order
	 */
		public static boolean isAnagram(String str1, String str2) {
			
			boolean res = true;
	
			if (!str1.equalsIgnoreCase(str2)) {
				if (str1.length()==str2.length()) {
					
				int [] helper = new int[127];
				for (int i =0; i<str1.length(); i++) {
					helper[(int)str1.charAt(i)]++;				
				}
				int j=0;
				
			while (res && j<str2.length()){			
				if (helper[(int)str2.charAt(j)]<=0) {
					res = false;
				} else {
					helper[str2.charAt(j)]--;
					j++;
				}
							
			}
			} else res = false;
			}
			return res;
		}
		
		
		public static void sortStringNumbers (String []arr) {
			if (arr.length>0) {
				String[]helper = new String [Byte.MAX_VALUE*2];
				
				for (String strFromArr : arr) {
					int indexForhelper = Byte.parseByte(strFromArr)+Math.abs(Byte.MIN_VALUE);
					if (helper[indexForhelper]==null) {
						helper[indexForhelper] = strFromArr;
					} else {
						helper[indexForhelper] = helper[indexForhelper]+"/"+strFromArr;
					}					
				}
				
				int i =0;
				for (String strToRes : helper) {
					if(strToRes!=null) {
						for (String strRes:strToRes.split("/")) {
							arr[i]=strRes;
							i++;
						}
					}
				}
			}	
		}
		
		public static String javaNameExp() {
			
			return "[a-zA-Z$][\\w$]*|_[\\w$]+";
		}
		
		
		public static String ipV4Octet() {
			return "^([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])$";
		}
		
		
		public static String ipV4() {
			return "^(([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.){3}([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])$";
		}
		
		private static String arithmeticExpression() {
			String operatorExp = operator();
			String operandExp = operand();
			
			return String.format("\\(*%1$s\\)*(%2$s\\(*%1$s\\)*)*", operandExp, operatorExp);
		}

		public static String operand() {
			return "(\\d+\\.?\\d*|\\.\\d+|"+javaNameExp()+")";
		}

		public static boolean isArithmeticExpression(String expression) {
			expression = expression.replaceAll("\\s+", "");
			return expression.matches(arithmeticExpression());
		}

		private static String operator() {
			return "([-+*/])";
		}

		/**
		 * 
		 * @param expression
		 * @param values
		 * @param namesSorted - variable names sorted
		 * @return computed value of a given expression or Double.NaN
		 */
		public static Double computeArithmenticExpression(String expression, double values[], String names[]) {
			Double res = Double.NaN;
			if (isArithmeticExpression(expression) && checkBraces(expression)) {
				expression = expression.replaceAll("[\\s()]+", "");
				String operands[] = expression.split(operator());
				String operators[] = expression.split(operand());
				res = getOperandValue(operands[0], values, names);
				int index = 1;
				while (index < operands.length && !res.isNaN()) {
					double operandValue = getOperandValue(operands[index], values, names);
					res = computeOperation(res, operandValue, operators[index]);
					index++;
				}
				
			}

			return res;
		}

		private static Double computeOperation(Double operand1, double operand2, String operator) {
			Double res = Double.NaN;
			if(!Double.isNaN(operand2)) {
				switch(operator) {
				case "+": res = operand1 + operand2; break;
				case "-": res = operand1 - operand2; break;
				case "*": res = operand1 * operand2; break;
				case "/": res = operand1 / operand2; break;
				default: res = Double.NaN;
				}
			}
			return res;
		}

		private static Double getOperandValue(String operand, double[] values, String[] names) {
			Double res=Double.NaN;
			if (operand!=null && !operand.isEmpty()) {
				if (Character.isDigit(operand.charAt(0))) {
					res = Double.parseDouble(operand);
				} else {
					if (values!=null && names != null) {
						int i = 0;
						while (i<names.length && res.isNaN()) {
							if (names[i].equals(operand)) {
								res = values[i];
							}
							i++;
						}
					}
				}				
			}			
			return res;
		}

		public static boolean checkBraces(String expression) {
			int counter = 0;
			for (char c : expression.toCharArray()) {
				if(c=='(') counter ++;
				if(c==')') counter--;
			}
			return counter==0;
		}

}
