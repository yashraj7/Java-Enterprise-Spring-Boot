import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _8FindOriginalArray {
	public static int[] findOriginalArray(int[] changed) {
		if (changed.length % 2 != 0) {
			return new int[0];
		}

		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : changed) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}

		List<Integer> result = new ArrayList<>();
		for (int num : changed) {
			if (countMap.containsKey(num) && countMap.get(num) > 0) {
				countMap.put(num, countMap.get(num) - 1);
				if (countMap.containsKey(num * 2) && countMap.get(num * 2) > 0) {
					countMap.put(num * 2, countMap.get(num * 2) - 1);
					result.add(num);
				} else {
					return new int[0]; // If the doubled element is not present, it is not a doubled array
				}
			}
		}

		int[] original = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			original[i] = result.get(i);
		}

		return original;
	}

	public static void main(String[] args) {
		int[] changed = { 1, 3, 4, 2, 6, 8 };
		int[] original = findOriginalArray(changed);
		for (int num : original) {
			System.out.print(num + " ");
		}
	}

}
