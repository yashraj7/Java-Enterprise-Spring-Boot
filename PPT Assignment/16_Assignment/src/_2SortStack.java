import java.util.Stack;

public class _2SortStack {
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();

		while (!stack.isEmpty()) {
			int temp = stack.pop();

			while (!tempStack.isEmpty() && tempStack.peek() > temp) {
				stack.push(tempStack.pop());
			}

			tempStack.push(temp);
		}

		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(2);
		stack.push(8);
		stack.push(1);
		stack.push(3);

		System.out.println("Original Stack: " + stack);
		sortStack(stack);
		System.out.println("Sorted Stack: " + stack);
	}
}
