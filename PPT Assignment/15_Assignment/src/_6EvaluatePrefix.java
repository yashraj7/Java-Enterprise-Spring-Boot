import java.util.Arrays;
import java.util.Stack;

public class _6EvaluatePrefix {

	public static int evaluatePostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();

		// Traverse each character in the postfix expression
		for (int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);

			// If the character is a digit, push it onto the stack
			if (Character.isDigit(ch)) {
				stack.push(ch - '0');
			} else {
				// If the character is an operator, pop two operands from the stack
				int operand2 = stack.pop();
				int operand1 = stack.pop();

				// Perform the corresponding operation based on the operator
				switch (ch) {
				case '+':
					stack.push(operand1 + operand2);
					break;
				case '-':
					stack.push(operand1 - operand2);
					break;
				case '*':
					stack.push(operand1 * operand2);
					break;
				case '/':
					stack.push(operand1 / operand2);
					break;
				}
			}
		}

		// The final result will be the top element of the stack
		return stack.pop();
	}

	public static void main(String[] args) {
		String postfix = "23*5+";

		int result = evaluatePostfix(postfix);
		System.out.println("Result: " + result);
	}
}
