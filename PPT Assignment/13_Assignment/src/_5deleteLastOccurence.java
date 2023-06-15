
public class _5deleteLastOccurence {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode deleteLastOccurrence(ListNode head, int key) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = null;
		ListNode lastOccurrence = null;
		ListNode current = dummy;

		// Find the last occurrence of the key
		while (current.next != null) {
			if (current.next.val == key) {
				lastOccurrence = current.next;
				prev = current;
			}
			current = current.next;
		}

		// Delete the last occurrence if found
		if (lastOccurrence != null) {
			prev.next = lastOccurrence.next;
		}

		return dummy.next;
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
		list.next.next.next = new ListNode(2);
		list.next.next.next.next = new ListNode(4);
		list.next.next.next.next.next = new ListNode(2);
		list.next.next.next.next.next.next = new ListNode(5);

		int key = 2;

		System.out.println("Original Linked List:");
		printList(list);

		ListNode modifiedList = deleteLastOccurrence(list, key);

		System.out.println("Modified Linked List (Last occurrence of " + key + " deleted):");
		printList(modifiedList);
	}
}
