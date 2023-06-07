
public class _5WordReverse {
	public static String reverseStr(String s, int k) {
		char[] arr = s.toCharArray();
		int n = arr.length;

		for (int i = 0; i < n; i += 2 * k) {
			int start = i;
			int end = Math.min(i + k - 1, n - 1);

			while (start < end) {
				char temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}

		return new String(arr);
	}

	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;

		String reversed = reverseStr(s, k);

		System.out.println("Output: " + reversed);
	}
}
