
public class _5OddEvenLL {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode oddHead = head;
		ListNode evenHead = head.next;
		ListNode oddTail = oddHead;
		ListNode evenTail = evenHead;

		ListNode current = evenHead.next;
		int index = 3;

		while (current != null) {
			if (index % 2 != 0) {
				oddTail.next = current;
				oddTail = oddTail.next;
			} else {
				evenTail.next = current;
				evenTail = evenTail.next;
			}

			current = current.next;
			index++;
		}

		oddTail.next = evenHead;
		evenTail.next = null;

		return oddHead;
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

		head = oddEvenList(head);

		System.out.println("Reordered List:");
		printList(head);
	}
}
