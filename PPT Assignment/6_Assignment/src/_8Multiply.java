
public class _8Multiply {
	public static int[][] multiply(int[][] mat1, int[][] mat2) {
		int m = mat1.length;
		int k = mat1[0].length;
		int n = mat2[0].length;

		int[][] result = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat1[i][j] == 0) {
					continue;
				}
				for (int p = 0; p < k; p++) {
					if (mat1[i][p] != 0 && mat2[p][j] != 0) {
						result[i][j] += mat1[i][p] * mat2[p][j];
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] mat1 = { { 1, 0, 0 }, { -1, 0, 3 } };

		int[][] mat2 = { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };

		int[][] result = multiply(mat1, mat2);

		for (int[] row : result) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
