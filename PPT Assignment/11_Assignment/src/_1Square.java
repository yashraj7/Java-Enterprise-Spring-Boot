
public class _1Square {
	public static int sqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}

		int left = 1;
		int right = x / 2;
		int result = 0;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (mid <= x / mid) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int x = 16;
		int sqrtResult = sqrt(x);
		System.out.println("Square root of " + x + " = " + sqrtResult);
	}
}
