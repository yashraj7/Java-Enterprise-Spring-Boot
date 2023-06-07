
public class _4ReverseWords {
	public static String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			StringBuilder reversedWord = new StringBuilder(word).reverse();
			result.append(reversedWord);

			if (i < words.length - 1) {
				result.append(" ");
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";

		String reversed = reverseWords(s);

		System.out.println("Output: " + reversed);
	}
}
