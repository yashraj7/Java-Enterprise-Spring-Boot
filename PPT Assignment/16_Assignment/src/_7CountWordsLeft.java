import java.util.Stack;

public class _7CountWordsLeft {

	public static int countWordsLeft(String[] words) {
		Stack<String> stack = new Stack<>();

		for (String word : words) {
			if (!stack.isEmpty() && stack.peek().equals(word)) {
				stack.pop(); // Destroy the similar word
			} else {
				stack.push(word);
			}
		}

		return stack.size();
	}

	public static void main(String[] args) {
		String[] words = { "ab", "aa", "aa", "bcd", "ab" };

		int wordsLeft = countWordsLeft(words);
		System.out.println("Number of words left after pairwise destruction: " + wordsLeft);
	}
}
