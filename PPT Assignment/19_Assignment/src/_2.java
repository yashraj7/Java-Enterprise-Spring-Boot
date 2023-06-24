import java.util.ArrayList;
import java.util.List;

public class _2 {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> counts = new ArrayList<>();
		int n = nums.length;
		int[] sorted = new int[n];

		// Create a new array to store the sorted order of nums
		int[] indexes = new int[n];
		for (int i = 0; i < n; i++) {
			indexes[i] = i;
		}

		// Perform merge sort and count the number of smaller elements
		int[] smallerCount = new int[n];
		mergeSort(nums, indexes, smallerCount, 0, n - 1);

		for (int count : smallerCount) {
			counts.add(count);
		}

		return counts;
	}

	private void mergeSort(int[] nums, int[] indexes, int[] smallerCount, int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = start + (end - start) / 2;
		mergeSort(nums, indexes, smallerCount, start, mid);
		mergeSort(nums, indexes, smallerCount, mid + 1, end);
		merge(nums, indexes, smallerCount, start, mid, end);
	}

	private void merge(int[] nums, int[] indexes, int[] smallerCount, int start, int mid, int end) {
		int[] merged = new int[end - start + 1];
		int leftIndex = start;
		int rightIndex = mid + 1;
		int mergedIndex = 0;
		int count = 0;

		while (leftIndex <= mid && rightIndex <= end) {
			if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
				merged[mergedIndex] = indexes[rightIndex];
				count++;
				rightIndex++;
			} else {
				merged[mergedIndex] = indexes[leftIndex];
				smallerCount[indexes[leftIndex]] += count;
				leftIndex++;
			}
			mergedIndex++;
		}

		while (leftIndex <= mid) {
			merged[mergedIndex] = indexes[leftIndex];
			smallerCount[indexes[leftIndex]] += count;
			leftIndex++;
			mergedIndex++;
		}

		while (rightIndex <= end) {
			merged[mergedIndex] = indexes[rightIndex];
			rightIndex++;
			mergedIndex++;
		}

		for (int i = start; i <= end; i++) {
			indexes[i] = merged[i - start];
		}
	}

	public static void main(String[] args) {
		_2 solution = new _2();

		int[] nums = { 5, 2, 6, 1 };
		List<Integer> counts = solution.countSmaller(nums);

		// Print the counts
		for (int count : counts) {
			System.out.print(count + " ");
		}
		// Output: 2 1 1 0
	}
}
