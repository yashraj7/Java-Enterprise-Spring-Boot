import java.util.Arrays;

public class _5Anagram {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int n = s1.length();
        char[] hash1 = new char[26];
        char[] hash2 = new char[26];

        for (int i = 0; i < n; i++) {
            hash1[s1.charAt(i) - 'a']++;
            hash2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(hash1, hash2);
    }

    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "act";
        System.out.println(isAnagram(s1, s2));
    }

}
