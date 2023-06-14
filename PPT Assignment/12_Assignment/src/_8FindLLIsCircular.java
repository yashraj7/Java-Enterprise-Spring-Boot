
public class _8FindLLIsCircular {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static boolean isCircular(ListNode head) {
		if (head == null || head.next == null) {
			return false; // List has less than 2 nodes, cannot be circular
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true; // Fast pointer caught up to slow pointer, list is circular
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		return false; // Fast pointer reached the end of the list, list is not circular
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(3);
		list1.next.next.next = new ListNode(4);
		list1.next.next.next.next = list1; // Creating a circular list

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(2);
		list2.next.next = new ListNode(3);
		list2.next.next.next = new ListNode(4);

		System.out.println("Is list1 circular? " + isCircular(list1));
		System.out.println("Is list2 circular? " + isCircular(list2));
	}
}
