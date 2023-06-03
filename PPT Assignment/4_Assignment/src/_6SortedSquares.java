import java.util.Arrays;

public class _6SortedSquares {
	public static int[] sortedSquares(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int left = 0;
		int right = n - 1;
		int index = n - 1;

		while (left <= right) {
			int leftSquare = nums[left] * nums[left];
			int rightSquare = nums[right] * nums[right];

			if (leftSquare > rightSquare) {
				result[index] = leftSquare;
				left++;
			} else {
				result[index] = rightSquare;
				right--;
			}

			index--;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -4, -1, 0, 3, 10 };
		int[] squaredArray = sortedSquares(nums);
		System.out.println(Arrays.toString(squaredArray));
		// Output: [0, 1, 9, 16, 100]
	}

}
