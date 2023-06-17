
public class _1DetectAndRemoveLoop {
	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node detectAndRemoveLoop(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node slow = head;
		Node fast = head;

		// Detect the loop using Floyd's Cycle-Finding Algorithm
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		// If there is no loop, return the head
		if (slow != fast) {
			return head;
		}

		// Move slow to the head and find the node where the loop starts
		slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}

		// Remove the loop by setting the next of the last node to null
		fast.next = null;

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
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		// Create a loop
		head.next.next.next.next.next = head.next;

		System.out.println("Original List:");
		printList(head);

		head = detectAndRemoveLoop(head);

		System.out.println("List after removing the loop:");
		printList(head);
	}
}
