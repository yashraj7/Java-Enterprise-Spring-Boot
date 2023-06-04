
public class _1Convert {

	public static int[][] convertTo2DArray(int[] original, int m, int n) {
		if (original.length != m * n) {
			return new int[0][0];
		}

		int[][] result = new int[m][n];
		for (int i = 0; i < original.length; i++) {
			int row = i / n; // Calculate the row index
			int col = i % n; // Calculate the column index
			result[row][col] = original[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6 };
		int m = 2;
		int n = 3;

		int[][] result = convertTo2DArray(original, m, n);
		print2DArray(result);
	}

	public static void print2DArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
