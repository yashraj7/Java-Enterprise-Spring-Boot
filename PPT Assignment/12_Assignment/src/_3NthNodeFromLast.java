
public class _3NthNodeFromLast {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode findNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;

		// Move the fast pointer n nodes ahead
		for (int i = 0; i < n; i++) {
			if (fast == null) {
				return null; // The list has less than n nodes
			}
			fast = fast.next;
		}

		// Move both pointers simultaneously until the fast pointer reaches the end
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		int n = 2;
		ListNode nthNode = findNthFromEnd(head, n);

		if (nthNode != null) {
			System.out.println("The " + n + "th node from the end is: " + nthNode.val);
		} else {
			System.out.println("Invalid input or the list does not contain the " + n + "th node from the end.");
		}
	}
}
