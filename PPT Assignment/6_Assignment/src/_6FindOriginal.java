import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _6FindOriginal {
	public static int[] findOriginalArray(int[] changed) {
		if (changed.length % 2 != 0) {
			return new int[0];
		}

		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : changed) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		List<Integer> originalList = new ArrayList<>();
		for (int num : changed) {
			if (frequencyMap.getOrDefault(num, 0) > 0) {
				frequencyMap.put(num, frequencyMap.get(num) - 1);
				int half = num / 2;
				if (frequencyMap.getOrDefault(half, 0) > 0) {
					originalList.add(half);
					frequencyMap.put(half, frequencyMap.get(half) - 1);
				} else {
					return new int[0];
				}
			}
		}

		int[] originalArray = new int[originalList.size()];
		for (int i = 0; i < originalList.size(); i++) {
			originalArray[i] = originalList.get(i);
		}

		return originalArray;
	}

	public static void main(String[] args) {
		int[] changed = { 1, 3, 4, 2, 6, 8 };
		int[] original = findOriginalArray(changed);
		for (int num : original) {
			System.out.print(num + " ");
		}
	}
}
