import java.util.HashSet;

public class _5ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();

		for (int num : nums) {
			if (set.contains(num)) {
				return true; // Duplicate found
			}
			set.add(num);
		}

		return false; // No duplicates found
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 }; // Example array

		boolean hasDuplicates = containsDuplicate(nums);
		System.out.println(hasDuplicates); // Output: true
	}
}
