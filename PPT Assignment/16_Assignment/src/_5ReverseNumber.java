import java.util.Stack;

public class _5ReverseNumber {

	public static int reverseNumber(int number) {
		Stack<Integer> stack = new Stack<>();

		while (number > 0) {
			int digit = number % 10;
			stack.push(digit);
			number /= 10;
		}

		int reversedNumber = 0;
		int multiplier = 1;

		while (!stack.isEmpty()) {
			int digit = stack.pop();
			reversedNumber += digit * multiplier;
			multiplier *= 10;
		}

		return reversedNumber;
	}

	public static void main(String[] args) {
		int number = 365;
		int reversedNumber = reverseNumber(number);

		System.out.println("Reversed number: " + reversedNumber);
	}
}
