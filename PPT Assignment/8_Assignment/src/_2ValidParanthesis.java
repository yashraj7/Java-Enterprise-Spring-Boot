
public class _2ValidParanthesis {
	public static boolean isValid(String s) {
		int minOpen = 0; // minimum number of open parentheses
		int maxOpen = 0; // maximum number of open parentheses

		for (char c : s.toCharArray()) {
			if (c == '(') {
				minOpen++;
				maxOpen++;
			} else if (c == ')') {
				minOpen = Math.max(minOpen - 1, 0);
				maxOpen--;
			} else if (c == '*') {
				minOpen = Math.max(minOpen - 1, 0);
				maxOpen++;
			}

			// If the maximum number of open parentheses becomes negative, it means there
			// are unmatched closing parentheses
			if (maxOpen < 0) {
				return false;
			}
		}

		// The string is valid if there are no unmatched opening parentheses left
		return minOpen == 0;
	}

	public static void main(String[] args) {
		String s = "()";
		System.out.println(isValid(s)); // Output: true

		s = "(*)";
		System.out.println(isValid(s)); // Output: true

		s = "(*))";
		System.out.println(isValid(s)); // Output: true

		s = "(((**";
		System.out.println(isValid(s)); // Output: true

		s = "((()";
		System.out.println(isValid(s)); // Output: false
	}
}
