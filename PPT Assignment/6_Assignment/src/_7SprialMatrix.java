
public class _7SprialMatrix {
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int startRow = 0, endRow = n - 1;
		int startCol = 0, endCol = n - 1;
		int num = 1;

		while (startRow <= endRow && startCol <= endCol) {
			// Traverse the first row
			for (int col = startCol; col <= endCol; col++) {
				matrix[startRow][col] = num++;
			}
			startRow++;

			// Traverse the last column
			for (int row = startRow; row <= endRow; row++) {
				matrix[row][endCol] = num++;
			}
			endCol--;

			// Traverse the last row (if startRow <= endRow)
			if (startRow <= endRow) {
				for (int col = endCol; col >= startCol; col--) {
					matrix[endRow][col] = num++;
				}
				endRow--;
			}

			// Traverse the first column (if startCol <= endCol)
			if (startCol <= endCol) {
				for (int row = endRow; row >= startRow; row--) {
					matrix[row][startCol] = num++;
				}
				startCol++;
			}
		}

		return matrix;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] matrix = generateMatrix(n);
		for (int[] row : matrix) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
