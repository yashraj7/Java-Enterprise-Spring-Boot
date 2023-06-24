import java.util.Stack;

public class _8FindPattern {
	public static boolean find132pattern(int[] nums) {
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();
		int third = Integer.MIN_VALUE;

		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] < third) {
				return true;
			}

			while (!stack.isEmpty() && nums[i] > stack.peek()) {
				third = stack.pop();
			}

			stack.push(nums[i]);
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 }; // Example array

		boolean hasPattern = find132pattern(nums);
		System.out.println(hasPattern); // Output: false
	}
}
