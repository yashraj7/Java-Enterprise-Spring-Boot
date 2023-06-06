import java.util.HashSet;
import java.util.Set;

public class _8FindError {
	public static int[] findErrorNums(int[] nums) {
		int[] result = new int[2];

		Set<Integer> numSet = new HashSet<>();
		int duplicate = -1;
		int missing = -1;

		// Find the duplicate number
		for (int num : nums) {
			if (numSet.contains(num)) {
				duplicate = num;
			}
			numSet.add(num);
		}

		// Find the missing number
		for (int i = 1; i <= nums.length; i++) {
			if (!numSet.contains(i)) {
				missing = i;
				break;
			}
		}

		result[0] = duplicate;
		result[1] = missing;

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 4 };

		int[] errorNums = findErrorNums(nums);

		System.out.print("Output: [");
		for (int i = 0; i < errorNums.length; i++) {
			System.out.print(errorNums[i]);
			if (i != errorNums.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
