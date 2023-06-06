import java.util.HashSet;
import java.util.Set;

public class _6ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> numSet = new HashSet<>();

		for (int num : nums) {
			if (numSet.contains(num)) {
				return true; // Duplicate found
			}
			numSet.add(num);
		}

		return false; // No duplicates found
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };

		boolean containsDuplicate = containsDuplicate(nums);

		System.out.println("Output: " + containsDuplicate);
	}
}
