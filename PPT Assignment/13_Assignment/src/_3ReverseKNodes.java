
public class _3ReverseKNodes {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode reverseKNodes(ListNode head, int k) {
		if (head == null || k == 1) {
			return head; // No need to reverse
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prevGroupTail = dummy;
		int count = 0;

		while (head != null) {
			count++;
			if (count % k == 0) {
				prevGroupTail = reverseGroup(prevGroupTail, head.next);
				head = prevGroupTail.next;
			} else {
				head = head.next;
			}
		}

		return dummy.next;
	}

	private static ListNode reverseGroup(ListNode prevGroupTail, ListNode nextGroupHead) {
		ListNode prev = prevGroupTail.next;
		ListNode current = prev.next;

		while (current != nextGroupHead) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		ListNode newGroupTail = prevGroupTail.next;
		prevGroupTail.next.next = nextGroupHead;
		prevGroupTail.next = prev;

		return newGroupTail;
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
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);
		list.next.next.next.next.next = new ListNode(6);
		list.next.next.next.next.next.next = new ListNode(7);
		list.next.next.next.next.next.next.next = new ListNode(8);

		int k = 3;

		System.out.println("Original Linked List:");
		printList(list);

		ListNode reversedList = reverseKNodes(list, k);

		System.out.println("Modified Linked List (Reversed every " + k + " nodes):");
		printList(reversedList);
	}
}
