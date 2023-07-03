package demo;

public class _4LargestOfThreeNumber {

	public static void main(String[] args) {
		int a = 20, b = 30, c = 50;
		if (a > b && a > c)
			System.out.println(a);
		else if (b > c)
			System.out.println(b);
		else
			System.out.println(c);
	}
}
