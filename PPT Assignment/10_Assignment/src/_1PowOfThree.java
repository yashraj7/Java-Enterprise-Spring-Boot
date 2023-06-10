
public class _1PowOfThree {
	public static boolean isPowerOfThree(int n) {
		if (n == 1) {
			// Base case: n is already 1, which is 3^0
			return true;
		}

		if (n <= 0 || n % 3 != 0) {
			// Base case: n is not a positive multiple of 3
			return false;
		}

		// Recursive case: divide n by 3 and check if the result is a power of three
		return isPowerOfThree(n / 3);
	}

	public static void main(String[] args) {
		int n = 27;
		boolean result = isPowerOfThree(n);
		System.out.println(n + " is a power of three? " + result);
	}
}
