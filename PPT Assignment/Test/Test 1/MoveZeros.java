
public class MoveZeros {

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 3, 12 };
		MoveIt(a);

	}

	private static void MoveIt(int[] a) {
		int s = -1;
		int e = 0;
		int n = a.length;
		while (e < n) {
			if (a[e] != 0)
				swap(a, ++s, e);
			e++;
		}
		for (int i : a)
			System.out.println(i);

	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
