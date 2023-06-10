
public class _5Compress {

	public static int compress(char[] chars) {
		int writeIndex = 0; // index to write the compressed characters
		int count = 1; // count of consecutive repeating characters

		for (int i = 1; i <= chars.length; i++) {
			if (i < chars.length && chars[i] == chars[i - 1]) {
				count++;
			} else {
				chars[writeIndex++] = chars[i - 1]; // write the character

				if (count > 1) {
					// write the count as separate characters if it is 10 or longer
					String countStr = String.valueOf(count);
					for (char c : countStr.toCharArray()) {
						chars[writeIndex++] = c;
					}
				}

				count = 1; // reset the count
			}
		}

		return writeIndex; // return the new length of the array
	}

	public static void main(String[] args) {
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		int newLength = compress(chars);
		System.out.println(newLength); // Output: 6
		for (int i = 0; i < newLength; i++) {
			System.out.print(chars[i] + " "); // Output: a 2 b 2 c 3
		}
	}
}