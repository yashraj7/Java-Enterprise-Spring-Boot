
public class _3TransposeMatrix {
	public int[][] rotate(int[][] matrix) {
		int R = matrix.length;
		int C = matrix[0].length;
		for (int i = 0; i < R; i++) {
			for (int j = i; j < C; j++) {
				swap(matrix, i, j);
			}
		}
		return matrix;
	}

	public void swap(int[][] a, int i, int j) {
		int temp = a[i][j];
		a[i][j] = a[j][i];
		a[j][i] = temp;
	}

	public void reverse(int[][] a, int i, int C) {
		int start = 0;
		int end = C - 1;
		while (start < end) {
			int temp = a[i][start];
			a[i][start] = a[i][end];
			a[i][end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		_3TransposeMatrix obj = new _3TransposeMatrix();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] transposeMatrix = obj.rotate(matrix);

		// Print the transpose matrix
		for (int i = 0; i < transposeMatrix.length; i++) {
			for (int j = 0; j < transposeMatrix[0].length; j++) {
				System.out.print(transposeMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
