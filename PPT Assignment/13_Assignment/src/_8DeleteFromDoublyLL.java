
public class _8DeleteFromDoublyLL {
	public static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node deleteNode(Node head, int position) {
		if (head == null) {
			return null;
		}

		// If position is 0, delete the head node
		if (position == 0) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
			return head;
		}

		Node current = head;
		int currentPosition = 0;

		// Traverse to the node at the given position
		while (current != null && currentPosition < position) {
			current = current.next;
			currentPosition++;
		}

		// If current is null, position is out of range
		if (current == null) {
			return head;
		}

		// Update the pointers of the adjacent nodes
		current.prev.next = current.next;
		if (current.next != null) {
			current.next.prev = current.prev;
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

		int positionToDelete = 2;
		head = deleteNode(head, positionToDelete);

		System.out.println("List after deleting node at position " + positionToDelete + ":");
		printList(head);
	}
}
