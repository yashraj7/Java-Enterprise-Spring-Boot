
public class _5 {
	public static void rearrangeArray(int[] nums) {
		int n = nums.length;
		int i = 0; // Index for positive numbers
		int j = 0; // Index for negative numbers

		// Find the index of the first positive number
		while (i < n && nums[i] < 0) {
			i++;
		}

		// Rearrange the array in alternating fashion
		while (i < n && j < n) {
			// Find the next negative number
			while (j < n && nums[j] >= 0) {
				j++;
			}

			// If both positive and negative numbers are present
			if (i < n && j < n) {
				// Rotate the subarray between i and j
				rotateArray(nums, i, j);
				i += 2;
				j++;
			}
		}
	}

	// Helper method to rotate the subarray between start and end indices
	private static void rotateArray(int[] nums, int start, int end) {
		int temp = nums[end];
		for (int i = end; i > start; i--) {
			nums[i] = nums[i - 1];
		}
		nums[start] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -2, 3, -4, 5, -6, 7, -8 };
		rearrangeArray(nums);

		// Print the rearranged array
		for (int num : nums) {
			System.out.print(num + " ");
		}
		// Output: 1 -2 3 -4 5 -6 7 -8
	}
}
