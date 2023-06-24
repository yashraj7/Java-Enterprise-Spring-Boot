
public class _4MaxGap {
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		// Find the maximum element in the array
		int maxNum = nums[0];
		for (int num : nums) {
			maxNum = Math.max(maxNum, num);
		}

		// Perform Radix Sort on the array
		int exp = 1;
		int[] sorted = new int[nums.length];

		while (maxNum / exp > 0) {
			int[] count = new int[10];

			// Counting sort based on the current digit (exp)
			for (int num : nums) {
				int digit = (num / exp) % 10;
				count[digit]++;
			}

			// Calculate cumulative count
			for (int i = 1; i < 10; i++) {
				count[i] += count[i - 1];
			}

			// Build the sorted array based on the current digit (exp)
			for (int i = nums.length - 1; i >= 0; i--) {
				int digit = (nums[i] / exp) % 10;
				sorted[count[digit] - 1] = nums[i];
				count[digit]--;
			}

			// Copy the sorted array back to the original array
			System.arraycopy(sorted, 0, nums, 0, nums.length);

			exp *= 10;
		}

		// Find the maximum gap in the sorted array
		int maxGap = 0;
		for (int i = 1; i < nums.length; i++) {
			maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
		}

		return maxGap;
	}
}
