import java.util.Arrays;

public class _7LIS {
	    public static int lengthOfLIS(int[] nums) {
	        int n = nums.length;
	        int[] dp = new int[n];
	        int maxLength = 1;

	        // Initialize the dp array with 1
	        Arrays.fill(dp, 1);

	        for (int i = 1; i < n; i++) {
	            for (int j = 0; j < i; j++) {
	                if (nums[i] > nums[j]) {
	                    dp[i] = Math.max(dp[i], dp[j] + 1);
	                }
	            }
	            maxLength = Math.max(maxLength, dp[i]);
	        }

	        return maxLength;
	    }

	    public static void main(String[] args) {
	        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18}; // Example array

	        int length = lengthOfLIS(nums);
	        System.out.println(length); // Output: 4
	    }
	}
