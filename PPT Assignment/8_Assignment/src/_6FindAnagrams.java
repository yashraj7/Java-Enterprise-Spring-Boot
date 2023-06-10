import java.util.ArrayList;
import java.util.List;

public class _6FindAnagrams {

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();

		if (s.length() < p.length()) {
			return result;
		}

		int[] pCount = new int[26]; // to store the character counts of p
		int[] windowCount = new int[26]; // to store the character counts of the sliding window

		// Calculate the character counts of p
		for (char c : p.toCharArray()) {
			pCount[c - 'a']++;
		}

		// Initialize the sliding window
		for (int i = 0; i < p.length(); i++) {
			windowCount[s.charAt(i) - 'a']++;
		}

		// Slide the window and compare the character counts
		for (int i = 0; i <= s.length() - p.length(); i++) {
			if (isAnagram(pCount, windowCount)) {
				result.add(i);
			}

			// Slide the window by removing the leftmost character and adding the next
			// character
			if (i < s.length() - p.length()) {
				windowCount[s.charAt(i) - 'a']--;
				windowCount[s.charAt(i + p.length()) - 'a']++;
			}
		}

		return result;
	}

	// Check if the character counts in the window match the character counts in
	// pCount
	private static boolean isAnagram(int[] pCount, int[] windowCount) {
		for (int i = 0; i < 26; i++) {
			if (pCount[i] != windowCount[i]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> indices = findAnagrams(s, p);
		System.out.println(indices); // Output: [0, 6]
	}
}
