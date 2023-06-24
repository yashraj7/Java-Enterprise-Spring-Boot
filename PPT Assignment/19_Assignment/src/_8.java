import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _8 {

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();

		// Count the frequency of elements in nums1
		for (int num : nums1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Integer> intersection = new ArrayList<>();

		// Iterate through nums2 and check for common elements
		for (int num : nums2) {
			if (map.containsKey(num) && map.get(num) > 0) {
				intersection.add(num);
				map.put(num, map.get(num) - 1);
			}
		}

		// Convert the list to an array
		int[] result = new int[intersection.size()];
		int i = 0;
		for (int num : intersection) {
			result[i++] = num;
		}

		return result;
	}

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] result = intersect(nums1, nums2);

		// Print the intersection array
		for (int num : result) {
			System.out.print(num + " ");
		}
		// Output: 2 2
	}
}
