
public class _4LengthOfString {
	public static int calculateLength(String str) {
		if (str.isEmpty()) {
			// Base case: The string is empty, its length is 0
			return 0;
		}

		// Recursive case: Remove the first character from the string
		// and recursively calculate the length of the remaining substring
		return 1 + calculateLength(str.substring(1));
	}

	public static void main(String[] args) {
		String str = "Hello, World!";
		int length = calculateLength(str);
		System.out.println("Length of the string: " + length);
	}
}
