import java.util.*;

class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        FindKClosestElements solution = new FindKClosestElements();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> closestElements = solution.findClosestElements(arr, k, x);
        System.out.println("K closest elements: " + closestElements);
    }
}
