
public class _3 {
	public int[] sortArray(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
		return nums;
	}

	private void mergeSort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = start + (end - start) / 2;
		mergeSort(nums, start, mid);
		mergeSort(nums, mid + 1, end);
		merge(nums, start, mid, end);
	}

	private void merge(int[] nums, int start, int mid, int end) {
		int[] merged = new int[end - start + 1];
		int leftIndex = start;
		int rightIndex = mid + 1;
		int mergedIndex = 0;

		while (leftIndex <= mid && rightIndex <= end) {
			if (nums[leftIndex] <= nums[rightIndex]) {
				merged[mergedIndex] = nums[leftIndex];
				leftIndex++;
			} else {
				merged[mergedIndex] = nums[rightIndex];
				rightIndex++;
			}
			mergedIndex++;
		}

		while (leftIndex <= mid) {
			merged[mergedIndex] = nums[leftIndex];
			leftIndex++;
			mergedIndex++;
		}

		while (rightIndex <= end) {
			merged[mergedIndex] = nums[rightIndex];
			rightIndex++;
			mergedIndex++;
		}

		for (int i = start; i <= end; i++) {
			nums[i] = merged[i - start];
		}
	}

	public static void main(String[] args) {
		_3 solution = new _3();

		int[] nums = { 5, 2, 6, 1, 3 };
		int[] sortedNums = solution.sortArray(nums);

		// Print the sorted array
		for (int num : sortedNums) {
			System.out.print(num + " ");
		}
		// Output: 1 2 3 5 6
	}
}
