import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _1NearestGreaterFreq {

	public static int[] findNearestGreaterFrequency(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int i = n - 1; i >= 0; i--) {
			int frequency = frequencyMap.getOrDefault(arr[i], 0);
			frequencyMap.put(arr[i], frequency + 1);

			while (!stack.isEmpty() && frequencyMap.get(arr[i]) >= frequencyMap.get(arr[stack.peek()])) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = arr[stack.peek()];
			}

			stack.push(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 4, 2, 1 };
		int[] result = findNearestGreaterFrequency(arr);

		System.out.println("Original Array: " + Arrays.toString(arr));
		System.out.println("Result Array: " + Arrays.toString(result));
	}
}
