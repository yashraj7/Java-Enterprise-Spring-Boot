
public class _4FindRepeatedNumber {
	public static int findRepeatedNumber(int[] nums) {
		// Phase 1: Detect the intersection point of the cycle
		int tortoise = nums[0];
		int hare = nums[0];

		// Move tortoise one step and hare two steps until they meet
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (tortoise != hare);

		// Phase 2: Find the starting point of the cycle
		tortoise = nums[0];

		// Move tortoise and hare one step at a time until they meet
		while (tortoise != hare) {
			tortoise = nums[tortoise];
			hare = nums[hare];
		}

		return tortoise;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 2 };
		int repeatedNumber = findRepeatedNumber(nums);
		System.out.println("Repeated number: " + repeatedNumber);
	}
}
