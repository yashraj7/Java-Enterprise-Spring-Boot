import java.util.HashSet;
import java.util.Set;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Set<Character> uniqueChars = new HashSet<>();

        while (end < s.length()) {
            char currentChar = s.charAt(end);
            if (!uniqueChars.contains(currentChar)) {
                uniqueChars.add(currentChar);
                end++;
                maxLength = Math.max(maxLength, uniqueChars.size());
            } else {
                uniqueChars.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();
        String input = "abcabcbb";
        int length = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + length);
    }
}
