import java.util.ArrayList;
import java.util.List;

public class _7AllPermutations {

	public static void printPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		generatePermutations(str.toCharArray(), 0, permutations);
		for (String permutation : permutations) {
			System.out.println(permutation);
		}
	}

	private static void generatePermutations(char[] arr, int index, List<String> permutations) {
		if (index == arr.length - 1) {
			// Base case: Reached the last character, add the current permutation to the
			// list
			permutations.add(String.valueOf(arr));
			return;
		}

		for (int i = index; i < arr.length; i++) {
			// Swap the current character with each character after it
			swap(arr, index, i);

			// Generate permutations by fixing the current character and recursively
			// permuting the remaining characters
			generatePermutations(arr, index + 1, permutations);

			// Restore the original order of characters by swapping them back
			swap(arr, index, i);
		}
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		String str = "abc";
		System.out.println("Permutations of the string: " + str);
		printPermutations(str);
	}
}