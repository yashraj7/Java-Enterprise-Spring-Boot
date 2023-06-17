import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class _7NextGreaterNode {
	public static int[] nextLargerNodes(ListNode head) {
		List<Integer> values = new ArrayList<>();
		ListNode current = head;

		while (current != null) {
			values.add(current.val);
			current = current.next;
		}

		int[] result = new int[values.size()];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < values.size(); i++) {
			while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {
				result[stack.pop()] = values.get(i);
			}
			stack.push(i);
		}

		return result;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(7);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(5);

		int[] result = nextLargerNodes(head);

		System.out.println("Next Greater Nodes:");
		for (int value : result) {
			System.out.print(value + " ");
		}
	}
}
