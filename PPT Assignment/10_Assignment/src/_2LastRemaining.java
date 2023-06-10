
public class _2LastRemaining {
	public static int lastRemaining(int n) {
		if (n == 1) {
			// Base case: Only one element remaining, return it
			return 1;
		}

		if (n % 2 == 1) {
			// If the number of elements is odd, remove the last number from the remaining
			// list
			return lastRemaining(n - 1);
		} else {
			// If the number of elements is even, remove the last number from the remaining
			// list
			// after removing every other number from the left side
			return 2 * lastRemaining(n / 2);
		}
	}

	public static void main(String[] args) {
		int n = 9;
		int result = lastRemaining(n);
		System.out.println("The last remaining number is: " + result);
	}
}
