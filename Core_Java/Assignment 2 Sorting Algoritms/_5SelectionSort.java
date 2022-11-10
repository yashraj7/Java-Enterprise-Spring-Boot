public class _5SelectionSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 1, 2, 3, 5 };
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if(arr[min] >= arr[j] )
                    min = j;
            }
            if(i != min)
            swap(arr, i, min);
        }
        for (int ele : arr)
            System.out.print(ele + " ");
    }
}
