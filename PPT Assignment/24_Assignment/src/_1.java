import java.util.HashMap;
import java.util.Map;

class RomanToInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> values = new HashMap<>();
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);

		int result = 0;
		int prevValue = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			int currentValue = values.get(s.charAt(i));

			if (currentValue >= prevValue) {
				result += currentValue;
			} else {
				result -= currentValue;
			}

			prevValue = currentValue;
		}

		return result;
	}

	public static void main(String[] args) {
		RomanToInteger solution = new RomanToInteger();
		String romanNumeral = "XXVII";
		int result = solution.romanToInt(romanNumeral);
		System.out.println("Roman numeral " + romanNumeral + " is equal to " + result);
	}
}
