//  WAP to print Duplicates characters from the String.
public class _2PrintDuplicateChar {
    public static void main(String[] args) {
        String s = "hiii Thisss is Javvaaa";
        // Output : i s v a
        char[] a = s.toCharArray();

        for (int j = 1; j < a.length; j++) {
            int cnt = 1;
            while (j < a.length && a[j] == a[j - 1]) {
                if (cnt == 1)
                    System.out.print(a[j] + " ");
                cnt++;
                j++;

            }

        }

    }

}
