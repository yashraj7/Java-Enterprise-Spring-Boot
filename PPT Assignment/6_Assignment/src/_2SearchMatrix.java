
public class _2SearchMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int left = 0;
		int right = m * n - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int row = mid / n;
			int col = mid % n;
			int current = matrix[row][col];

			if (current == target) {
				return true;
			} else if (current < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 3;
		boolean found = searchMatrix(matrix, target);
		System.out.println(found);
	}
}
