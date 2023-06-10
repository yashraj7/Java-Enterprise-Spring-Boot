
public class _8CanBeEqual {
	public static boolean canBeEqual(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		if (s.equals(goal)) {
			return true;
		}

		int diffCount = 0;
		int[] charCount = new int[26];

		for (int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i) - 'a']++;
			charCount[goal.charAt(i) - 'a']--;

			if (s.charAt(i) != goal.charAt(i)) {
				diffCount++;
			}
		}

		if (diffCount != 2) {
			return false;
		}

		for (int count : charCount) {
			if (count != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "ab";
		String goal = "ba";
		boolean result = canBeEqual(s, goal);
		System.out.println(result); // Output: true
	}
}
