
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
}
