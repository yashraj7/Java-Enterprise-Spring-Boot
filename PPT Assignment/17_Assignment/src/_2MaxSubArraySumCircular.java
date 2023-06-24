
public class _2MaxSubArraySumCircular {
	public static int maxSubarraySumCircular(int[] nums) {
		int totalSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int minSum = Integer.MAX_VALUE;
		int currentMax = 0;
		int currentMin = 0;

		// Calculate total sum and maximum/minimum subarray sums
		for (int num : nums) {
			totalSum += num;

			// Maximum subarray sum within the circular array
			currentMax = Math.max(currentMax + num, num);
			maxSum = Math.max(maxSum, currentMax);

			// Minimum subarray sum within the circular array
			currentMin = Math.min(currentMin + num, num);
			minSum = Math.min(minSum, currentMin);
		}

		// If all elements are negative, return the maximum element
		if (maxSum < 0) {
			return maxSum;
		}

		// Maximum subarray sum that wraps around the circular array
		int circularSum = totalSum - minSum;

		// Return the maximum of the two cases
		return Math.max(maxSum, circularSum);
	}

	public static void main(String[] args) {
		int[] nums = { 1, -2, 3, -2 };
		int maxSum = maxSubarraySumCircular(nums);
		System.out.println("Maximum circular subarray sum: " + maxSum);
	}
}
