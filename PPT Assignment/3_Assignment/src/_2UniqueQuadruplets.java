import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array nums of n integers, return an array of all the unique quadruplets
[nums[a], nums[b], nums[c], nums[d]] such that:
           ● 0 <= a, b, c, d < n
           ● a, b, c, and d are distinct.
           ● nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]*/

public class _2UniqueQuadruplets {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		int n = nums.length;
		List<List<Integer>> lt = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int newtarget = target - nums[j] - nums[i];
				int start = j + 1, end = n - 1;

				while (start < end) {

					int two_sum = nums[start] + nums[end];

					if (two_sum < newtarget)
						start++;
					else if (two_sum > newtarget)
						end--;
					else {
						List<Integer> al = new ArrayList<>();
						al.add(nums[i]);
						al.add(nums[j]);
						al.add(nums[start]);
						al.add(nums[end]);
						lt.add(al);

						while (start < end && nums[start] == al.get(2))
							start++;
						while (start < end && nums[end] == al.get(3))
							end--;
					}
				}
				while (j + 1 < n && nums[j + 1] == nums[j])
					j++;
			}
			while (i + 1 < n && nums[i + 1] == nums[i])
				i++;
		}
		return lt;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;

		List<List<Integer>> result = fourSum(nums, target);
		System.out.println("Output: " + result);
	}

}
