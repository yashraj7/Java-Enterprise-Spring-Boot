
public class _8CountConstants {
	public static int countConsonants(String str) {
		return countConsonantsRecursive(str.toLowerCase(), 0);
	}

	private static int countConsonantsRecursive(String str, int index) {
		if (index == str.length()) {
			// Base case: Reached the end of the string
			return 0;
		}

		char currentChar = str.charAt(index);
		if (isConsonant(currentChar)) {
			// If the current character is a consonant, increment the count by 1
			return 1 + countConsonantsRecursive(str, index + 1);
		} else {
			// If the current character is not a consonant, move to the next character
			return countConsonantsRecursive(str, index + 1);
		}
	}

	private static boolean isConsonant(char ch) {
		// Check if the character is a consonant (not a vowel)
		return ch >= 'a' && ch <= 'z' && ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u';
	}

	public static void main(String[] args) {
		String str = "Hello, World!";
		int consonantCount = countConsonants(str);
		System.out.println("Total number of consonants: " + consonantCount);
	}
}
