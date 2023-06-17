
public class _4CopySpecialLL {
	class Node {
		int data;
		Node next;
		Node random;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.random = null;
		}
	}

	public static Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		// Create a copy of each node and insert it between the original nodes
		Node current = head;
		while (current != null) {
			Node copy = new Node(current.data);
			copy.next = current.next;
			current.next = copy;
			current = copy.next;
		}

		// Update the random pointers of the copied nodes
		current = head;
		while (current != null) {
			if (current.random != null) {
				current.next.random = current.random.next;
			}
			current = current.next.next;
		}

		// Separate the original and copied lists
		current = head;
		Node copiedHead = head.next;
		Node copiedCurrent = copiedHead;
		while (current != null) {
			current.next = current.next.next;
			if (copiedCurrent.next != null) {
				copiedCurrent.next = copiedCurrent.next.next;
			}
			current = current.next;
			copiedCurrent = copiedCurrent.next;
		}

		return copiedHead;
	}

	public static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print("[" + current.data + ", ");

			if (current.random != null) {
				System.out.print(current.random.data);
			} else {
				System.out.print("null");
			}

			System.out.print("] -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		head.random = head.next.next;
		head.next.random = head.next.next.next.next;
		head.next.next.random = head;
		head.next.next.next.random = head.next;
		head.next.next.next.next.random = head.next.next;

		System.out.println("Original List:");
		printList(head);

		Node copiedHead = copyRandomList(head);

		System.out.println("Copied List:");
		printList(copiedHead);
	}
}
