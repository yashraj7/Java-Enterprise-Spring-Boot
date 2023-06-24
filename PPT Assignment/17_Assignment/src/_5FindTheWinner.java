
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class _5FindTheWinner {

	public int findTheWinner(int n, int k) {
		// Create a circular linked list representing the friends
		ListNode head = new ListNode(1);
		ListNode current = head;
		for (int i = 2; i <= n; i++) {
			current.next = new ListNode(i);
			current = current.next;
		}
		current.next = head; // Make the linked list circular

		// Traverse the linked list and remove friends until only one is left
		while (current.next != current) {
			// Move k-1 steps in a clockwise direction
			for (int i = 0; i < k - 1; i++) {
				current = current.next;
			}
			// Remove the friend at the current position
			current.next = current.next.next;
		}
		return current.val;
	}

	public static void main(String[] args) {
		int n = 7;
		int k = 3;
		_5FindTheWinner game = new _5FindTheWinner();
		int winner = game.findTheWinner(n, k);
		System.out.println("Winner: " + winner);
	}
}
