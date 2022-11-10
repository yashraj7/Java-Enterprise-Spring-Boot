public class _4MergeSort {
    public static void merger(int[] a, int l, int h, int mid) {
        int[] temp = new int[h - l + 1];
        int idx1 = l;
        int idx2 = mid + 1;
        int k = 0;
        while (idx1 <= mid && idx2 <= h) {
            if (a[idx1] <= a[idx2])
                temp[k++] = a[idx1++];
            else
                temp[k++] = a[idx2++];

        }
        while (idx1 <= mid)
            temp[k++] = a[idx1++];

        while (idx2 <= h)
            temp[k++] = a[idx2++];

        for (int i = l; i <= h; i++)
            a[i] = temp[i - l];

    }

    public static void mergeSort(int[] a, int s, int e) {
        if (s < e) {
            int mid = (s + e) >> 1;
            mergeSort(a, s, mid);
            mergeSort(a, mid + 1, e);
            merger(a, s, e, mid);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 1, 2, 3, 5 };
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        for (int ele : arr)
            System.out.print(ele + " ");
    }

}
