
public class _3SearchInsert {
	public static int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid; // found the target
			} else if (nums[mid] < target) {
				left = mid + 1; // search the right half
			} else {
				right = mid - 1; // search the left half
			}
		}

		// target not found, return the index where it would be inserted
		return left;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int target = 5;

		int index = searchInsert(nums, target);

		System.out.println("Output: " + index);
	}
}
