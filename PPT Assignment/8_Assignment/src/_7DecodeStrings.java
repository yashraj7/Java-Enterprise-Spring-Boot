import java.util.Stack;

public class _7DecodeStrings {

	public static String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<String> stringStack = new Stack<>();
		String currentString = "";
		int currentCount = 0;

		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				// Update the current count
				currentCount = currentCount * 10 + (ch - '0');
			} else if (ch == '[') {
				// Push the current count and current string to their respective stacks
				countStack.push(currentCount);
				stringStack.push(currentString);
				currentCount = 0; // Reset the current count
				currentString = ""; // Reset the current string
			} else if (ch == ']') {
				// Decode the string inside the square brackets
				StringBuilder sb = new StringBuilder(stringStack.pop());
				int repeatCount = countStack.pop();
				sb.append(currentString.repeat(repeatCount));
				currentString = sb.toString();
			} else {
				// Append the character to the current string
				currentString += ch;
			}
		}

		return currentString;
	}

	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		String decodedString = decodeString(s);
		System.out.println(decodedString); // Output: aaabcbc
	}
}
