
public class _5PlusOne {
	public static int[] plusOne(int[] digits) {
		int n = digits.length;

		// Iterate through digits in reverse order
		for (int i = n - 1; i >= 0; i--) {
			// Increment the current digit by 1
			digits[i]++;

			// If the digit is less than 10, no further carry required
			if (digits[i] < 10) {
				return digits;
			}

			// If the digit becomes 10, set it to 0 and move to the next digit
			digits[i] = 0;
		}

		// If all digits become 10, add an additional digit with a value of 1
		int[] newDigits = new int[n + 1];
		newDigits[0] = 1;
		return newDigits;
	}

	public static void main(String[] args) {
		int[] digits = { 1, 2, 3 };
		int[] result = plusOne(digits);
		System.out.print("Output: ");
		for (int digit : result) {
			System.out.print(digit + " ");
		}
	}

}
