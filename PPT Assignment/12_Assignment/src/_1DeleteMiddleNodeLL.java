
public class _1DeleteMiddleNodeLL {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode deleteMiddle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}

		prev.next = slow.next;
		return head;
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
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);

		System.out.println("Original Linked List:");
		printList(head1);

		ListNode newHead1 = deleteMiddle(head1);

		System.out.println("Modified Linked List:");
		printList(newHead1);

		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(4);
		head2.next.next.next.next = new ListNode(5);
		head2.next.next.next.next.next = new ListNode(6);

		System.out.println("Original Linked List:");
		printList(head2);

		ListNode newHead2 = deleteMiddle(head2);

		System.out.println("Modified Linked List:");
		printList(newHead2);
	}
}
