import java.util.HashMap;
import java.util.Map;

public class _2Programatic {
	public static boolean isStrobogrammatic(String num) {
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');

		int left = 0;
		int right = num.length() - 1;

		while (left <= right) {
			char c1 = num.charAt(left);
			char c2 = num.charAt(right);

			if (!map.containsKey(c1) || map.get(c1) != c2) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public static void main(String[] args) {
		String num = "69";

		boolean isStrobogrammatic = isStrobogrammatic(num);

		System.out.println("Output: " + isStrobogrammatic);
	}
}
