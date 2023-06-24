
public class _4 {
	public static void moveZeroes(int[] nums) {
		int n = nums.length;
		int nonZeroIndex = 0; // Index to keep track of the next non-zero element

		// Traverse the array
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				// If the current element is non-zero, move it to the next non-zero index
				nums[nonZeroIndex] = nums[i];
				nonZeroIndex++;
			}
		}

		// Fill the remaining elements with zeroes
		while (nonZeroIndex < n) {
			nums[nonZeroIndex] = 0;
			nonZeroIndex++;
		}
	}

	public static void main(String[] args) {

		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);

		// Print the modified array
		for (int num : nums) {
			System.out.print(num + " ");
		}
		// Output: 1 3 12 0 0
	}
}
