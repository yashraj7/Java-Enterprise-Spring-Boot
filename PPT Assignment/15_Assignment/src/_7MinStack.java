import java.util.Stack;

public class _7MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	/** initialize your data structure here */
	public _7MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int val) {
		stack.push(val);
		if (minStack.isEmpty() || val <= minStack.peek()) {
			minStack.push(val);
		}
	}

	public void pop() {
		int val = stack.pop();
		if (val == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		_7MinStack minStack = new _7MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // Output: -3
		minStack.pop();
		System.out.println(minStack.top()); // Output: 0
		System.out.println(minStack.getMin()); // Output: -2
	}
}
