import java.util.Arrays;
import java.util.Stack;

public class _4ReverseStack {

	public static void reverseStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			reverseStack(stack);
			insertAtBottom(stack, temp);
		}
	}

	private static void insertAtBottom(Stack<Integer> stack, int value) {
		if (stack.isEmpty()) {
			stack.push(value);
		} else {
			int temp = stack.pop();
			insertAtBottom(stack, value);
			stack.push(temp);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println("Original Stack: " + stack);
		reverseStack(stack);
		System.out.println("Reversed Stack: " + stack);
	}
}
