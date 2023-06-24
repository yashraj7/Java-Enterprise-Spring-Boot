import java.util.HashSet;
import java.util.Set;

public class _7 {

	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		// Add elements of nums1 to set1
		for (int num : nums1) {
			set1.add(num);
		}

		// Add common elements of nums2 to set2
		for (int num : nums2) {
			if (set1.contains(num)) {
				set2.add(num);
			}
		}

		// Convert set2 to an array
		int[] result = new int[set2.size()];
		int i = 0;
		for (int num : set2) {
			result[i++] = num;
		}

		return result;
	}

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] result = intersection(nums1, nums2);

		// Print the intersection array
		for (int num : result) {
			System.out.print(num + " ");
		}
		// Output: 2
	}
}
