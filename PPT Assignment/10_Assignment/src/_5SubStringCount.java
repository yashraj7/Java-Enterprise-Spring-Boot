
public class _5SubStringCount {
	public static int countContiguousSubstrings(String s) {
		return countSubstrings(s, 0, s.length() - 1);
	}

	private static int countSubstrings(String s, int start, int end) {
		if (start > end) {
			// Base case: No substring left to check
			return 0;
		}

		int count = countSubstrings(s, start + 1, end); // Count substrings excluding the first character
		count += countSubstringsStartingFrom(s, start, end); // Count substrings starting from the first character

		return count;
	}

	private static int countSubstringsStartingFrom(String s, int start, int end) {
		if (start == end) {
			// Base case: A single character, a substring with the same start and end
			// character
			return 1;
		}

		int count = 0;

		if (s.charAt(start) == s.charAt(end)) {
			// If the start and end characters are the same, increase the count and
			// recursively check the substring
			count++;
			count += countSubstringsStartingFrom(s, start, end - 1);
		}

		return count;
	}

	public static void main(String[] args) {
		String s = "ababa";
		int count = countContiguousSubstrings(s);
		System.out.println("Count of contiguous substrings: " + count);
	}
}
