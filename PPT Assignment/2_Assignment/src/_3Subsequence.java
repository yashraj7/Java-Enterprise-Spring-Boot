import java.util.HashMap;
import java.util.Map;

public class _3Subsequence {

	public static int findLHS(int[] nums) {
		// Create a frequency map to count the occurrences of each number
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}

		int longestSubsequence = 0;

		// Iterate through the numbers in the array
		for (int num : nums) {
			// Check if there exists a number whose difference with the current number is 1
			if (freqMap.containsKey(num + 1)) {
				int currentSubsequence = freqMap.get(num) + freqMap.get(num + 1);
				longestSubsequence = Math.max(longestSubsequence, currentSubsequence);
			}
		}

		return longestSubsequence;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };

		int longestSubsequence = findLHS(nums);

		System.out.println("Output: " + longestSubsequence);
	}
}
