import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> mp = new HashMap<>();
			int n = nums.length;
			for (int i = 0; i < n; i++) {
				int comp = target - nums[i];
				if (mp.containsKey(comp))
					return new int[] { mp.get(comp), i };
				mp.put(nums[i], i);
			}
			return null;

	}
}
