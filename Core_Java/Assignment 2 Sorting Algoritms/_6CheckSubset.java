import java.util.HashSet;
import java.util.Set;

public class _6CheckSubset {
    public static boolean checkSubset(int[] a, int[] sub) {
        Set<Integer> s = new HashSet<>();
        for (int ele : a)
            s.add(ele);
        int prevSize = s.size();
        for (int ele : sub)
            s.add(ele);
        if (prevSize == s.size())
            return true;
            
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 1, 2, 3, 5 };
        int[] sub = { 6, 1, 2 };
        System.out.println(checkSubset(arr, sub));
    }

}
