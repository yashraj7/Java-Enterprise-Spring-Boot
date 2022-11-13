// WAP to find the maximum occurring character in a String.
public class _8MaxOccuringChar {
    public static char maxOccur(String s1) {
        s1 = s1.toLowerCase();
        int n = s1.length();
        int max = 1;
        char[] hash1 = new char[26];

        for (int i = 0; i < n; i++) {
            hash1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hash1[i] > max)
                max = Math.max(i,max);
        }
        return (char)(max + 'a');
    }
    public static void main(String[] args) {
        String s1 = "Hi yash How you doing";
        s1 = s1.replace(" ", "");
        System.out.println(maxOccur(s1));
    }
}
