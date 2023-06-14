
public class _6SkipDelet {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode skipDelete(ListNode head, int M, int N) {
		if (head == null || M <= 0 || N <= 0) {
			return head; // Invalid input
		}

		ListNode current = head;
		int count = 1; // Start with 1 since the head node is always retained

		while (current != null) {
			// Retain M nodes
			while (count < M && current != null) {
				current = current.next;
				count++;
			}

			if (current == null) {
				break; // Reached the end of the list
			}

			// Delete N nodes
			for (int i = 0; i < N && current != null; i++) {
				ListNode nextNode = current.next;
				current.next = null; // Disconnect the current node from the list
				current = nextNode;
			}

			count = 1; // Reset the count for the next iteration
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
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next.next.next.next = new ListNode(10);

		int M = 2;
		int N = 3;

		System.out.println("Linked List before skipping and deleting:");
		printList(head);

		ListNode modifiedList = skipDelete(head, M, N);

		System.out.println("Linked List after skipping and deleting:");
		printList(modifiedList);
	}
}
