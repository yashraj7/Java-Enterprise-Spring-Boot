
public class _2Rows {

	public static int countCompleteRows(int n) {
		int k = 0;
		while (n >= k + 1) {
			k++;
			n -= k;
		}
		return k;
	}

	public static void main(String[] args) {
		int n = 5;
		int completeRows = countCompleteRows(n);
		System.out.println("Number of complete rows: " + completeRows);
	}

}
