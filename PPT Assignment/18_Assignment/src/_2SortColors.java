
public class _2SortColors {
	public void sortColors(int[] a) {
		int low = 0;
		int mid = 0;
		int high = a.length - 1;
		while (mid <= high) {
			switch (a[mid]) {
			case 0: {
				swap(a, low, mid);
				mid++;
				low++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				swap(a, mid, high);
				high--;
				break;
			}
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
