import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);

            if (anagramMap.containsKey(sortedStr)) {
                anagramMap.get(sortedStr).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                anagramMap.put(sortedStr, newList);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = solution.groupAnagrams(strs);
        System.out.println("Anagram Groups: " + groups);
    }
}
