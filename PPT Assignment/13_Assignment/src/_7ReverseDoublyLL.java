
public class _7ReverseDoublyLL {
	public static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node current = head;
		Node temp = null;

		// Swap next and previous pointers for all nodes
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;

			current = current.prev;
		}

		// Update the new head
		if (temp != null) {
			head = temp.prev;
		}

		return head;
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
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.prev = head;
		head.next.next = new Node(3);
		head.next.next.prev = head.next;
		head.next.next.next = new Node(4);
		head.next.next.next.prev = head.next.next;

		System.out.println("Original List:");
		printList(head);

		Node reversedHead = reverseList(head);

		System.out.println("Reversed List:");
		printList(reversedHead);
	}
}
