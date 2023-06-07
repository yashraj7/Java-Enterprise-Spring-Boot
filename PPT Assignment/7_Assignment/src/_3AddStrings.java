
public class _3AddStrings {
	public static String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();

		int carry = 0;
		int i = num1.length() - 1;
		int j = num2.length() - 1;

		while (i >= 0 || j >= 0 || carry != 0) {
			int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
			int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

			int sum = digit1 + digit2 + carry;
			carry = sum / 10;
			int digit = sum % 10;

			sb.append(digit);

			i--;
			j--;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String num1 = "11";
		String num2 = "123";

		String sum = addStrings(num1, num2);

		System.out.println("Output: " + sum);
	}
}
