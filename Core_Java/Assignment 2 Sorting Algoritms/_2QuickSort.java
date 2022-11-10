public class _2QuickSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] a, int l, int h) {
        int pivot = a[h];
        int j = l;
        int i = j - 1;
        for (j = l; j <= h-1; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }

        }
        swap(a, i + 1, h);
        return i + 1;
    }

    public static void quickSort(int[] a, int l, int h) {
        if (l < h) {
            int pi = partition(a, l, h);
            quickSort(a, l, pi - 1);
            quickSort(a, pi + 1, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 1, 2, 3, 5 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        for (int ele : arr)
            System.out.print(ele + " ");
    }

}
