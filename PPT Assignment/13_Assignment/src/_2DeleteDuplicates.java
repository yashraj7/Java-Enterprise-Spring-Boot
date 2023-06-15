
public class _2DeleteDuplicates {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head; // List has less than 2 nodes, no duplicates to remove
		}

		ListNode current = head;
		while (current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next; // Remove the duplicate node
			} else {
				current = current.next; // Move to the next node
			}
		}

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
		ListNode list = new ListNode(1);
		list.next = new ListNode(1);
		list.next.next = new ListNode(2);
		list.next.next.next = new ListNode(3);
		list.next.next.next.next = new ListNode(3);
		list.next.next.next.next.next = new ListNode(4);

		System.out.println("Original Linked List:");
		printList(list);

		ListNode newList = deleteDuplicates(list);

		System.out.println("Modified Linked List (Duplicates Removed):");
		printList(newList);
	}
}
