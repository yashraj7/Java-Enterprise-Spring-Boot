import java.util.Arrays;
import java.util.Stack;

public class _1FindNextGreater {

	public static int[] findNextGreater(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		Arrays.fill(result, -1);
		Stack<Integer> stack = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				result[i] = arr[stack.peek()];
			}
			stack.push(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 2, 25, 7, 8, 6, 10 };
		int[] result = findNextGreater(arr);

		System.out.println("Element\tNext Greater Element");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "\t\t" + result[i]);
		}
	}
}
