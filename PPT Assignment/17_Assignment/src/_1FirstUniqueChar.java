import java.util.HashMap;

public class _1FirstUniqueChar {
	public static int firstUniqChar(String s) {
		HashMap<Character, Integer> frequencyMap = new HashMap<>();

		// Count the frequency of each character
		for (char c : s.toCharArray()) {
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}

		// Find the first non-repeating character
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (frequencyMap.get(c) == 1) {
				return i;
			}
		}

		return -1; // No non-repeating character found
	}

	public static void main(String[] args) {
		String s = "leetcode";
		int index = firstUniqChar(s);
		System.out.println("First non-repeating character index: " + index);
	}
}
