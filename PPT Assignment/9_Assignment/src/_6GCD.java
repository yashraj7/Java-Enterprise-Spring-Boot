
public class _6GCD {
	public static int findNthTerm(int a, int d, int N) {
		if (N == 1) {
			return a;
		} else {
			return findNthTerm(a, d, N - 1) + d;
		}
	}

	public static void main(String[] args) {
		int a = 2;
		int d = 1;
		int N = 5;
		int nthTerm = findNthTerm(a, d, N);
		System.out.println("The " + N + "th term of the series is: " + nthTerm);
	}
}
