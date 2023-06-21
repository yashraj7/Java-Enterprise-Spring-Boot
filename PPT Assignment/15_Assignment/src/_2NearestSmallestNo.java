import java.util.Arrays;
import java.util.Stack;

public class _2NearestSmallestNo {

	public static int[] findNearestSmaller(int[] arr) {
	        int n = arr.length;
	        int[] result = new int[n];
	        Arrays.fill(result, -1);
	        Stack<Integer> stack = new Stack<>();

	        for (int i = 0; i < n; i++) {
	            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
	                stack.pop();
	            }
	            if (!stack.isEmpty()) {
	                result[i] = arr[stack.peek()];
	            }
	            stack.push(i);
	        }

	        return result;
	    }

	public static void main(String[] args) {
	        int[] arr = { 4, 5, 2, 10, 8 };
	        int[] result = findNearestSmaller(arr);

	        System.out.println("Element\tNearest Smaller Element");
	        for (int i = 0; i < arr.length; i++) {
	            System.out.println(arr[i] + "\t\t" + result[i]);
	        }
	    }
}
