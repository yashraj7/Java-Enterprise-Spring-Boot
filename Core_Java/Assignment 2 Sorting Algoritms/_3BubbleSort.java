import javax.swing.plaf.synth.SynthSeparatorUI;

public class _3BubbleSort {
    public static void swap(int [] arr , int i , int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 1, 2, 3, 5 };
        int n = arr.length;
        int flag = 0;
        for (int i = 0; i < n && flag == 0; i++) {
            flag = 1;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j])
                    {
                        flag = 0;
                        swap(arr, j - 1, j);
                    }
            }
        }
        for (int ele : arr)
            System.out.print(ele + " ");
    }
}
