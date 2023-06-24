import java.util.Stack;

public class _8MaxAbsouluteDifference {

	public static int maxAbsoluteDifference(int[] arr) {
		int n = arr.length;
		int[] leftSmaller = new int[n];
		int[] rightSmaller = new int[n];

		// Find NSL (Nearest Smaller Element on the Left) for each element
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) {
				stack.pop();
			}
			leftSmaller[i] = stack.isEmpty() ? 0 : stack.peek();
			stack.push(arr[i]);
		}

		// Clear the stack and find NSR (Nearest Smaller Element on the Right) for each
		// element
		stack.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) {
				stack.pop();
			}
			rightSmaller[i] = stack.isEmpty() ? 0 : stack.peek();
			stack.push(arr[i]);
		}

		// Calculate the maximum absolute difference
		int maxDiff = 0;
		for (int i = 0; i < n; i++) {
			int diff = Math.abs(leftSmaller[i] - rightSmaller[i]);
			maxDiff = Math.max(maxDiff, diff);
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 8 };
		int maxDiff = maxAbsoluteDifference(arr);
		System.out.println("Maximum absolute difference: " + maxDiff);
	}
}
