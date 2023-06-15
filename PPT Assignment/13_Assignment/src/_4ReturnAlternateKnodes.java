
public class _4ReturnAlternateKnodes {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode reverseAlternateKNodes(ListNode head, int k) {
		if (head == null || k == 1) {
			return head; // No need to reverse
		}

		ListNode current = head;
		ListNode prevGroupTail = null;
		ListNode newGroupHead = null;
		int count = 0;
		boolean reverse = true;

		while (current != null) {
			count++;
			ListNode next = current.next;

			if (count % k == 0) {
				if (reverse) {
					if (prevGroupTail != null) {
						prevGroupTail.next = current;
					} else {
						head = current;
					}
					prevGroupTail = newGroupHead;
					newGroupHead = current.next;
					reverseGroup(newGroupHead, k - 1);
				} else {
					prevGroupTail = current;
					newGroupHead = current.next;
				}
				reverse = !reverse;
			}

			current = next;
		}

		return head;
	}

	private static void reverseGroup(ListNode head, int k) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;

		while (current != null && k > 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			k--;
		}

		if (head != null) {
			head.next = next;
		}
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
		list.next.next.next.next.next.next.next.next = new ListNode(9);

		int k = 3;

		System.out.println("Original Linked List:");
		printList(list);

		ListNode reversedList = reverseAlternateKNodes(list, k);

		System.out.println("Modified Linked List (Reverse every alternate " + k + " nodes):");
		printList(reversedList);
	}
}
