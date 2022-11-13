// WAP to find if String contains all unique characters.
public class _7UniqueChar {
    public static boolean isUnique(String s1) {
        s1 = s1.toLowerCase();
        int n = s1.length();
        char[] hash1 = new char[26];

        for (int i = 0; i < n; i++) {
            hash1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hash1[i] > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abcdefghIjklm nopqrsstu vwxYz";//s is repeated
        s1 = s1.replace(" ", "");
        System.out.println(isUnique(s1));
    }
}
