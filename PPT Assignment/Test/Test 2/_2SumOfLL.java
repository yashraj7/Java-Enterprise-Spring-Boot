package in.code.mocktest2;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

public class _2SumOfLL {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int sum = carry;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;
			sum %= 10;
			curr.next = new ListNode(sum);
			curr = curr.next;
		}

		if (carry > 0) {
			curr.next = new ListNode(carry);
		}

		return dummyHead.next;
	}

	public static void main(String[] args) {
		// Create linked list 1: 2 -> 4 -> 3
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		// Create linked list 2: 5 -> 6 -> 4
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		// Add the two numbers
		ListNode result = addTwoNumbers(l1, l2);

		// Print the sum as a linked list
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
