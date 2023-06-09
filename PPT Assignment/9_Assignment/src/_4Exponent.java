
public class _4Exponent {
	public static int calculateExponent(int N, int P) {
		if (P == 0) {
			return 1;
		} else {
			return N * calculateExponent(N, P - 1);
		}
	}

	public static void main(String[] args) {
		int N = 5;
		int P = 2;
		int result = calculateExponent(N, P);
		System.out.println(N + " raised to the power of " + P + " is: " + result);
	}
}
