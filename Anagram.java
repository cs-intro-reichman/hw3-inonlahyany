/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("silent","ksfkff"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String processedStr1 = preProcess(str1);
		String processedStr2 = preProcess(str2); 
		
		for (int s = 0; s < processedStr1.length(); s++) {
			if (processedStr1.charAt(s) == 32) {
				processedStr1 = processedStr1.substring(0, s) + processedStr1.substring(s + 1);
		
			}
		}


		for (int s = 0; s < processedStr2.length(); s++) {
			if (processedStr2.charAt(s) == 32) {
				processedStr2 = processedStr2.substring(0, s) + processedStr2.substring(s + 1);
			}
		}
	
		if (processedStr1.length() != processedStr2.length()) {
			return false; 
		} 

		for (int i = 0; i < processedStr1.length(); i++) {
			char currentStr1 = processedStr1.charAt(i);
			int matchesFound = 0;

			for (int j = 0; j < processedStr2.length(); j++) {
				if (currentStr1 == processedStr2.charAt(j)) {
					matchesFound ++;
				}
			}

			if (matchesFound == 0) {
				return false;
			}
		}

		return true; 
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String processedString = "";
		for (int i = 0; i < str.length(); i++) {
			char currentCh = str.charAt(i);
			
			if (currentCh == 32) {
				processedString += currentCh;
				continue;
			}

			if (currentCh <= 122 && currentCh >= 97) {
				processedString += currentCh;
			} else if (currentCh <= 90 && currentCh >= 65) {
				currentCh += 32; 
				processedString += currentCh;
			} 
		}
		return processedString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomStringGenerated = "";
		while (str.length() > 0) { 
			int randomIndex = (int) (Math.random() * str.length());
			randomStringGenerated += str.charAt(randomIndex);
			str = str.substring(0, randomIndex) + str.substring(randomIndex + 1);
		}
		return randomStringGenerated;
	}
}
