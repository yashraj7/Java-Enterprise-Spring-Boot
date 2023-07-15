class UglyNumber {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for (int i = 1; i < n; i++) {
            int minUgly = Math.min(factor2, Math.min(factor3, factor5));
            uglyNumbers[i] = minUgly;

            if (minUgly == factor2)
                factor2 = 2 * uglyNumbers[++index2];
            if (minUgly == factor3)
                factor3 = 3 * uglyNumbers[++index3];
            if (minUgly == factor5)
                factor5 = 5 * uglyNumbers[++index5];
        }

        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        UglyNumber solution = new UglyNumber();
        int n = 10;
        int nthUgly = solution.nthUglyNumber(n);
        System.out.println("The " + n + "th Ugly Number is: " + nthUgly);
    }
}
