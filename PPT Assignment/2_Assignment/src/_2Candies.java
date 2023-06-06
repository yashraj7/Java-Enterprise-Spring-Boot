import java.util.HashSet;
import java.util.Set;

public class _2Candies {

	public static int maxCandies(int[] candyType) {
		int n = candyType.length;
		int maxAllowed = n / 2;

		Set<Integer> uniqueCandies = new HashSet<>();
		for (int candy : candyType) {
			uniqueCandies.add(candy);
		}

		return Math.min(uniqueCandies.size(), maxAllowed);
	}

	public static void main(String[] args) {
		int[] candyType = { 1, 1, 2, 2, 3, 3 };

		int maxCandies = maxCandies(candyType);

		System.out.println("Output: " + maxCandies);
	}
}
