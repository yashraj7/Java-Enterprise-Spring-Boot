
public class _6 {
	public static int[] mergeArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		int[] merged = new int[n1 + n2];

		int i = 0; // Index for nums1
		int j = 0; // Index for nums2
		int k = 0; // Index for merged array

		// Compare elements from both arrays and merge them in sorted order
		while (i < n1 && j < n2) {
			if (nums1[i] <= nums2[j]) {
				merged[k++] = nums1[i++];
			} else {
				merged[k++] = nums2[j++];
			}
		}

		// Copy remaining elements from nums1, if any
		while (i < n1) {
			merged[k++] = nums1[i++];
		}

		// Copy remaining elements from nums2, if any
		while (j < n2) {
			merged[k++] = nums2[j++];
		}

		return merged;
	}

	public static void main(String[] args) {

		int[] nums1 = { 1, 3, 5, 7 };
		int[] nums2 = { 2, 4, 6, 8 };
		int[] merged = mergeArrays(nums1, nums2);

		// Print the merged array
		for (int num : merged) {
			System.out.print(num + " ");
		}
		// Output: 1 2 3 4 5 6 7 8
	}
}
