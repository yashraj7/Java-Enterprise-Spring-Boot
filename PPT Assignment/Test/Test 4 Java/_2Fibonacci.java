package demo;

public class _2Fibonacci {

	public static void main(String[] args) {
		fibonacci(7);
	}

	private static void fibonacci(int n) {

		int a = 0, b = 1;
		System.out.println(0);
		System.out.println(1);
		for (int i = 0; i < n - 2; i++) {
			int c = a + b;
			a = b;
			b = c;
			System.out.println(b);
		}
	}
}
