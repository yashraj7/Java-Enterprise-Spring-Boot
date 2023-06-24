import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _4CheckIncreasingOrder {

	public static boolean checkArrangeInIncreasingOrder(Queue<Integer> originalQueue) {
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> tempQueue = new LinkedList<>();
		int expectedElement = 1;

		while (!originalQueue.isEmpty()) {
			if (originalQueue.peek() == expectedElement) {
				originalQueue.remove();
				expectedElement++;
			} else {
				if (!stack.isEmpty() && stack.peek() == expectedElement) {
					tempQueue.add(stack.pop());
					expectedElement++;
				} else {
					stack.push(originalQueue.remove());
				}
			}
		}

		while (!stack.isEmpty()) {
			if (stack.peek() == expectedElement) {
				tempQueue.add(stack.pop());
				expectedElement++;
			} else {
				return false;
			}
		}

		originalQueue.addAll(tempQueue);
		return originalQueue.isEmpty();
	}

	public static void main(String[] args) {
		Queue<Integer> originalQueue = new LinkedList<>();
		originalQueue.add(3);
		originalQueue.add(2);
		originalQueue.add(1);

		boolean canArrange = checkArrangeInIncreasingOrder(originalQueue);
		System.out.println("Can be arranged in increasing order: " + canArrange);
		System.out.println("Queue after arranging: " + originalQueue);
	}
}
