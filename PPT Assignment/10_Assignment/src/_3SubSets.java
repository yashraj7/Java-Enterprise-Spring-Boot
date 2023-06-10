
public class _3SubSets {
	public static void printAllSubsets(String set) {
		printSubsets(set, "", 0);
	}

	private static void printSubsets(String set, String subset, int index) {
		if (index == set.length()) {
			System.out.println(subset);
			return;
		}

		// Include the current character
		printSubsets(set, subset + set.charAt(index), index + 1);

		// Exclude the current character
		printSubsets(set, subset, index + 1);
	}

	public static void main(String[] args) {
		String set = "abc";
		System.out.println("All subsets of the set: " + set);
		printAllSubsets(set);
	}
}
