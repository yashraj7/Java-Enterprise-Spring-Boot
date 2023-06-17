
public class _2AddOne {
	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node addOne(Node head) {
		// Reverse the linked list to start from the least significant digit
		Node reversedHead = reverse(head);

		Node current = reversedHead;
		int carry = 1; // Start with a carry of 1

		// Traverse the linked list and add 1 to each digit
		while (current != null) {
			int sum = current.data + carry;
			carry = sum / 10; // Compute the carry for the next digit
			current.data = sum % 10; // Update the current digit

			if (carry == 0) {
				break; // No further carry, we can stop
			}

			current = current.next; // Move to the next digit
		}

		// If there is still a carry, create a new node and update the head
		if (carry != 0) {
			Node newHead = new Node(carry);
			newHead.next = reversedHead;
			reversedHead = newHead;
		}

		// Reverse the linked list again to restore the original order
		return reverse(reversedHead);
	}

	public static Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		Node next;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	public static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(9);
		head.next = new Node(9);
		head.next.next = new Node(9);

		System.out.println("Original List:");
		printList(head);

		head = addOne(head);

		System.out.println("List after adding 1:");
		printList(head);
	}
}
