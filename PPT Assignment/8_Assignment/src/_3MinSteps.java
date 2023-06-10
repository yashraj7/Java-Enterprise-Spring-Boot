
public class _3MinSteps {
	public static int minSteps(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		// Initialize a 2D array to store the minimum steps
		int[][] dp = new int[m + 1][n + 1];

		// Fill the first row and first column
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}

		// Fill the remaining cells of the 2D array
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					// Characters match, no step needed
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					// Characters don't match, take the minimum of two options:
					// 1. Delete a character from word1
					// 2. Delete a character from word2
					dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// Return the minimum steps required
		return dp[m][n];
	}

	public static void main(String[] args) {
		String word1 = "sea";
		String word2 = "eat";
		System.out.println(minSteps(word1, word2)); // Output: 2
	}
}
