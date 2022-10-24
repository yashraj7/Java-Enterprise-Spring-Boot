public class Name {
    public static void main(String[] args) {
        int n = 8;
        for (int i = 0; i < n; i++) {
            //YS
            for (int j = 0; j < n; j++) {
                if((i==j && i < (n-1)/2)||
                (i+j == n-1))
                System.out.print("*");
                else
                System.out.print(" ");
            }
            //A
            for (int j = 0; j < n; j++) {
                if((i == 0 && j > 1 && j < ((3*(n))/4)-1)||
                (i == (n-1)/2 && j < (3*n)/4)||
                (j == 0 && i > 0)||
                (j == (3*n)/4) && i > 0)
                System.out.print("*");
                else
                System.out.print(" ");
            }
            //S
            for (int j = 0; j < n; j++) {
                if((i == 0 && j < (3*n)/4)||
                (j == 0 && i < (n-1)/2)||
                (i == (n-1)/2 && j < (3*n)/4)||
                (j == (3*n)/4 - 1 && i > (n-1)/2)||
                (i == n-1 && j < (3*n)/4))
                System.out.print("*");
                else
                System.out.print(" ");
            }
            //H
            for (int j = 0; j < n; j++) {
                if((j == 0)||(j == (3*n)/4-1)||
                (i == (n-1)/2 && j < (3*n)/4))
                System.out.print("*");
                else
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
