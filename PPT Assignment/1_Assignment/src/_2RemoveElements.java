import java.util.Arrays;

public class _2RemoveElements {
	public int removeElement(int[] nums, int val) {
		int k = 0; // number of elements not equal to val

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[k] = nums[i]; // move the element to the front
				k++; // increment the count of elements not equal to val
			}
		}

		return k;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 2, 3 };
		int val = 3;

		_2RemoveElements sol = new _2RemoveElements();
		int k = sol.removeElement(nums, val);

		System.out.println("Output: " + k + ", nums = " + Arrays.toString(nums));
	}

}
