import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _5Intersection {
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		for (int num : nums1) {
			set1.add(num);
		}

		Set<Integer> intersect = new HashSet<>();
		for (int num : nums2) {
			if (set1.contains(num)) {
				intersect.add(num);
			}
		}

		int[] result = new int[intersect.size()];
		int i = 0;
		for (int num : intersect) {
			result[i++] = num;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] intersection = intersection(nums1, nums2);
		System.out.println("Intersection: " + Arrays.toString(intersection));
	}
}
