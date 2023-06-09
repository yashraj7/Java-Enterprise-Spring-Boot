
public class _8FindProducts {
	public static long findProduct(int[] arr, int index) {
		if (index == arr.length - 1) {
			return arr[index];
		} else {
			return arr[index] * findProduct(arr, index + 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		long product = findProduct(arr, 0);
		System.out.println("Product of all elements in the array: " + product);
	}
}
