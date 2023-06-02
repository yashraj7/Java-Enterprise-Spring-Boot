import java.util.Arrays;

/*Question 1
Given an integer array nums of length n and an integer target, find three integers
in nums such that the sum is closest to the target.
Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2

Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
public class _1_ThreeSum {

	    public static int threeSumClosest(int[] nums, int target) {
	        Arrays.sort(nums);
	        int closestSum = nums[0] + nums[1] + nums[2];

	        for (int i = 0; i < nums.length - 2; i++) {
	            // Skip duplicate elements
	            if (i > 0 && nums[i] == nums[i - 1]) {
	                continue;
	            }

	            int left = i + 1;
	            int right = nums.length - 1;

	            while (left < right) {
	                int sum = nums[i] + nums[left] + nums[right];

	                if (sum == target) {
	                    return sum; // Exact match found, early termination
	                }

	                // Update the closest sum if the current sum is closer to the target
	                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
	                    closestSum = sum;
	                }

	                if (sum < target) {
	                    left++;
	                } else {
	                    right--;
	                }
	            }
	        }

	        return closestSum;
	    }

	    public static void main(String[] args) {
	        int[] nums = {-1, 2, 1, -4};
	        int target = 1;

	        int result = threeSumClosest(nums, target);
	        System.out.println("Output: " + result);
	    }

}
