
public class _3MountainArray {
	public static boolean validMountainArray(int[] arr) {
		int n = arr.length;
		if (n < 3) {
			return false;
		}

		int i = 0;
		while (i + 1 < n && arr[i] < arr[i + 1]) {
			i++;
		}

		if (i == 0 || i == n - 1) {
			return false;
		}

		while (i + 1 < n && arr[i] > arr[i + 1]) {
			i++;
		}

		return i == n - 1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1 };
		boolean isValid = validMountainArray(arr);
		System.out.println(isValid);
	}
}
