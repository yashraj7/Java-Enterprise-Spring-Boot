/*Question 3
A permutation of an array of integers is an arrangement of its members into a
sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr:
[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
*/
public class _3NextPermutation {
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		if (nums == null || n <= 1)
			return;
		int i = n - 2;
		while (i >= 0 && nums[i] >= nums[i + 1])
			i--;
		if (i < 0) {
			reverse(nums, 0, n - 1);
		} else {
			int j = n - 1;
			while (nums[j] <= nums[i])
				j--;
			swap(nums, i, j);
			reverse(nums, i + 1, n - 1);
		}
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j)
			swap(nums, i++, j--);

	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 1 };
		_3NextPermutation obj = new _3NextPermutation();
		obj.nextPermutation(a);
		for (int ele : a)
			System.out.print(ele + " ");

	}
}
