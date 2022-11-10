import java.util.ArrayList;

// T(n) = O(maximum element of array)
// S(n) = O(n) Using additional array
public class _1FindDuplicate {
    public static int[] findDuplicate(int[] a, int n) {
        ArrayList<Integer> al = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int ele : a) {
            if (ele > max)
                max = ele;
        }
        int[] hash = new int[max + 1];
        for (int idx : a) {
            hash[idx]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 1)
                al.add(i);
        }
        int[] ans = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ans[i] = al.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 3, 3, 5, 2 };
        // ans = 2,3,5;
        int[] ans = findDuplicate(arr, arr.length);
        for (int ele : ans)
            System.out.print(ele+" ");
    }

}
