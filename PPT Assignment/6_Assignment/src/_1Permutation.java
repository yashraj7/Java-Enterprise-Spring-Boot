import java.util.ArrayList;
import java.util.List;

public class _1Permutation {
	public static List<Integer> reconstructPermutation(String s) {
		int n = s.length();
		List<Integer> perm = new ArrayList<>();
		int low = 0, high = n;

		for (char c : s.toCharArray()) {
			if (c == 'I') {
				perm.add(low);
				low++;
			} else if (c == 'D') {
				perm.add(high);
				high--;
			}
		}

		perm.add(low); // or high, as they would be the same

		return perm;
	}

	public static void main(String[] args) {
		String s = "IDID";
		List<Integer> result = reconstructPermutation(s);
		System.out.println(result);
	}
}
