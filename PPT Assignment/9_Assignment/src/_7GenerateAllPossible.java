
public class _7GenerateAllPossible {
	public static void generatePermutations(String str, int start, int end) {
		if (start == end) {
			System.out.println(str);
		} else {
			for (int i = start; i <= end; i++) {
				str = swap(str, start, i);
				generatePermutations(str, start + 1, end);
				str = swap(str, start, i); // backtrack to restore the original string
			}
		}
	}

	public static String swap(String str, int i, int j) {
		char[] charArray = str.toCharArray();
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		String S = "ABC";
		generatePermutations(S, 0, S.length() - 1);
	}
}
