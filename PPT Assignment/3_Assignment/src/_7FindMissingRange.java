import java.util.ArrayList;
import java.util.List;

public class _7FindMissingRange {
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		int n = nums.length;
		int currentNumber = lower;

		for (int i = 0; i < n; i++) {
			if (nums[i] > currentNumber) {
				result.add(getRange(currentNumber, nums[i] - 1));
			}
			currentNumber = nums[i] + 1;
		}

		if (currentNumber <= upper) {
			result.add(getRange(currentNumber, upper));
		}

		return result;
	}

	private static String getRange(int start, int end) {
		return start == end ? String.valueOf(start) : start + "->" + end;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0;
		int upper = 99;
		List<String> missingRanges = findMissingRanges(nums, lower, upper);
		System.out.println("Output: " + missingRanges);
	}

}
