public class _3Pallindrome {
    public static boolean checkPallindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "2552";//Output : true
        int n = s.length();
        System.out.println(checkPallindrome(s.toLowerCase(), 0, n - 1));       
    }
}
