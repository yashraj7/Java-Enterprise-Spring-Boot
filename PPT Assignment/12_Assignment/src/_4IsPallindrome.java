
public class _4IsPallindrome {
	public static class ListNode {
		char val;
		ListNode next;

		ListNode(char val) {
			this.val = val;
		}
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true; // An empty list or a single node is considered a palindrome
		}

		ListNode slow = head;
		ListNode fast = head;

		// Find the middle node using the fast and slow pointer technique
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Reverse the second half of the list
		ListNode reversedSecondHalf = reverseList(slow);

		// Compare the first half with the reversed second half
		ListNode curr1 = head;
		ListNode curr2 = reversedSecondHalf;

		while (curr2 != null) {
			if (curr1.val != curr2.val) {
				return false; // Nodes don't match, not a palindrome
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		return true;
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode('a');
		head1.next = new ListNode('b');
		head1.next.next = new ListNode('c');
		head1.next.next.next = new ListNode('b');
		head1.next.next.next.next = new ListNode('a');

		boolean isPalindrome1 = isPalindrome(head1);
		System.out.println("Is the linked list a palindrome? " + isPalindrome1);

		ListNode head2 = new ListNode('r');
		head2.next = new ListNode('a');
		head2.next.next = new ListNode('c');
		head2.next.next.next = new ListNode('e');
		head2.next.next.next.next = new ListNode('c');
		head2.next.next.next.next.next = new ListNode('a');
		head2.next.next.next.next.next.next = new ListNode('r');

		boolean isPalindrome2 = isPalindrome(head2);
		System.out.println("Is the linked list a palindrome? " + isPalindrome2);
	}
}
