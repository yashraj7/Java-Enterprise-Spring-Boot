
public class _5RemoveLoop {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void removeLoop(ListNode head) {
		if (head == null || head.next == null) {
			return; // No loop present
		}

		ListNode slow = head;
		ListNode fast = head;

		// Find the meeting point of the fast and slow pointers
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break; // Loop detected
			}
		}

		// If loop is present, move one pointer to the head and advance both pointers
		// until they meet
		if (slow == fast) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null; // Remove the loop by setting the next of the last node to null
		}
	}

	public static void printList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		// Create a loop by connecting the last node to the second node (value 2)
		head.next.next.next.next.next = head.next;

		System.out.println("Linked List before removing the loop:");
		printList(head);

		removeLoop(head);

		System.out.println("Linked List after removing the loop:");
		printList(head);
	}
}
