
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class _8DeleteZeroSumNodes {

	public static ListNode deleteZeroSumSublists(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		Map<Integer, ListNode> map = new HashMap<>();
		int sum = 0;

		ListNode current = dummy;

		while (current != null) {
			sum += current.val;

			if (map.containsKey(sum)) {
				ListNode prev = map.get(sum).next;
				int tempSum = sum + prev.val;

				while (prev != current) {
					map.remove(tempSum);
					prev = prev.next;
					tempSum += prev.val;
				}

				map.get(sum).next = current.next;
			} else {
				map.put(sum, current);
			}

			current = current.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(-3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(1);

		ListNode result = deleteZeroSumSublists(head);

		System.out.println("Linked List after deletion:");
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
