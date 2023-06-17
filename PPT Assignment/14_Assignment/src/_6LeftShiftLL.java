
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class _6LeftShiftLL {

	public static ListNode leftShift(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}

		int length = getLength(head);
		k = k % length; // Adjust k if it is larger than the length of the list

		if (k == 0) {
			return head;
		}

		ListNode current = head;
		ListNode newHead = null;

		for (int i = 1; i < k; i++) {
			current = current.next;
		}

		newHead = current.next;
		current.next = null;

		ListNode tail = newHead;
		while (tail.next != null) {
			tail = tail.next;
		}

		tail.next = head;

		return newHead;
	}

	public static int getLength(ListNode head) {
		int length = 0;
		ListNode current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("Original List:");
		printList(head);

		int k = 2;
		head = leftShift(head, k);

		System.out.println("Shifted List:");
		printList(head);
	}
}
