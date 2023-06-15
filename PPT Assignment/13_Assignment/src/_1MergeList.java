
public class _1MergeList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode mergeLists(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null; // Invalid input
		}

		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (head1 != null && head2 != null) {
			if (head1.val >= head2.val) {
				current.next = head1;
				head1 = head1.next;
			} else {
				current.next = head2;
				head2 = head2.next;
			}
			current = current.next;
		}

		if (head1 != null) {
			current.next = head1;
		}

		if (head2 != null) {
			current.next = head2;
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
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(3);
		list1.next.next = new ListNode(5);

		ListNode list2 = new ListNode(2);
		list2.next = new ListNode(4);
		list2.next.next = new ListNode(6);

		System.out.println("First Linked List:");
		printList(list1);

		System.out.println("Second Linked List:");
		printList(list2);

		ListNode mergedList = mergeLists(list1, list2);

		System.out.println("Merged Linked List (Greater Node):");
		printList(mergedList);
	}
}
