
public class _7InsertAlternate {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void insertAlternate(ListNode first, ListNode second) {
		if (first == null || second == null) {
			return; // Invalid input
		}

		ListNode currentFirst = first;
		ListNode currentSecond = second;

		while (currentFirst != null && currentSecond != null) {
			ListNode nextFirst = currentFirst.next;
			ListNode nextSecond = currentSecond.next;

			// Insert the currentSecond node after the currentFirst node
			currentFirst.next = currentSecond;
			currentSecond.next = nextFirst;

			// Move the pointers to the next nodes
			currentFirst = nextFirst;
			currentSecond = nextSecond;
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
		ListNode first = new ListNode(1);
		first.next = new ListNode(3);
		first.next.next = new ListNode(5);

		ListNode second = new ListNode(2);
		second.next = new ListNode(4);
		second.next.next = new ListNode(6);
		second.next.next.next = new ListNode(8);

		System.out.println("First Linked List:");
		printList(first);

		System.out.println("Second Linked List:");
		printList(second);

		insertAlternate(first, second);

		System.out.println("Modified First Linked List:");
		printList(first);
	}
}
