import java.util.HashMap;
import java.util.Map;

class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int majorityElement = 0;
        int majorityCount = 0;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            if (count > majorityCount) {
                majorityElement = num;
                majorityCount = count;
            }
        }

        return majorityElement;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums = {3, 2, 3};
        int majority = solution.majorityElement(nums);
        System.out.println("Majority element: " + majority);
    }
}
