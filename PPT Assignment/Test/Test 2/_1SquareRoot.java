package in.code.mocktest2;

public class _1SquareRoot {

	public static void main(String[] args) {
		System.out.println(squareRoot(13));
	}

	private static int squareRoot(int n) {
		double l = 1;
		double h = n;
		while (h - l > 1e-3) {

			double mid = l + (h - l) / 2.0;
			if (mid * mid > n)
				h = mid;
			else
				l = mid;
		}
		return (int) Math.floor(l);

	}
}
