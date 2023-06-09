
public class _2FindSum {
	public static int calculateSum(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n + calculateSum(n - 1);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		int sum = calculateSum(n);
		System.out.println("Sum of the first " + n + " natural numbers is: " + sum);
	}
}
