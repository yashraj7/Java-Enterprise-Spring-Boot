
public class _6UniqueElement {
	public static int findSingleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1 };
		int singleNumber = findSingleNumber(nums);
		System.out.println("Output: " + singleNumber);
	}

}
