import java.util.Arrays;
import java.util.Stack;

public class _5ReverseStringUsingStack {

	public static String reverseString(String str) {
		Stack<Character> stack = new Stack<>();

		// Push each character onto the stack
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}

		// Pop the characters from the stack to create the reversed string
		StringBuilder reversedString = new StringBuilder();
		while (!stack.isEmpty()) {
			reversedString.append(stack.pop());
		}

		return reversedString.toString();
	}

	public static void main(String[] args) {
		String str = "Hello, World!";
		System.out.println("Original String: " + str);

		String reversedStr = reverseString(str);
		System.out.println("Reversed String: " + reversedStr);
	}
}
