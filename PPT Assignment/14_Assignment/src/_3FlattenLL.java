class Node {
	int data;
	Node next;
	Node bottom;

	Node(int data) {
		this.data = data;
		this.next = null;
		this.bottom = null;
	}
}

public class _3FlattenLL {

	public static Node flatten(Node head) {
		// Base case: if the head is null or there is no bottom list
		if (head == null || head.next == null) {
			return head;
		}

		// Recursive call to flatten the next node
		head.next = flatten(head.next);

		// Merge the flattened next node with the current bottom list
		head = merge(head, head.next);

		return head;
	}

	public static Node merge(Node a, Node b) {
		// Base cases
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		Node result;

		// Choose the smaller value as the new head
		if (a.data <= b.data) {
			result = a;
			result.bottom = merge(a.bottom, b);
		} else {
			result = b;
			result.bottom = merge(a, b.bottom);
		}

		return result;
	}

	public static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.bottom;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.next = new Node(10);
		head.next.next = new Node(19);
		head.next.next.next = new Node(28);

		head.bottom = new Node(7);
		head.bottom.bottom = new Node(8);
		head.bottom.bottom.bottom = new Node(30);

		head.next.bottom = new Node(20);

		head.next.next.bottom = new Node(22);
		head.next.next.bottom.bottom = new Node(50);

		head.next.next.next.bottom = new Node(35);
		head.next.next.next.bottom.bottom = new Node(40);
		head.next.next.next.bottom.bottom.bottom = new Node(45);

		System.out.println("Original List:");
		printList(head);

		head = flatten(head);

		System.out.println("Flattened List:");
		printList(head);
	}

}
