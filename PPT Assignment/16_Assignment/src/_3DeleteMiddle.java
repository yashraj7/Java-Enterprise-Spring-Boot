import java.util.Stack;

public class _3DeleteMiddle {

	public static void deleteMiddleElement(Stack<Integer> stack) {
		int size = stack.size();
		deleteMiddleUtil(stack, size, 0);
	}

	private static void deleteMiddleUtil(Stack<Integer> stack, int size, int current) {
		if (stack.isEmpty()) {
			return;
		}

		int element = stack.pop();

		if (current != size / 2) {
			deleteMiddleUtil(stack, size, current + 1);
			stack.push(element);
		} else {
			deleteMiddleUtil(stack, size, current + 1);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println("Original Stack: " + stack);
		deleteMiddleElement(stack);
		System.out.println("Stack after deleting middle element: " + stack);
	}
}
