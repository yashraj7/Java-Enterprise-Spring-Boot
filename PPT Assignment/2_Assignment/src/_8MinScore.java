
public class _8MinScore {
	public static int minimumScore(int[] nums, int k) {
		int n = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}

		if (min + k >= max - k) {
			return 0;
		}

		return max - min - 2 * k;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		int k = 0;

		int minScore = minimumScore(nums, k);

		System.out.println("Output: " + minScore);
	}
}
