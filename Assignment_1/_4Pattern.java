public class _4Pattern {
    public static void main(String[] args) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {s
                if ((i + j >= (n - 1) + (n - 1) / 2) || 
                (i - j >= (n - 1) / 2))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
