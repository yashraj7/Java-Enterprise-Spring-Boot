
public class _7MoveZeros {
	public static void moveZeroes(int[] nums) {
		int nonZeroIndex = 0; // Index to place non-zero elements

		// Iterate through the array
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				// If element is non-zero, move it to the nonZeroIndex position
				nums[nonZeroIndex] = nums[i];
				nonZeroIndex++;
			}
		}

		// Fill the remaining positions with 0
		while (nonZeroIndex < nums.length) {
			nums[nonZeroIndex] = 0;
			nonZeroIndex++;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };

		moveZeroes(nums);

		System.out.print("Output: [");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i != nums.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
